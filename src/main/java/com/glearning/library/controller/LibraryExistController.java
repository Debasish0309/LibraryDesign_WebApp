package com.glearning.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.glearning.library.serviceImpl.LibraryExistServiceImpl;

@Controller
@RestController("/existService")
public class LibraryExistController {
	
	@Autowired
	private LibraryExistServiceImpl existServiceImpl;
	
	@GetMapping("/checkLibraryExistsById")
	public boolean checkLibraryExistsById(Long id) {
		return existServiceImpl.checkLibraryExistsById(id);
	}
	
	@GetMapping("/checkLibraryExistsByExample")
	public boolean checkLibraryExistsByExample(String commaSeparatedBookNames) {
		return existServiceImpl.checkLibraryExistsByExample(commaSeparatedBookNames);
	}

}
