package com.minipro.common;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AllErrorsHandle implements ErrorController {

	@GetMapping("/error")
	public ResponseEntity<ErrorDetails> handleErrors(){
		return ResponseEntity.ok(new ErrorDetails("All",5000,"Exception Occured"));
	}
}
