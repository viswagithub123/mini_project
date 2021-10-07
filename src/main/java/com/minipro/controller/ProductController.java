package com.minipro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.minipro.entity.Product;
import com.minipro.service.ProductService;

import io.swagger.annotations.ApiOperation;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/product")
@Slf4j
public class ProductController {
	
	@Autowired
	private ProductService productService;

	@PostMapping("/saveProduct")
	@ApiOperation("Saving Product Info")
	
	public ResponseEntity<?> saveProduct(@RequestBody Product product) {
		log.debug("Entered in to SaveProduct");
		productService.saveProduct(product);
		log.debug("Exited from SaveProduct");
		return new ResponseEntity<String>("Product Created !",HttpStatus.CREATED);
	}

	@GetMapping("/getAllProducts")
	@ApiOperation("Fetching All Product Info")
	public ResponseEntity<?> getAllProducts() {
		log.debug("Entered in to getAllProducts");
		List<Product> productes=productService.getAllProducts();
		log.debug("Exited from getAllProducts");
		return ResponseEntity.ok(productes);
	}

	@GetMapping("/getProductById/{prodId}")
	@ApiOperation("Fetch Product Info by Id")
	public ResponseEntity<?> getProductById(@PathVariable Integer prodId) {
		log.debug("Entered in to getProductById");
		Product product=productService.getProductById(prodId);
		log.debug("Exited from getProductById");
		return ResponseEntity.ok(product);
	}
	
	@GetMapping("/getProductByIdAndName/{prodId}/{prodName}")
	@ApiOperation("Fetch Product Info by Id")
	public ResponseEntity<?> getProductByIdAndName(@PathVariable Integer prodId,@PathVariable String prodName) {
		log.debug("Entered in to getProductByIdAndName");
		Product product=productService.getProductByIdAndName(prodId,prodName);
		log.debug("Exited from getProductByIdAndName");
		return ResponseEntity.ok(product);
	}
	
	@DeleteMapping("/deleteProductById/{prodId}")
	@ApiOperation("Delete Product Info by Id")
	public ResponseEntity<?> deleteProductById(@PathVariable Integer prodId) {
		log.debug("Entered in to deleteProductById");
		productService.deleteProductById(prodId);
		log.debug("Exited from deleteProductById");
		return ResponseEntity.ok("Product Deleted !");
	}
	
	@PutMapping("/updateProduct")
	@ApiOperation("Updating Product Info")
	public ResponseEntity<?> updateProduct(@RequestBody Product product) {
		log.debug("Entered in to updateProduct");
		productService.saveProduct(product);
		log.debug("Exited from updateProduct");
		return ResponseEntity.ok("Product Updated !");
	}
	
	@PatchMapping("/updateProductNameById/{prodName}/{prodId}")
	@ApiOperation("Updating product name by Id")
	public ResponseEntity<?> updateProductNameById(@PathVariable String prodName,@PathVariable Integer prodId) {
		log.debug("Entered in to updateProductNameById");
		productService.updateProductNameById(prodId, prodName);
		log.debug("Exited from updateProductNameById");
		return ResponseEntity.ok("Product Name Updated !");
	}
}
