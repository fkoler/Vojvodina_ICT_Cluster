package com.iktobuka.testing_project.services;

import org.springframework.stereotype.Service;

@Service
public class GreetingService {
	
	public String greet() {
		return "Hello World";
	}
}
