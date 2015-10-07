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

    public DBConnectionPool()throws SQLException {
        connectionPool = new BasicDataSource();

        connectionPool.setUsername(USER);
        connectionPool.setPassword(PASS);

        connectionPool.setDriverClassName(JDBC_DRIVER);
        connectionPool.setUrl(DB_URL);
        connectionPool.setInitialSize(3);
        connectionPool.setMaxIdle(10);
    }

}
