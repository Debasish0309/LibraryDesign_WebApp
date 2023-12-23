package com.glearning.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.glearning.library.entity.Library;
import com.glearning.library.serviceImpl.LibraryCreateServiceImpl;

@RestController
@RequestMapping("/createService")
public class LibraryCreateController {
	
	@Autowired
	private LibraryCreateServiceImpl createServiceImpl;
	
	@PostMapping("/addSingleLibrary")
	public String addSingleLibrary(Library library) {
		return createServiceImpl.addSingleLibraray(library);
	}
	
	@PostMapping("/insertAllLibraries")
	public String insertAllLibraries(@RequestBody List<Library> libraries) {
		return createServiceImpl.addAllLibraries(libraries);
	}
	
	@PostMapping("/addLibraryWithSaveAndFlush")
	public Library addLibraryWithSaveAndFlush(Library library) {
		return createServiceImpl.addLibraryWithSaveAndFlush(library);
	}

}
