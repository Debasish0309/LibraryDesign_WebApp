package com.glearning.library.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort.Direction;

import com.glearning.library.entity.Library;

public interface LibraryReadService {

	List<Library> getAllLibrary();

	List<Library> getAllLibrariesWithNoBooks();

	Page<Library> getLibrariesPaged();

	Page<Library> getLibrariesCustomPaged(int pageNumber, int numberOfRecordsOnApage);

	List<Library> getLibrariesWithLatestAddedOrder();

	List<Library> getLibrariesCustomSortedById(Direction direction);

	List<Library> getLibrariesCustomSortedByName(Direction direction);

	Page<Library> getLibrariesPagedAndSortedByNameAndWithTheseBooks(String commaSeparatedBookNames);

	Page<Library> getLibrariesPagedAndSortedByName();

	Page<Library> getLibrariesPagedAndSortedWithDefaultOrderByNameAndWithTheseBooks(String commaSeparatedBookNames,
			int pageNumber, int numberOfRecordsOnAPage);

	List<Library> getLibrariesSortedByNameAndWithTheseBooks(String commaSeparatedBookNames);

	List<Library> getLibrariesByIds(List<Long> ids);

	Optional<Library> getALibraryById(Long id);

	Optional<Library> getALibraryWithTheseBooks(String commaSeparatedBookNames);

}