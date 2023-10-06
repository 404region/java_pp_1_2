package jm.task.core.jdbc.dao;

import com.mysql.cj.jdbc.result.ResultSetImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class UserDaoJDBCImpl implements UserDao {
    private Util util;
    private int usersCount = 0;

    {
        try {
            util = new Util();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private Connection connection = util.getConnection();
    private Statement statement;

    {
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() {
        String sql = "CREATE TABLE IF NOT EXISTS Users " +
                "(id INTEGER not NULL, " +
                " name VARCHAR(255), " +
                " lastName VARCHAR(255), " +
                " age INTEGER, " +
                " PRIMARY KEY ( id ))";

        try {
            statement.executeUpdate(sql);
            System.out.println("Created table in given database...");
        } catch (SQLException e) {
            System.out.println("Problem Not Created table in given database...");
            e.printStackTrace();
        }

    }

    public void dropUsersTable() {
        String sql = "DROP TABLE IF EXISTS Users";

        try {
            statement.executeUpdate(sql);
            System.out.println("DROP TABLE users");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        /*String sql = "INSERT INTO Users VALUES ("
                + ++usersCount + ", " + name + ", lastName, " + age
                + ")";*/


        String query = "INSERT INTO Users ("
                + " id,"
                + " name,"
                + " lastName,"
                + " age ) VALUES ("
                + "?, ?, ?, ?)";

        try (PreparedStatement st = connection.prepareStatement(query);) {
            st.setInt(1, ++usersCount);
            st.setString(2, name);
            st.setString(3, lastName);
            st.setByte(4, age);

            st.executeUpdate();

            System.out.println("User was added. name=" + name + " id=" + usersCount);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeUserById(long id) {
        try (Statement statement = connection.createStatement();) {
            String sql = "DELETE FROM Users " +
                    "WHERE id =" + id;
            System.out.println("User with id " + id + " was delete.");
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM Users";

        try (ResultSet rs = statement.executeQuery(sql)) {
            while (rs.next()) {
                User user = new User(
                        rs.getString("name"),
                        rs.getString("lastName"),
                        rs.getByte("age")
                );

                user.setId(rs.getLong("id"));
                users.add(user);
            }
            return users;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void cleanUsersTable() {
        String sql = "SELECT * FROM Users";
        try (ResultSet rs = statement.executeQuery(sql);) {
            while (rs.next()) {
                int id = rs.getInt("id");
                removeUserById(id);

                System.out.println("User c id " + id + " and name "
                        + rs.getString("name") + " "
                        + rs.getString("lastName") +
                        " was delete");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
