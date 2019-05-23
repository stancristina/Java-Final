package application.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtils {
    public static Connection getDBConnection() {
        Connection dbConnection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        try {
            dbConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/new_schema?user=root&password=root");
            return dbConnection;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        return dbConnection;
    }
}
