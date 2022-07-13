package com.example.shoes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface Repo extends JpaRepository<User, String>{

	@Query("select user from User user where user.email=?1")
	public User findbyemail(String email);
	
	@Query("select user from User user where user.password=?1")
	public User findbypassword(String password);
}
