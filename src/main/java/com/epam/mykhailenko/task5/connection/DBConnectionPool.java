package com.epam.mykhailenko.task5.connection;

import org.apache.commons.dbcp2.BasicDataSource;

import static com.epam.mykhailenko.task5.data.Constants.*;

/**
 * Created by antonina_mykhailenko on 06.10.2015.
 */

public class DBConnectionPool {
    private BasicDataSource connectionPool;

    public BasicDataSource createH2PoolConnection() {
        connectionPool = new BasicDataSource();

        connectionPool.setUsername(USER);
        connectionPool.setPassword(PASS);

        connectionPool.setDriverClassName(JDBC_DRIVER);
        connectionPool.setUrl(DB_URL);

        // set pool size:
        connectionPool.setInitialSize(1);
        connectionPool.setMaxTotal(5);

        return connectionPool;
    }
}
