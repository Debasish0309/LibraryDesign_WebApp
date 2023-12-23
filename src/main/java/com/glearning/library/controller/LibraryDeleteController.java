package com.glearning.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.glearning.library.entity.Library;
import com.glearning.library.serviceImpl.LibraryDeleteServiceImpl;

@RestController
@RequestMapping("/deleteService")
public class LibraryDeleteController {
	
	@Autowired
	private LibraryDeleteServiceImpl deleteServiceImpl;
	
	@DeleteMapping("/deleteOneLibrary")
	public String deleteOneLibrary(Library library) {
		return deleteServiceImpl.deleteOneLibrary(library);
	}
	
	@DeleteMapping("/pruneTable")
	public String pruneTable() {
		return deleteServiceImpl.pruneTable();
	}
	
	@PostMapping("/deleteAllThese")
	public String deleteAllThese(@RequestBody List<Library> libraries) {
		return deleteServiceImpl.deleteAllThese(libraries);
	}
	
	@DeleteMapping("/deleteAllInBatch")
	public String deleteAllInBatch() {
		return deleteServiceImpl.deleteAllInBatch();
	}
	
	@DeleteMapping("/deleteLibraryById")
	public String deleteLibraryById(Long id) {
		return deleteServiceImpl.deleteLibraryById(id);
	}
	
	@PostMapping("/deleteAllTheseInBatch")
	public String deleteAllTheseInBatch(@RequestBody List<Library> libraries) {
		return deleteServiceImpl.deleteAllTheseInBatch(libraries);
	}
	

}
