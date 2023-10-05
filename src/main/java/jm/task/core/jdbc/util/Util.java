package jm.task.core.jdbc.util;

import java.sql.*;

public class Util {
    // реализуйте настройку соеденения с БД
    private String dbURL = "jdbc:mysql://localhost:3306/root";
    private String username = "root";
    private String password = "root";

    private Connection connection = null;

    public Util() throws SQLException {
        System.out.println("Util");
        try  {
            Connection connection = DriverManager.getConnection(dbURL, username, password);
            if (connection != null) {
                System.out.println("Connected");
                this.connection = connection;
            }
        } catch (SQLException ex) {
            System.out.println("Util 2");
            ex.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }
}
