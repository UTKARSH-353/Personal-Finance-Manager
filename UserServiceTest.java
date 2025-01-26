package com.example.servlet;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.mockito.*;

public class UserServiceTest {

    private UserDao userDaoMock;
    private UserService userService;

    @Before
    public void setUp() {
        userDaoMock = Mockito.mock(UserDao.class);
        userService = new UserService(userDaoMock);
    }

    @Test
    public void testRegisterUser() {
        // Arrange
        User user = new User("john_doe", "password123", "john@example.com");
        Mockito.when(userDaoMock.save(Mockito.any(User.class))).thenReturn(user);

        // Act
        User result = userService.registerUser("john_doe", "password123", "john@example.com");

        // Assert
        assertNotNull(result);
        assertEquals("john_doe", result.getUsername());
        Mockito.verify(userDaoMock, Mockito.times(1)).save(Mockito.any(User.class));
    }

    @Test
    public void testLoginUser() {
        // Arrange
        User user = new User("john_doe", "password123", "john@example.com");
        Mockito.when(userDaoMock.findByUsernameAndPassword("john_doe", "password123")).thenReturn(user);

        // Act
        User result = userService.loginUser("john_doe", "password123");

        // Assert
        assertNotNull(result);
        assertEquals("john_doe", result.getUsername());
        Mockito.verify(userDaoMock, Mockito.times(1)).findByUsernameAndPassword("john_doe", "password123");
    }
}
