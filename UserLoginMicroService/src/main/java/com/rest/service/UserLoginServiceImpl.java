package com.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.feign.IUserConsumer;
import com.rest.model.User;


@Service
public class UserLoginServiceImpl implements IUserRLogin {
	
	@Autowired
	private IUserConsumer userConsumer;
	
	
	@Override
	public String validateUser(User uObj) {
		
		User userObj = this.userConsumer.getByEmailHandler(uObj.getUserEmail());
		if(userObj != null) {
			if(userObj.getUserPassword().equals(uObj.getUserPassword())) {
				return "User Authenticated Successfully!!";
			}else {
				System.out.println("Wrong Password");
				return "Wrong Password";
			}
		}else {
			System.out.println("User Not Found!");
			return "User Not Found!";
		}
	}

}
