package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;

import java.util.List;

public class UserServiceImpl implements UserService {
    private final UserDaoJDBCImpl userDaoJDBC;
    private final UserDaoHibernateImpl userDaoHibernateImpl;

    public UserServiceImpl() {
        this.userDaoJDBC = new UserDaoJDBCImpl();
        this.userDaoHibernateImpl = new UserDaoHibernateImpl();
    }

    public void createUsersTable() {
        userDaoHibernateImpl.createUsersTable();
        System.out.println("Created table in given database...");
    }

    public void dropUsersTable() {
        userDaoHibernateImpl.dropUsersTable();
        System.out.println("DROP TABLE users");
    }

    public void saveUser(String name, String lastName, byte age) {
        userDaoHibernateImpl.saveUser(name, lastName, age);
        //userDaoJDBC.saveUser(name, lastName, age);
        System.out.println("User was added. name=" + name);
    }

    public void removeUserById(long id) {
        userDaoHibernateImpl.removeUserById(id);
        System.out.println("User with id " + id + " was delete.");
    }

    public List<User> getAllUsers() {
        //return userDaoJDBC.getAllUsers();
        return  userDaoHibernateImpl.getAllUsers();
    }

    public void cleanUsersTable() {
        userDaoHibernateImpl.cleanUsersTable();
    }
}
