package com.glearning.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.glearning.library.serviceImpl.LibraryCountServiceImpl;

@RestController
@RequestMapping("/countService")
public class LibraryCountController {
	
	@Autowired
	private LibraryCountServiceImpl countServiceImpl;
	
	@GetMapping("/countLibraries")
	public long countLibraries() {
		return countServiceImpl.countLibraries();
	}
	
	@GetMapping("/countLibrariesWithZeroBooks")
	public long countLibrariesWithZeroBooks() {
		return countServiceImpl.countLibrariesWithZeroBooks();
	}

}
