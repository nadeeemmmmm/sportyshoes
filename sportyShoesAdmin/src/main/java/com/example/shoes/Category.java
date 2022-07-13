package com.example.shoes;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Category {

	@Id
	private int id;
	private String name;
}
