package jm.task.core.jdbc;
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        userService.dropUsersTable();
        userService.createUsersTable();
        /*userService.dropUsersTable();
        userService.createUsersTable();
        userService.saveUser("testName", "testLastName", Byte.valueOf((byte) 28));
        List<User> userList = userService.getAllUsers();

        if (userList.size() != 1) {
            System.out.println("!!!! Проверьте корректность работы метода сохранения пользователя/удаления или создания таблицы");
        }*/
        //userDaoHibernateImpl.saveUser("test", "Test", (byte) 20);

        //List users = userDaoHibernateImpl.getAllUsers();
        //System.out.println(users);
        //userDaoHibernateImpl.removeUserById(1);
        //userDaoHibernateImpl.dropUsersTable();

        //UserServiceImpl userService = new UserServiceImpl();
        //userService.saveUser("Name1", "LastName1", (byte) 20);

        /*UserServiceImpl userService = new UserServiceImpl();
        userService.dropUsersTable();

        userService.createUsersTable();
        userService.createUsersTable();

        userService.saveUser("Name1", "LastName1", (byte) 20);
        userService.saveUser("Name2", "LastName2", (byte) 25);
        userService.saveUser("Name3", "LastName3", (byte) 31);
        userService.saveUser("Name4", "LastName4", (byte) 38);

        userService.removeUserById(1);
        System.out.println(userService.getAllUsers());
        userService.cleanUsersTable();
        userService.dropUsersTable();*/

    }
}
