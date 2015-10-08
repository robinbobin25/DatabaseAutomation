package com.epam.mykhailenko.task5.methods;

import com.epam.mykhailenko.task5.connection.DBConnection;
import com.epam.mykhailenko.task5.connection.DBConnectionPool;

/**
 * Created by antonina_mykhailenko on 08.10.2015.
 */
public class ConnectionFactory {
    DBConnection dbConnection;
    DBConnectionPool dbConnectionPool;

    public Object getConnection(Object connection){
        if(connection instanceof DBConnection){
            dbConnection = new DBConnection();
            return dbConnection.createH2Connection();
        } else if(connection instanceof DBConnectionPool){
            dbConnectionPool = new DBConnectionPool();
            return dbConnectionPool.createH2PoolConnection();
        }
        return null;
    }
}
