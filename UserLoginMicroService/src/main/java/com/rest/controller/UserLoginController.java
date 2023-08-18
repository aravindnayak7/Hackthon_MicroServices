package com.rest.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import com.rest.model.User;
import com.rest.service.IUserRLogin;

import jakarta.servlet.ServletException;

@RestController
@RequestMapping("api/login")
public class UserLoginController {
	
	@Autowired
	private IUserRLogin userlogin;
	

	private Map<String, String> map = new HashMap<>();
	
	@PostMapping("/validate")
	public ResponseEntity<?> validateUserHandler(@RequestBody User uObj){
		try {
			String jwtToken=generateToken(uObj);
			map.put("message", "Your Credentials are accepted");
			map.put("token", jwtToken);
		}catch(Exception e) {
			map.put("message", e.getMessage());

            map.put("token", null);

            return new ResponseEntity<>(map, HttpStatus.UNAUTHORIZED);
		}
		
		 return new ResponseEntity<>(map, HttpStatus.OK);
	}
	
	private String generateToken(User UObj) throws ServletException{
		String jwtToken = "";
		String flag = this.userlogin.validateUser(UObj);
		if(flag == "User Not Found!") {
			throw new ServletException("Invalid Credentials");
		}else {
			jwtToken=Jwts.builder().setSubject(UObj.getUserEmail())
					.setIssuedAt(new Date())
					.setExpiration(new Date(System.currentTimeMillis() + 3000000))
					.signWith(SignatureAlgorithm.HS256, "secret key")
					.compact();
		}
		return jwtToken;
	}
}
