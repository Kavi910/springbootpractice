package com.example.springbootpratice.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	
	@Value("${spring.application.name:DefaultAppName}")
	String appName;
	
	
	
	@RequestMapping("/hello")
	public String sayHello() {
		return "Hello, How are u ?";
	}
	
	@RequestMapping("/appName")
	public String getAppName() {
		return appName;
	}
	

}
