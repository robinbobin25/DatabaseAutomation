package dao;

import connection.DBConnection;
import entities.Station;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static data.Constants.SQL_QUERY;

/**
 * Created by antonina_mykhailenko on 06.10.2015.
 */
public class MethodsWithSimpleConnection implements MethodsInterface {

    Statement stmt;
    ResultSet rs;
    Connection conn;

    DBConnection dbConnection = new DBConnection();
    List stationList = new ArrayList<Station>();
    Station station;

    @Override
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

    @Override
    public ArrayList<Station> findAllAndReturnList() {
        conn = dbConnection.setH2Connection();
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(SQL_QUERY);
            while (rs.next()) {
                station = findAllAndReturnEntity();
                stationList.add(station);
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (ArrayList<Station>) stationList;
    }
}
