package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;

import java.util.List;

public class UserServiceImpl implements UserService {
    private final UserDaoJDBCImpl userDaoJDBC;

    public UserServiceImpl() {
        this.userDaoJDBC = new UserDaoJDBCImpl();
    }

    public void createUsersTable() {
        userDaoJDBC.createUsersTable();
        System.out.println("Created table in given database...");
    }

    public void dropUsersTable() {
        userDaoJDBC.dropUsersTable();
        System.out.println("DROP TABLE users");
    }

    public void saveUser(String name, String lastName, byte age) {
        userDaoJDBC.saveUser(name, lastName, age);
        System.out.println("User was added. name=" + name);
    }

    public void removeUserById(long id) {
        userDaoJDBC.removeUserById(id);
        System.out.println("User with id " + id + " was delete.");
    }

    public List<User> getAllUsers() {
        return userDaoJDBC.getAllUsers();
    }

    public void cleanUsersTable() {
        userDaoJDBC.cleanUsersTable();
    }
}
