package com.glearning.library.serviceImpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import com.glearning.library.entity.Library;
import com.glearning.library.repository.LibraryRepository;
import com.glearning.library.service.LibraryExistService;

@Service
public class LibraryExistServiceImpl implements LibraryExistService {
	
	@Autowired
	private LibraryRepository libraryRepository;
	
	@Override
	public boolean checkLibraryExistsById(Long id) {
		return libraryRepository.existsById(id);
	}
	
	@Override
	public boolean checkLibraryExistsByExample(String commaSeparatedBookNames) {
		Library library = new Library();
		library.setCommaSeparatedBooknames(commaSeparatedBookNames);

		ExampleMatcher exampleMatcher = ExampleMatcher.matching().withMatcher("commaSeparatedBooknames",
				ExampleMatcher.GenericPropertyMatchers.exact()).withIgnorePaths("id","name");
		Example<Library> example=Example.of(library, exampleMatcher);
		return libraryRepository.exists(example);
	}

}
