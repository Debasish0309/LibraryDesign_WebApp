package com.glearning.library.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.glearning.library.entity.Library;
import com.glearning.library.repository.LibraryRepository;
import com.glearning.library.service.LibraryReadService;

@Service
public class LibraryReadServiceImpl implements LibraryReadService {

	@Autowired
	private LibraryRepository readRepository;

	@Override
	public List<Library> getAllLibrary() {
		return readRepository.findAll();
	}

	@Override
	public List<Library> getAllLibrariesWithNoBooks() {
		Library libraryWithNoBooks = new Library();
		libraryWithNoBooks.setCommaSeparatedBooknames("");
		// System.out.println("just to show you how the objects looks like " +
		// libraryWithNoBooks);

		// below ExampleMatcher will make you sure that only commaSeparatedBooks is
		// considered and id,name will be ignored
		ExampleMatcher exampleMatcher = ExampleMatcher.matching()
				.withMatcher("commaSeparatedBooknames", ExampleMatcher.GenericPropertyMatchers.exact())
				.withIgnorePaths("id", "name");
		Example<Library> example = Example.of(libraryWithNoBooks, exampleMatcher);
		return readRepository.findAll(example);
	}

	@Override
	public Page<Library> getLibrariesPaged() {
		Pageable first3Records = PageRequest.of(0, 3);// it will print the first 3 libraries
		return readRepository.findAll(first3Records);
	}

	@Override
	public Page<Library> getLibrariesCustomPaged(int pageNumber, int numberOfRecordsOnApage) {
		Pageable first3Records = PageRequest.of(pageNumber, numberOfRecordsOnApage);
		return readRepository.findAll(first3Records);
	}

	@Override
	public List<Library> getLibrariesWithLatestAddedOrder() {
		return readRepository.findAll(Sort.by(Direction.DESC, "id"));
	}

	@Override
	public List<Library> getLibrariesCustomSortedById(Direction direction) {
		return readRepository.findAll(Sort.by(direction, "id"));
	}

	@Override
	public List<Library> getLibrariesCustomSortedByName(Direction direction) {
		return readRepository.findAll(Sort.by(direction, "name"));
	}

	@Override
	public Page<Library> getLibrariesPagedAndSortedByNameAndWithTheseBooks(String commaSeparatedBookNames) {
		Library libraryWithTheseBooks = new Library();
		libraryWithTheseBooks.setCommaSeparatedBooknames(commaSeparatedBookNames);
		ExampleMatcher exampleMatcher = ExampleMatcher.matching()
				.withMatcher("commaSeparatedBooknames", ExampleMatcher.GenericPropertyMatchers.exact())
				.withIgnorePaths("id", "name");
		Example<Library> example = Example.of(libraryWithTheseBooks, exampleMatcher);
		Pageable customPage = PageRequest.of(0, 2, Sort.by("name"));
		return readRepository.findAll(example, customPage);
	}
	
	@Override
	public Page<Library> getLibrariesPagedAndSortedByName() {
		Pageable pageable=PageRequest.of(0, 2, Sort.by("name"));
		return readRepository.findAll(pageable);
	}

	@Override
	public Page<Library> getLibrariesPagedAndSortedWithDefaultOrderByNameAndWithTheseBooks(String commaSeparatedBookNames,
			int pageNumber, int numberOfRecordsOnAPage) {
		Library libraryWithTheseBooks = new Library();
		libraryWithTheseBooks.setCommaSeparatedBooknames(commaSeparatedBookNames);
		ExampleMatcher exampleMatcher = ExampleMatcher.matching()
				.withMatcher("commaSeparatedBooknames", ExampleMatcher.GenericPropertyMatchers.exact())
				.withIgnorePaths("id", "name");
		Example<Library> example = Example.of(libraryWithTheseBooks, exampleMatcher);
		Pageable customPage = PageRequest.of(pageNumber,numberOfRecordsOnAPage , Sort.by("name"));
		return readRepository.findAll(example, customPage);

	}

	@Override
	public List<Library> getLibrariesSortedByNameAndWithTheseBooks(String commaSeparatedBookNames) {
		Library libraryWithTheseBooks = new Library();
		libraryWithTheseBooks.setCommaSeparatedBooknames(commaSeparatedBookNames);
		ExampleMatcher exampleMatcher = ExampleMatcher.matching()
				.withMatcher("commaSeparatedBooknames", ExampleMatcher.GenericPropertyMatchers.exact())
				.withIgnorePaths("id", "name");
		Example<Library> example = Example.of(libraryWithTheseBooks, exampleMatcher);
		return readRepository.findAll(example, Sort.by("name"));
		
	}
	
	@Override
	public List<Library> getLibrariesByIds(List<Long> ids) {
		return readRepository.findAllById(ids);
	}
	
	@Override
	public Optional<Library> getALibraryById(Long id) {
		return readRepository.findById(id);
	}
	
	@Override
	public Optional<Library> getALibraryWithTheseBooks(String commaSeparatedBookNames) {
		Library libraryWithTheseBooks = new Library();
		libraryWithTheseBooks.setCommaSeparatedBooknames(commaSeparatedBookNames);
		ExampleMatcher exampleMatcher = ExampleMatcher.matching()
				.withMatcher("commaSeparatedBooknames", ExampleMatcher.GenericPropertyMatchers.exact())
				.withIgnorePaths("id", "name");
		Example<Library> example = Example.of(libraryWithTheseBooks, exampleMatcher);
		return readRepository.findOne(example);
	}
	
	
	
	
}
