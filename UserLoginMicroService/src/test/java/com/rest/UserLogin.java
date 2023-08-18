package com.rest;


import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.rest.controller.UserLoginController;
import com.rest.service.IUserRLogin;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;
import com.rest.model.User;

import jakarta.servlet.ServletException;

@SpringBootTest
@AutoConfigureMockMvc
class UserLoginApplicationTests {

//	@Mock
//    private IUserRLogin userLoginService;
//
//    @InjectMocks
//    private UserLoginController userLoginController;
//
//    @Test
//    public void testValidateUserHandler_ValidUser_Success() throws ServletException {
//        // Arrange
//        User user = new User("test@example.com", "password");
//        when(userLoginService.validateUser(any(User.class))).thenReturn("User Authenticated Successfully!!");
//
//        // Act
//        ResponseEntity<?> responseEntity = userLoginController.validateUserHandler(user);
//
//        // Assert
//        assert responseEntity.getStatusCode() == HttpStatus.OK;
//        Map<String, String> expectedResponse = new HashMap<>();
//        expectedResponse.put("message", "User Successfully LoggedIn");
//        expectedResponse.put("token", "mocked-token-value");
//        assert responseEntity.getBody().equals(expectedResponse);
//        verify(userLoginService, times(1)).validateUser(user);
//    }
//
//    @Test
//    public void testValidateUserHandler_InvalidUser_Unauthorized() throws ServletException {
//        // Arrange
//        User user = new User("test@example.com", "password");
//        when(userLoginService.validateUser(any(User.class))).thenThrow(new ServletException("Invalid Credentials"));
//
//        // Act
//        ResponseEntity<?> responseEntity = userLoginController.validateUserHandler(user);
//
//        // Assert
//        assert responseEntity.getStatusCode() == HttpStatus.UNAUTHORIZED;
//        Map<String, String> expectedResponse = new HashMap<>();
//        expectedResponse.put("message", "Invalid Credentials");
//        expectedResponse.put("token", null);
//        assert responseEntity.getBody().equals(expectedResponse);
//        verify(userLoginService, times(1)).validateUser(user);
//    }
}



