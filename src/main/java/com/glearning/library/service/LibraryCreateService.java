package com.glearning.library.service;

import java.util.List;

import com.glearning.library.entity.Library;

public interface LibraryCreateService {

	String addSingleLibraray(Library library);

	String addAllLibraries(List<Library> libraries);

	Library addLibraryWithSaveAndFlush(Library library);

}