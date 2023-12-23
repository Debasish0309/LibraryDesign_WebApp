package com.glearning.library.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import com.glearning.library.entity.Library;
import com.glearning.library.repository.LibraryRepository;
import com.glearning.library.service.LibraryCountService;

@Service
public class LibraryCountServiceImpl implements LibraryCountService {
	
	@Autowired
	private LibraryRepository libraryRepository;
	
	@Override
	public long countLibraries() {
		return libraryRepository.count();
	}
	
	@Override
	public long countLibrariesWithZeroBooks() {
		Library library = new Library();
		library.setCommaSeparatedBooknames("");

		ExampleMatcher exampleMatcher = ExampleMatcher.matching().withMatcher("commaSeparatedBooknames",
				ExampleMatcher.GenericPropertyMatchers.exact()).withIgnorePaths("id","name");
		Example<Library> example=Example.of(library, exampleMatcher);
		return libraryRepository.count(example);
	}

}
