package com.minipro.service;

import java.util.List;

import com.minipro.entity.Product;

public interface ProductService {

	public void saveProduct(Product product);
	
	public List<Product> getAllProducts();
	
	public Product getProductById(Integer prodId);
	
	public void deleteProductById(Integer prodId);
	
	public void updateProductNameById(Integer prodId,String prodName);
	
	public Product getProductByIdAndName(Integer prodId,String prodName);
	
}
