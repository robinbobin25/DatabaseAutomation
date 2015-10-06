package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static data.Constants.*;

/**
 * Created by antonina_mykhailenko on 06.10.2015.
 */
public class DBConnection {

    public Connection setH2Connection() {
        Connection conn = null;
        try {
            Class.forName(JDBC_DRIVER);
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("Connection already exists or JDBC Driver class was not found.");
        }
        return conn;
    }


}