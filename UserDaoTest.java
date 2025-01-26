package com.example.servlet;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class UserDaoTest {

    private UserDao userDao;

    @Before
    public void setUp() {
        userDao = new UserDao();
    }

    @Test
    public void testSaveUser() {
        // Arrange
        User user = new User("john_doe", "password123", "john@example.com");

        // Act
        User result = userDao.save(user);

        // Assert
        assertNotNull(result);
        assertEquals("john_doe", result.getUsername());
    }

    @Test
    public void testFindByUsernameAndPassword() {
        // Arrange
        User user = new User("john_doe", "password123", "john@example.com");
        userDao.save(user);

        // Act
        User result = userDao.findByUsernameAndPassword("john_doe", "password123");

        // Assert
        assertNotNull(result);
        assertEquals("john_doe", result.getUsername());
    }
}
