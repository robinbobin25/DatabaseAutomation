package com.epam.mykhailenko.task5.methods;

import com.epam.mykhailenko.task5.connection.DBConnection;
import com.epam.mykhailenko.task5.connection.EmbeddedDBConnection;
import com.epam.mykhailenko.task5.entities.Station;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static com.epam.mykhailenko.task5.data.Constants.*;

/**
 * Created by antonina_mykhailenko on 08.10.2015.
 */
public class MethodsForEmbeddedDB {
    private Statement stmt;
    private ResultSet rs;
    private Connection conn;

    private EmbeddedDBConnection dbConnection;
    private List stationList = new ArrayList<Station>();
    private Station station;

    public boolean createTable(){
        System.out.println("Creating statement...");
        try {
            dbConnection = new EmbeddedDBConnection();
            conn = dbConnection.createH2EmbeddedConnection().getConnection();
            stmt = conn.createStatement();
            stmt.executeUpdate(DROP_TABLE);
            stmt.executeUpdate(CREATE_TABLE);

            System.out.println("Table was created! ");

            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    public boolean addDataToTable(){
        System.out.println("Creating statement...");
        try {
            dbConnection = new EmbeddedDBConnection();
            conn = dbConnection.createH2EmbeddedConnection().getConnection();
            stmt = conn.createStatement();
            stmt.executeUpdate(INSERT_DATA_TO_TABLE);

            System.out.println("Data were added! ");

            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    public Station findAllAndReturnEntity() {
        System.out.println("Creating statement...");
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(SQL_QUERY);
            // Extract data from result set
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
            dbConnection = new EmbeddedDBConnection();
            conn = dbConnection.createH2EmbeddedConnection().getConnection();

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
