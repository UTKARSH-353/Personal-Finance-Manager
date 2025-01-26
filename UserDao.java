package com.example.servlet;

import java.util.ArrayList;
import java.util.List;

public class UserDao {
    private List<User> users = new ArrayList<>();

    public User save(User user) {
        users.add(user);
        return user;
    }

    public User findByUsernameAndPassword(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }
}
