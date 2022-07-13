package com.example.shoes;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepo extends JpaRepository<Products, Integer>{

	@Query("select products from Products products where products.category=?1")
	public List<Products> findbycat(String category);

	@Query("select products from Products products where products.id=?1")
	public List<Products> findbyid(int id);
}
