package com.example.shoes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepo extends JpaRepository<Products, Integer>{

	@Query("select products from Products products where products.category=?1")
	public Products findbycat(String category);
}
