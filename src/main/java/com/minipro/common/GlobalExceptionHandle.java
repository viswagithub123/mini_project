package com.minipro.common;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandle {

	@ExceptionHandler(ProductException.class)
	public ResponseEntity<ErrorDetails> handleProductExp(ProductException pe){
		return ResponseEntity.ok(new ErrorDetails("Product",4000,pe.getMessage()));
	}
	
	@GetMapping("/error")
	public ResponseEntity<ErrorDetails> handleAllExp(RuntimeException re){
		return ResponseEntity.ok(new ErrorDetails("All",5000,re.getMessage()+" : "+", Contat admin"));
	} 
}