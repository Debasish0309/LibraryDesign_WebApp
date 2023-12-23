package com.glearning.library.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.glearning.library.entity.Library;
import com.glearning.library.serviceImpl.LibraryReadServiceImpl;

@RestController
@RequestMapping("/readService")
public class LibraryReadController {

	@Autowired
	private LibraryReadServiceImpl readServiceImpl;

	@GetMapping("/getAllLibrary")
	public List<Library> getAllLibrary() {
		return readServiceImpl.getAllLibrary();
	}

	@GetMapping("/getAllLibrariesWithNoBooks")
	public List<Library> getAllLibrariesWithNoBooks() {
		return readServiceImpl.getAllLibrariesWithNoBooks();
	}

	@GetMapping("/getLibrariesPaged")
	public Page<Library> getLibrariesPaged() {
		return readServiceImpl.getLibrariesPaged();
	}

	@GetMapping("/getLibrariesCustomPaged")
	public Page<Library> getLibrariesCustomPaged(int pageNumber, int numberOfRecordsOnApage) {
		return readServiceImpl.getLibrariesCustomPaged(pageNumber, numberOfRecordsOnApage);
	}

	@GetMapping("/getLibrariesWithLatestAddedOrder")
	public List<Library> getLibrariesWithLatestAddedOrder() {
		return readServiceImpl.getLibrariesWithLatestAddedOrder();
	}

	@GetMapping("/getLibrariesCustomSortedById")
	public List<Library> getLibrariesCustomSortedById(Direction direction) {
		return readServiceImpl.getLibrariesCustomSortedById(direction);
	}

	@GetMapping("/getLibrariesCustomSortedByName")
	public List<Library> getLibrariesCustomSortedByName(Direction direction) {
		return readServiceImpl.getLibrariesCustomSortedByName(direction);
	}

	@GetMapping("/getLibrariesPagedAndSortedByNameAndWithTheseBooks")
	public Page<Library> getLibrariesPagedAndSortedByNameAndWithTheseBooks(String commaSeparatedBookNames) {
		return readServiceImpl.getLibrariesPagedAndSortedByNameAndWithTheseBooks(commaSeparatedBookNames);
	}

	@GetMapping("/getLibrariesPagedAndSortedWithDefaultOrderByNameAndWithTheseBooks")
	public Page<Library> getLibrariesPagedAndSortedWithDefaultOrderByNameAndWithTheseBooks(
			String commaSeparatedBookNames, int pageNumber, int numberOfRecordsOnAPage) {
		return readServiceImpl.getLibrariesPagedAndSortedWithDefaultOrderByNameAndWithTheseBooks(
				commaSeparatedBookNames, pageNumber, numberOfRecordsOnAPage);
	}
	
	@GetMapping("/getLibrariesSortedByNameAndWithTheseBooks")
	public List<Library> getLibrariesSortedByNameAndWithTheseBooks(String commaSeparatedBookNames) {
		return readServiceImpl.getLibrariesSortedByNameAndWithTheseBooks(commaSeparatedBookNames);
	}
	
	@PostMapping("/getLibrariesByIds")
	public List<Library> getLibrariesByIds(@RequestBody List<Long> ids) {
		return readServiceImpl.getLibrariesByIds(ids);
	}
	
	@PostMapping("/getALibraryById")
	public Optional<Library> getALibraryById(Long id) {
		return readServiceImpl.getALibraryById(id);
	}
	
	@GetMapping("/getALibraryWithTheseBooks")
	public Optional<Library> getALibraryWithTheseBooks(String commaSeparatedBookNames) {
		return readServiceImpl.getALibraryWithTheseBooks(commaSeparatedBookNames);
	}
	
	@GetMapping("/getLibrariesPagedAndSortedByName")
	public Page<Library> getLibrariesPagedAndSortedByName() {
		return readServiceImpl.getLibrariesPagedAndSortedByName();
	}


}







