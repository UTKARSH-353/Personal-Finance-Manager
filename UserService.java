package com.example.servlet;

public class UserService {

    private UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public User registerUser(String username, String password, String email) {
        User user = new User(username, password, email);
        return userDao.save(user);
    }

    public User loginUser(String username, String password) {
        return userDao.findByUsernameAndPassword(username, password);
    }
}
