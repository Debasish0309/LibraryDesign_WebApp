package com.glearning.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.glearning.library.model.GreatLearning;
import com.glearning.library.service.ExampleService;

//@Controller
@RestController
public class ExampleController {
	
	@Autowired
	private ExampleService exampleService;
	
	@GetMapping("/info")
	//@ResponseBody
	public GreatLearning get() {
		return exampleService.get();
	}
	
	@PostMapping("/customInfo")
	public GreatLearning customInfo(String courseName,String courseType,String firstName,String lastName) {
		return exampleService.customInfo(courseName, courseType, firstName, lastName);
	}

}
