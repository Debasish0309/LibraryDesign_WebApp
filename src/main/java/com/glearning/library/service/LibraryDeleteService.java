package com.glearning.library.service;

import java.util.List;

import com.glearning.library.entity.Library;

public interface LibraryDeleteService {

	String deleteOneLibrary(Library library);

	String pruneTable();

	String deleteAllThese(List<Library> libraries);

	String deleteAllInBatch();

	String deleteLibraryById(Long id);

	String deleteAllTheseInBatch(List<Library> libraries);

}