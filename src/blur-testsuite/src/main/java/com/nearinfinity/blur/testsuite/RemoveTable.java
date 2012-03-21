package com.nearinfinity.blur.testsuite;

import java.io.IOException;

import org.apache.thrift.TException;

import com.nearinfinity.blur.thrift.BlurClientManager;
import com.nearinfinity.blur.thrift.commands.BlurCommand;
import com.nearinfinity.blur.thrift.generated.Blur.Client;
import com.nearinfinity.blur.thrift.generated.BlurException;

public class RemoveTable {

  public static void main(String[] args) throws BlurException, TException, IOException {
    String connectionStr = args[0];
    final String tableName = args[1];

    BlurClientManager.execute(connectionStr, new BlurCommand<Void>() {
      @Override
      public Void call(Client client) throws BlurException, TException {
        client.removeTable(tableName, true);
        return null;
      }
    });
  }
}
