package com.epam.mykhailenko.task5.methods;

import com.epam.mykhailenko.task5.connection.DBConnection;
import com.epam.mykhailenko.task5.entities.Station;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static com.epam.mykhailenko.task5.data.Constants.SQL_QUERY;

/**
 * Created by antonina_mykhailenko on 06.10.2015.
 */
public class MethodsWithSimpleConnection {

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

        conn = dbConnection.createH2Connection();
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(SQL_QUERY);
            while (rs.next()) {
                station = findAllAndReturnEntity();
                stationList.add(station);
            }
            rs.close();
            stmt.close();
            conn.close(); // return connection back to the pool

            long stopTime = System.currentTimeMillis();
            long elapsedTime = stopTime - startTime;
            System.out.println("Time with simple connection: " + elapsedTime);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return (ArrayList<Station>) stationList;

    }
}
