package com.minipro.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.minipro.common.ProductException;
import com.minipro.controller.ProductController;
import com.minipro.entity.Product;
import com.minipro.repository.ProductRepository;
import com.minipro.service.ProductService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService{


	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public void saveProduct(Product product) {
		log.debug("Entered into Service--> saveProduct");
		productRepository.save(product);
		log.info("Product saved successfully");
		log.debug("Exited into Service--> saveProduct");
	}

	@Override
	public List<Product> getAllProducts() {
		log.info("Successfully fetched all products");
		return productRepository.findAll();
	}

	@Override
	public Product getProductById(Integer prodId){
		log.info("Successfully fetched product");
		return productRepository.findById(prodId).orElseThrow(
				()->new ProductException("Product Not Found : "+prodId));
	}

	@Override
	public void deleteProductById(Integer prodId) {
		log.info("Successfully deleted the product");
		productRepository.deleteById(prodId);
	}

	@Override
	public void updateProductNameById(Integer prodId, String prodName) {
		Optional<Product> product=productRepository.findById(prodId);
		if(product.isPresent()) {
			productRepository.updateProductNameById(prodId, prodName);
			log.info("Successfully updated the product");
		}else { 
			log.error("Product Name not modified : Product not avaialble with : "+prodId);
			throw new ProductException("Product Name not modified : Product not avaialble with : "+prodId);
	}}

	
	@Override
	public Product getProductByIdAndName(Integer prodId,String prodName){
		log.info("Successfully fetched product");
		return productRepository.findById(prodId).orElseThrow(
				()->new ProductException("Product Not Found : "+prodId));
	}
}
