package com.rest.mockitoController.test;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rest.controller.UserRegisterController;
import com.rest.model.User;
import com.rest.service.IUserRegisterService;

public class UserRegisterControllerTest
{
   	
	   private MockMvc mockMvc;
	    
	    @Mock
	    private IUserRegisterService userService;
	    
	    @InjectMocks
	    private UserRegisterController userController;
	    
	    @BeforeEach
	    public void setup() {
	        MockitoAnnotations.initMocks(this);
	        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
	    }
	    
	    @Test
	    public void testAddUserHandler() throws Exception {
	        User user = new User("zim@gmail.com", "zim", "zimpass", "hyd", "23445", "1234");
	        when(userService.addUser(any(User.class))).thenReturn(true);
	        
	        mockMvc.perform(post("/api/v1/adduser")
	                .contentType(MediaType.APPLICATION_JSON)
	                .content(new ObjectMapper().writeValueAsString(user)))
	                .andExpect(status().isCreated());
	    }
	    
	    @Test
	    public void testGetAllUserHandler() throws Exception {
	        List<User> users = Arrays.asList(
	                new User("zim@gmail.com", "zim", "zimpass", "hyd", "23445", "1234"),
	                new User("jim@gmail.com", "jim", "jimpass", "hyd", "23445", "1234")
	        );
	        when(userService.getAllUsers()).thenReturn(users);
	        
	        mockMvc.perform(get("/api/v1/getAllUsers"))
	                .andExpect(status().isOk());
	    }
	    
	    @Test
	    public void testGetByEmailHandler() throws Exception {
	        User user = new User("zim@gmail.com", "zim", "zimpass", "hyd", "23445", "1234");
	        when(userService.getUserByEmail("test@example.com")).thenReturn(user);
	        
	        mockMvc.perform(get("/api/v1/getByEmail/{email}", "zim@gmail.com"))
	                .andExpect(status().isOk());
	    }
	
}
