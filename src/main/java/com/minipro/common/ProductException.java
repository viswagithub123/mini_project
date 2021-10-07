package com.minipro.common;

public class ProductException extends RuntimeException {
	

	private static final long serialVersionUID = 1L;

	ProductException(){
		super();
	}
	
	public ProductException(String message){
		super(message);
	}
}
