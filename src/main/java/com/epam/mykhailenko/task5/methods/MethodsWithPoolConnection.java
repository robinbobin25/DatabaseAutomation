package com.epam.mykhailenko.task5.methods;

import com.epam.mykhailenko.task5.connection.DBConnectionPool;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by antonina_mykhailenko on 07.10.2015.
 */

public class MethodsWithPoolConnection {

    Connection connection;
    DBConnectionPool db;

    public void fromThePool() throws SQLException {
        db = new DBConnectionPool();
        connection = db.createH2PoolConnection().getConnection();

        for (int i = 0; i < 10; i++) {
            Statement stmt = connection.createStatement();
            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS ticks (tick timestamp)");
            stmt.executeUpdate("INSERT INTO ticks VALUES (now())");
            ResultSet rs = stmt.executeQuery("SELECT tick FROM ticks");

            while (rs.next()) {
                System.out.println(i + ") Read from DB: " + rs.getTimestamp("tick") + "\n");
            }
        }
    }
}
