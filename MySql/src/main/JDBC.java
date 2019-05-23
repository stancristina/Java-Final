package main;

import java.sql.*;

public class JDBC {
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


            String selectUserSql = "SELECT * FROM User";
            dbConnection = JDBC.getDBConnection();


        try {
            dbConnection = DriverManager.getConnection("jdbc:mysql://eapdb.cax5apwcm6t3.us-east-1.rds.amazonaws.com:3306/crm?autoReconnect=true&useSSL=false\",\"root\", \"password");
            return dbConnection;


            PreparedStatement ps = dbConnection.prepareStatement(selectUserSql);
            ResultSet resultSet = ps.executeQuery();
            while(resultSet.next()) {
                User user = new User();
                user.setLastName(resultSet.getString("lastName"));
                user.setFirstName(resultSet.getString("firstName`"));
                user.setId(resultSet.getInt("id"));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        //return dbConnection;
    }
}

