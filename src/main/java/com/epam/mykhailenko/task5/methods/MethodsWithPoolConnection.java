package com.epam.mykhailenko.task5.methods;

import com.epam.mykhailenko.task5.connection.DBConnection;
import com.epam.mykhailenko.task5.connection.DBConnectionPool;
import com.epam.mykhailenko.task5.entities.Station;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static com.epam.mykhailenko.task5.data.Constants.SQL_QUERY;

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

    Statement stmt;
    ResultSet rs;
    Connection conn;

    DBConnection dbConnection = new DBConnection();
    List stationList = new ArrayList<Station>();
    Station station;

    public Station findAllAndReturnEntity() {
        System.out.println("Creating statement...");
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(SQL_QUERY);
            // Extract com.epam.mykhailenko.task5.data from result set
            while (rs.next()) {
                //Retrieve by column name
                station = new Station();
                station.setId(rs.getInt("id"));
                station.setCity(rs.getString("city"));
                station.setState(rs.getString("state"));
                station.setLat_n(rs.getDouble("lat_n"));
                station.setLong_w(rs.getDouble("long_w"));
                //Display values
                System.out.println(station);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return station;
    }

    public ArrayList<Station> findAllAndReturnList() {
        long startTime = System.currentTimeMillis();

        try {
            db = new DBConnectionPool();
            conn = db.createH2PoolConnection().getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(SQL_QUERY);
            while (rs.next()) {
                station = findAllAndReturnEntity();
                stationList.add(station);
            }
            rs.close();
            stmt.close();
            conn.close();

            long stopTime = System.currentTimeMillis();
            long elapsedTime = stopTime - startTime;
            System.out.println("Time with pool connection: " + elapsedTime);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (ArrayList<Station>) stationList;
    }
}
