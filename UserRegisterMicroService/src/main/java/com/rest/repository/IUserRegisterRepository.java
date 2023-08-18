package com.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rest.model.User;

public interface IUserRegisterRepository extends JpaRepository<User, String> {
	public User findByUserEmail(String email);
}
