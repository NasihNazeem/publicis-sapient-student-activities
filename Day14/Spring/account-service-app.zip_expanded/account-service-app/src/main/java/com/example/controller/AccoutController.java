package com.example.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class AccoutController {

	@Value("${server.port}") // this reads the port number of your application
	private String port;
	
	@GetMapping
	public String greet() {
		System.out.println("Request arrived at "+port+"!");
		return "Hello! this is Account Microservice";
	}
}
