package org.clinic.service;


import org.clinic.dao.UserDao;
import org.clinic.entity.User;

import java.util.List;


public class UserService {

    UserDao userDao;

    public UserService() {
        userDao = new UserDao();
    }

    public User save(User user) {
        return userDao.save(user);
    }

    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    public User delete(int id) {
        return userDao.delete(id);
    }

    public User getUserById(int id) {
        return userDao.getUserById(id);
    }

    public User updateUser(User user) {
        return userDao.updateUser(user);
    }

    public User login(String username, String password) {
        return userDao.login(username, password);
    }


}
