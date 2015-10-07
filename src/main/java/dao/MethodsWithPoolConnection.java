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
    DBConnectionPool dbConnectionPool;
    Connection connection;

    public void fromThePool() throws SQLException {
        dbConnectionPool = new DBConnectionPool();

        for (int i = 0; i < 1000; i++) {
            connectionPool = dbConnectionPool.setPoolH2Connection();
            connection = connectionPool.getConnection();
            Statement stmt = connection.createStatement();
            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS ticks (tick timestamp)");
            stmt.executeUpdate("INSERT INTO ticks VALUES (now())");
            ResultSet rs = stmt.executeQuery("SELECT tick FROM ticks");

            while (rs.next()) {
                System.out.println("Read from DB: " + rs.getTimestamp("tick") + "\n");
            }
        }
    }

}
