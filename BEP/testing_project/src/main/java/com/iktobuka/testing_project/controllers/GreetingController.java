package com.iktobuka.testing_project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iktobuka.testing_project.services.GreetingService;

@Controller
public class GreetingController {
	
	@Autowired
	protected GreetingService service;

	@GetMapping("/greeting")
	public @ResponseBody String greeting() {
		return service.greet();
	}
}
