package jm.task.core.jdbc.util;

import java.sql.*;

public class Util {
    // реализуйте настройку соеденения с БД
    private String dbURL = "jdbc:mysql://localhost:3306/root";
    private String username = "root";
    private String password = "root";

    private Connection conn;

    public Util() throws SQLException {
        System.out.println("Util");
        try  {
            Connection conn = DriverManager.getConnection(dbURL, username, password);
            if (conn != null) {
                System.out.println("Connected");
                this.conn = conn;
            }
        } catch (SQLException ex) {
            System.out.println("Util 2");
            ex.printStackTrace();
        }
    }

    public Connection getConn() {
        return conn;
    }
}
