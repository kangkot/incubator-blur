package com.nearinfinity.blur.manager.indexserver;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.util.Progressable;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.Term;
import org.apache.lucene.index.IndexReader.FieldOption;
import org.apache.lucene.store.LockFactory;

import com.nearinfinity.blur.log.Log;
import com.nearinfinity.blur.log.LogFactory;
import com.nearinfinity.blur.store.cache.LocalFileCache;
import com.nearinfinity.blur.store.replication.ReplicaHdfsDirectory;
import com.nearinfinity.blur.store.replication.ReplicationDaemon;
import com.nearinfinity.blur.utils.BlurConstants;

public class HdfsIndexServer extends ManagedDistributedIndexServer implements BlurConstants {
    
    private static final Log LOG = LogFactory.getLog(HdfsIndexServer.class);
    
    private FileSystem fileSystem;
    private Path blurBasePath;
    private LocalFileCache localFileCache;
    private LockFactory lockFactory;
    private ReplicationDaemon replicationDaemon;
    
    @Override
    public void close() {
        super.close();
        try {
            fileSystem.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected IndexReader openShard(String table, String shard) throws IOException {
        LOG.info("Opening shard [{0}] for table [{1}]",shard,table);
        Path tablePath = new Path(blurBasePath,table);
        if (!exists(tablePath)) {
            throw new FileNotFoundException(tablePath.toString());
        }
        Path hdfsDirPath = new Path(tablePath,shard);
        if (!exists(hdfsDirPath)) {
            throw new FileNotFoundException(hdfsDirPath.toString());
        }
        ReplicaHdfsDirectory directory = new ReplicaHdfsDirectory(table, shard, hdfsDirPath, fileSystem, localFileCache, lockFactory, new Progressable() {
            @Override
            public void progress() {
                //do nothing for now
            }
        }, replicationDaemon);
        return warmUp(IndexReader.open(directory));
    }

    private IndexReader warmUp(IndexReader reader) throws IOException {
        int maxDoc = reader.maxDoc();
        int numDocs = reader.numDocs();
        Collection<String> fieldNames = reader.getFieldNames(FieldOption.ALL);
        int primeDocCount = reader.docFreq(new Term(PRIME_DOC,PRIME_DOC_VALUE));
        LOG.info("Warmup of indexreader [" + reader + "] complete, maxDocs [" + maxDoc + "], numDocs [" + numDocs + "], primeDocumentCount [" + primeDocCount + "], fields [" + fieldNames + "]");
        return reader;
    }

    @Override
    public List<String> getShardList(String table) {
        List<String> result = new ArrayList<String>();
        try {
            FileStatus[] listStatus = fileSystem.listStatus(new Path(blurBasePath,table));
            for (FileStatus status : listStatus) {
                if (status.isDir()) {
                    String name = status.getPath().getName();
                    if (name.startsWith(SHARD_PREFIX)) {
                        result.add(name);
                    }
                }
            }
            return result;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void beforeClose(String shard, IndexReader indexReader) {

    }
    
    protected static void rm(File file) {
        LOG.info("Deleting file [{0}]",file);
        if (file.isDirectory()) {
            for (File f : file.listFiles()) {
                rm(f);
            }
        }
        file.delete();
    }
    
    private boolean exists(Path path) throws IOException {
        return fileSystem.exists(path);
    }

    public void setFileSystem(FileSystem fileSystem) {
        this.fileSystem = fileSystem;
    }

    public void setLocalFileCache(LocalFileCache localFileCache) {
        this.localFileCache = localFileCache;
    }

    public void setLockFactory(LockFactory lockFactory) {
        this.lockFactory = lockFactory;
    }

    public void setReplicationDaemon(ReplicationDaemon replicationDaemon) {
        this.replicationDaemon = replicationDaemon;
    }

    public void setBlurBasePath(Path blurBasePath) {
        this.blurBasePath = blurBasePath;
    }
}