package jm.task.core.jdbc.util;

import java.sql.*;

public class Util {
    // реализуйте настройку соеденения с БД
    private final String dbURL = "jdbc:mysql://localhost:3306/root";
    private final String username = "root";
    private final String password = "root";


    public Util() throws SQLException {

    }

    public Connection getConnection() {
        Connection connection = null;

        try  {
            connection = DriverManager.getConnection(dbURL, username, password);
            if (connection != null) {
                System.out.println("Connected");
            }
        } catch (SQLException ex) {
            System.out.println("Error");
            ex.printStackTrace();
        }
        return connection;
    }
}
