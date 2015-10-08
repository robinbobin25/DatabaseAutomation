package com.epam.mykhailenko.task5.data;

/**
 * Created by antonina_mykhailenko on 06.10.2015.
 */
public class Constants {
    // JDBC driver name and database URL
    public static final String JDBC_DRIVER = "org.h2.Driver";
    public static final String DB_URL = "jdbc:h2:~/test";

    //  Database credentials
    public static final String USER = "sa";
    public static final String PASS = "";

    // Queries
    public static final String SQL_QUERY = "SELECT * FROM STATION";

    // Constants for Part4: Embedded DB
    public static final String EMBEDDED_DB_URL = "jdbc:h2:~/dbcp_lab";

    // Queries
    public static final String DROP_TABLE = "DROP TABLE IF EXISTS STATION;";
    public static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS STATION (ID INTEGER PRIMARY KEY, CITY CHAR(20), STATE CHAR(2), LAT_N REAL, LONG_W REAL);";
    public static final String INSERT_DATA_TO_TABLE = "INSERT INTO STATION VALUES (13, 'Phoenix', 'AZ', 33, 112); \n" +
                                                        "INSERT INTO STATION VALUES (44, 'Denver', 'CO', 40, 105); \n" +
                                                        "INSERT INTO STATION VALUES (66, 'Caribou', 'ME', 47, 68);\n";

}
