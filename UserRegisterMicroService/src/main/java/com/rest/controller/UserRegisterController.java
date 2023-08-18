package com.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.exception.UserAlreadyExistsException;
import com.rest.exception.UserNotFoundException;
import com.rest.model.User;
import com.rest.service.IUserRegisterService;

@RestController
@RequestMapping("/api/v1")
//@CrossOrigin
public class UserRegisterController {
	
	@Autowired
	private IUserRegisterService userService;
	
	private ResponseEntity<?> responseEntity;
	
	
	@PostMapping("/adduser")
	public ResponseEntity<?> addUserHandler(@RequestBody User uObj)throws UserAlreadyExistsException{
		boolean newUser = this.userService.addUser(uObj);
		responseEntity = new ResponseEntity<>("User added: "+newUser, HttpStatus.CREATED);
		return responseEntity;
	}
	
	@GetMapping("/getAllUsers")
	public ResponseEntity<?> getAllUserHandler(){
		List<User> Users = this.userService.getAllUsers();
		responseEntity = new ResponseEntity<>(Users, HttpStatus.OK);
		return responseEntity;
	}
	
	@GetMapping("/getByEmail/{email}")
	public ResponseEntity<?> getByEmailHandler(@PathVariable String email)throws UserNotFoundException{
		User userObj = this.userService.getUserByEmail(email);
		responseEntity = new ResponseEntity<>(userObj, HttpStatus.OK);
		return responseEntity;
	}
}
