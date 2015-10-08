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

}
