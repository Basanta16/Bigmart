package com.basanta.bigmart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.basanta.bigmart.entity.Product;

public interface ProductRepo extends JpaRepository<Product, String> {
	
	
	@Query("from Product as p where p.product_code = :product_code")
	public Product findByproductCode(@Param("product_code") String product_code);

}
