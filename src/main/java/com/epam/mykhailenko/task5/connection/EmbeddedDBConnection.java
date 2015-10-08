package com.epam.mykhailenko.task5.connection;

import org.apache.commons.dbcp2.BasicDataSource;

import static com.epam.mykhailenko.task5.data.Constants.*;

/**
 * Created by antonina_mykhailenko on 08.10.2015.
 */
public class EmbeddedDBConnection {
    private BasicDataSource connectionPool;

    public BasicDataSource createH2EmbeddedConnection() {
        connectionPool = new BasicDataSource();

        connectionPool.setUsername(USER);
        connectionPool.setPassword(PASS);

        connectionPool.setDriverClassName(JDBC_DRIVER);
        connectionPool.setUrl(EMBEDDED_DB_URL); // change url to embedded url

        // set pool size:
        connectionPool.setInitialSize(1);
        connectionPool.setMaxTotal(5);

        return connectionPool;
    }
}
