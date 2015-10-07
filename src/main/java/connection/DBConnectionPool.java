package connection;

import data.Constants;
import org.apache.commons.dbcp2.BasicDataSource;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.*;

import static data.Constants.*;

/**
 * Created by antonina_mykhailenko on 06.10.2015.
 */

public class DBConnectionPool {
    private BasicDataSource connectionPool;

//    public DBConnectionPool()throws SQLException {
//        connectionPool = new BasicDataSource();
//
//        connectionPool.setUsername(USER);
//        connectionPool.setPassword(PASS);
//
//        connectionPool.setDriverClassName(JDBC_DRIVER);
//        connectionPool.setUrl(DB_URL);
//        connectionPool.setInitialSize(3);
//        connectionPool.setMaxIdle(10);
////        connectionPool.close();
//    }

    public BasicDataSource setPoolH2Connection() {
        connectionPool = new BasicDataSource();

        connectionPool.setUsername(USER);
        connectionPool.setPassword(PASS);

        connectionPool.setDriverClassName(JDBC_DRIVER);
        connectionPool.setUrl(DB_URL);
        connectionPool.setInitialSize(3);
        connectionPool.setMaxIdle(10);
        return connectionPool;
    }



//    public void fromThePool() throws SQLException {
//        Connection connection = connectionPool.getConnection();
//
//        for (int i = 0; i < 1000; i++) {
//            Statement stmt = connection.createStatement();
//            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS ticks (tick timestamp)");
//            stmt.executeUpdate("INSERT INTO ticks VALUES (now())");
//            ResultSet rs = stmt.executeQuery("SELECT tick FROM ticks");
//
//            while (rs.next()) {
//                System.out.println("Read from DB: " + rs.getTimestamp("tick") + "\n");
//            }
//        }
//    }
//
//    public static void main(String[] args) {
//        try {
//            DBConnectionPool db = new DBConnectionPool();
//            db.fromThePool();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
}
