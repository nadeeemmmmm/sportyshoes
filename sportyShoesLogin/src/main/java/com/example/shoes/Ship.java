package com.example.shoes;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Ship {

	@Id
	private long contact;
	private String address;
	private long zipcode;
}
