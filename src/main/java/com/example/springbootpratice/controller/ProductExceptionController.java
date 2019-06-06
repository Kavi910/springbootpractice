package com.example.springbootpratice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.springbootpratice.model.ProductNotFoundException;

@ControllerAdvice
public class ProductExceptionController {
	
	@ExceptionHandler(ProductNotFoundException.class)
	public ResponseEntity<String> productNotFound(ProductNotFoundException ep){
		return new ResponseEntity<String>("Product Not Found",HttpStatus.NOT_FOUND);
	}

}
