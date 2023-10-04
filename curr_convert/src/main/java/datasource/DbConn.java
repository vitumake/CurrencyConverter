package datasource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class DbConn {
    
    private static Connection conn = null;

    public static Connection getInstance() {
        if(conn==null){
            try{
                conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/currencyrates?user=koulu&password=koulu1234");
                System.out.println("Connected to database.");
            } catch (SQLException e) {
                System.out.println("Cannot connect to database: " + e.getMessage());
            }
            return conn;
        } else {
            return conn;
        }
    }

    public static void close() {
        try {
            conn.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
