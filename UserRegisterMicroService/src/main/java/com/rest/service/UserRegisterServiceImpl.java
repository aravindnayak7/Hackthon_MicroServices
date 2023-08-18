package com.rest.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.model.User;
import com.rest.repository.IUserRegisterRepository;


@Service
public class UserRegisterServiceImpl implements IUserRegisterService {
	
	@Autowired
	private IUserRegisterRepository userRepository;
	
	@Override
	public boolean addUser(User uObj) {
		
        this.userRepository.save(uObj);
		return true;
	}

	@Override
	public List<User> getAllUsers() {
		return this.userRepository.findAll();
	}

	@Override
	public User getUserByEmail(String email) {
		User userObj = this.userRepository.findByUserEmail(email);
		return userObj;
	}

}
