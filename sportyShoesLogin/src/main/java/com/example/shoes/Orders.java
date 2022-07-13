package com.example.shoes;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Orders {

	@Id
	private int productid;
	private String name;
	private float price;
}
