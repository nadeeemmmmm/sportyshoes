package com.example.shoes;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class User {

	@Id
	private String email;
	private String firstname;
	private String lastname;
	private String password;
	
}
