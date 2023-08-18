package com.rest.service;

import java.util.List;

import com.rest.exception.UserAlreadyExistsException;
import com.rest.exception.UserNotFoundException;
import com.rest.model.User;

public interface IUserRegisterService {
	public boolean addUser(User uObj)throws UserAlreadyExistsException;
	public List<User> getAllUsers();
	public User getUserByEmail(String email)throws UserNotFoundException;
}
