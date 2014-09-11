/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.blur.command;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.apache.blur.BlurConfiguration;
import org.apache.blur.manager.IndexServer;
import org.apache.blur.manager.writer.BlurIndex;
import org.apache.blur.server.IndexSearcherClosable;
import org.apache.blur.server.ShardServerContext;
import org.apache.blur.server.TableContext;
import org.apache.blur.server.TableContextFactory;
import org.apache.hadoop.conf.Configuration;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.search.IndexSearcher;

public class ShardCommandManager extends BaseCommandManager {

  private final IndexServer _indexServer;

  public ShardCommandManager(IndexServer indexServer, int threadCount, long connectionTimeout) throws IOException {
    super(threadCount, connectionTimeout);
    _indexServer = indexServer;
  }

  public Response execute(final TableContextFactory tableContextFactory, final String commandName, final Args args)
      throws IOException, TimeoutException {
    final ShardServerContext shardServerContext = getShardServerContext();
    Callable<Response> callable = new Callable<Response>() {
      @Override
      public Response call() throws Exception {
        Command command = getCommandObject(commandName);
        if (command == null) {
          throw new IOException("Command with name [" + commandName + "] not found.");
        }
        if (command instanceof IndexReadCommand || command instanceof IndexReadCombiningCommand) {
          return toResponse(executeReadCommand(shardServerContext, command, tableContextFactory, args), command);
        }
        throw new IOException("Command type of [" + command.getClass() + "] not supported.");
      }
    };
    return submitDriverCallable(callable);
  }

  private ShardServerContext getShardServerContext() {
    ShardServerContext shardServerContext = ShardServerContext.getShardServerContext();
    if (shardServerContext == null) {
      shardServerContext = new ShardServerContext(null, null);
    }
    return shardServerContext;
  }

  @SuppressWarnings("unchecked")
  private Response toResponse(Map<Shard, Object> results, Command command) throws IOException {
    if (command instanceof IndexReadCombiningCommand) {
      IndexReadCombiningCommand<Object, Object> primitiveCommandAggregator = (IndexReadCombiningCommand<Object, Object>) command;
      Object object = primitiveCommandAggregator.combine(results);
      return Response.createNewAggregateResponse(object);
    }
    return Response.createNewShardResponse(results);
  }

  private Map<Shard, Object> executeReadCommand(ShardServerContext shardServerContext, Command command,
      final TableContextFactory tableContextFactory, final Args args) throws IOException {
    Set<String> tables = getTables(command, args);
    if (tables.isEmpty()) {
      throw new IOException("At least one table needs to specified.");
    }
    Map<String, Set<Shard>> shardMap = getShards(command, args, tables);

    Map<Shard, Future<?>> futureMap = new HashMap<Shard, Future<?>>();
    for (String table : tables) {
      Set<Shard> shardSet = shardMap.get(table);
      boolean checkShards = !shardSet.isEmpty();
      
      TableContext tableContext = tableContextFactory.getTableContext(table);
      Map<String, BlurIndex> indexes = _indexServer.getIndexes(table);
      for (Entry<String, BlurIndex> e : indexes.entrySet()) {
        String shardId = e.getKey();
        final Shard shard = new Shard(table, shardId);
        if (checkShards) {
          if (!shardSet.contains(shard)) {
            continue;
          }
        }
        final BlurIndex blurIndex = e.getValue();
        Callable<Object> callable;
        if (command instanceof IndexReadCommand) {
          final IndexReadCommand<?> readCommand = (IndexReadCommand<?>) command.clone();
          callable = getCallable(shardServerContext, tableContext, args, shard, blurIndex, readCommand);
        } else if (command instanceof IndexReadCombiningCommand) {
          final IndexReadCombiningCommand<?, ?> readCombiningCommand = (IndexReadCombiningCommand<?, ?>) command
              .clone();
          callable = getCallable(shardServerContext, tableContext, args, shard, blurIndex, readCombiningCommand);
        } else {
          throw new IOException("Command type of [" + command.getClass() + "] not supported.");
        }
        Future<Object> future = submitToExecutorService(callable);
        futureMap.put(shard, future);
      }
    }
    Map<Shard, Object> resultMap = new HashMap<Shard, Object>();
    for (Entry<Shard, Future<?>> e : futureMap.entrySet()) {
      Shard shard = e.getKey();
      Future<?> future = e.getValue();
      Object object;
      try {
        object = future.get();
      } catch (InterruptedException ex) {
        throw new IOException(ex);
      } catch (ExecutionException ex) {
        throw new IOException(ex.getCause());
      }
      resultMap.put(shard, object);
    }
    return resultMap;
  }



  private Callable<Object> getCallable(final ShardServerContext shardServerContext, final TableContext tableContext,
      final Args args, final Shard shard, final BlurIndex blurIndex,
      final IndexReadCombiningCommand<?, ?> readCombiningCommand) {
    return new Callable<Object>() {
      @Override
      public Object call() throws Exception {
        String table = tableContext.getTable();
        String shardId = shard.getShard();
        IndexSearcherClosable searcher = shardServerContext.getIndexSearcherClosable(table, shardId);
        if (searcher == null) {
          searcher = blurIndex.getIndexSearcher();
          shardServerContext.setIndexSearcherClosable(table, shardId, searcher);
        }
        return readCombiningCommand.execute(new ShardIndexContext(tableContext, shard, searcher, args));
      }
    };
  }

  private Callable<Object> getCallable(final ShardServerContext shardServerContext, final TableContext tableContext,
      final Args args, final Shard shard, final BlurIndex blurIndex, final IndexReadCommand<?> readCommand) {
    return new Callable<Object>() {
      @Override
      public Object call() throws Exception {
        String table = tableContext.getTable();
        String shardId = shard.getShard();
        IndexSearcherClosable searcher = shardServerContext.getIndexSearcherClosable(table, shardId);
        if (searcher == null) {
          searcher = blurIndex.getIndexSearcher();
          shardServerContext.setIndexSearcherClosable(table, shardId, searcher);
        }
        return readCommand.execute(new ShardIndexContext(tableContext, shard, searcher, args));
      }
    };
  }

  static class ShardIndexContext extends IndexContext {

    private final TableContext _tableContext;
    private final Shard _shard;
    private final IndexSearcher _searcher;
    private final Args _args;

    public ShardIndexContext(TableContext tableContext, Shard shard, IndexSearcher searcher, Args args) {
      _tableContext = tableContext;
      _shard = shard;
      _searcher = searcher;
      _args = args;
    }

    @Override
    public Args getArgs() {
      return _args;
    }

    @Override
    public IndexReader getIndexReader() {
      return getIndexSearcher().getIndexReader();
    }

    @Override
    public IndexSearcher getIndexSearcher() {
      return _searcher;
    }

    @Override
    public TableContext getTableContext() {
      return _tableContext;
    }

    @Override
    public Shard getShard() {
      return _shard;
    }

    @Override
    public BlurConfiguration getBlurConfiguration() {
      return _tableContext.getBlurConfiguration();
    }

    @Override
    public Configuration getConfiguration() {
      return _tableContext.getConfiguration();
    }

  }

  public void cancel(ExecutionId executionId) {
    // TODO
    System.out.println("IMPLEMENT ME!!!!");
  }

}
