package com.rest.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.rest.model.User;

@FeignClient(name="Register-Service", url="http://localhost:9090/api/v1")
public interface IUserConsumer {
	
	@GetMapping("/getByEmail/{email}")
	public User getByEmailHandler(@PathVariable String email);
	
}
