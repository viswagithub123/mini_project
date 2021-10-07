package com.minipro.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.minipro.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer>{

	@Modifying
	@Transactional
	@Query("UPDATE Product product set product.prodName=:prodName WHERE product.prodId=:prodId")
	public void updateProductNameById(Integer prodId,String prodName);
	
	@Query
	public Product findAllByProdIdAndProdName(Integer prodId,String prodName);
}
