import java.sql.*;

/**
 * Created by antonina_mykhailenko on 06.10.2015.
 */
public class DBConnection {
    Statement stmt;
    ResultSet rs;
    Connection conn;

    public void getDataFromTable() {
        setH2Connection();

        System.out.println("Creating statement...");
        try {
            stmt = conn.createStatement();

            rs = stmt.executeQuery(Constants.SQL_QUERY);

            // Extract data from result set
            while (rs.next()) {
                //Retrieve by column name
                int id = rs.getInt("id");
                String city = rs.getString("city");
                String state = rs.getString("state");
                double lat_n = rs.getDouble("lat_n");
                double long_w = rs.getDouble("long_w");

                //Display values
                System.out.print("ID: " + id);
                System.out.print(", city: " + city);
                System.out.print(", state: " + state);
                System.out.print(", lat_n: " + lat_n);
                System.out.print(", long_w: " + long_w);
                System.out.println();
            }

            rs.close();
            stmt.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void setH2Connection() {
        try {
            Class.forName(Constants.JDBC_DRIVER);
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(Constants.DB_URL, Constants.USER, Constants.PASS);
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("Connection already exists or JDBC Driver class was not found. ");
        }
    }

    public static void main(String[] args) throws Exception {
        DBConnection con = new DBConnection();
        con.getDataFromTable();
    }
}