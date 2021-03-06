package org.apache.blur.jdbc;

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
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverPropertyInfo;
import java.sql.SQLException;
import java.util.Properties;

public class BlurJdbc implements Driver {

  public static final String PREFIX = "jdbc:blur:";

  static {
    try {
      java.sql.DriverManager.registerDriver(new BlurJdbc());
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public boolean acceptsURL(String url) throws SQLException {
    // jdbc:blur:<connection string>
    url = url.trim();
    if (url.startsWith(PREFIX)) {
      return true;
    }
    return false;
  }

  @Override
  public Connection connect(String url, Properties info) throws SQLException {
    // jdbc:blur:<connection string>
    String username = "";
    url = url.trim();
    if (!acceptsURL(url)) {
      throw new SQLException("Invalid url [" + url + "]");
    }
    String connectionString = url.substring(PREFIX.length());
    return new BlurConnection(url, username, connectionString, "unknown");
  }

  @Override
  public int getMajorVersion() {
    return 1;
  }

  @Override
  public int getMinorVersion() {
    return 0;
  }

  @Override
  public DriverPropertyInfo[] getPropertyInfo(String url, Properties info) throws SQLException {
    return null;
  }

  @Override
  public boolean jdbcCompliant() {
    return false;
  }

  // java 7
  public java.util.logging.Logger getParentLogger() throws java.sql.SQLFeatureNotSupportedException {
    throw new java.sql.SQLFeatureNotSupportedException();
  }

}
