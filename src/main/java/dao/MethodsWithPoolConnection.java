package dao;

import connection.DBConnectionPool;
import entities.Station;
import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by antonina_mykhailenko on 07.10.2015.
 */

public class MethodsWithPoolConnection {

    BasicDataSource connectionPool;
    Connection connection;


}
