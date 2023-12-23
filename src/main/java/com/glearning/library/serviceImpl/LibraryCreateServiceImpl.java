package com.glearning.library.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.glearning.library.entity.Library;
import com.glearning.library.repository.LibraryRepository;
import com.glearning.library.service.LibraryCreateService;

@Service
public class LibraryCreateServiceImpl implements LibraryCreateService {

	@Autowired
	private LibraryRepository libraryRepository;

	@Override
	public String addSingleLibraray(Library library) {
		libraryRepository.save(library);
		libraryRepository.flush();
		return "Library saved !!";
	}

	@Override
	public String addAllLibraries(List<Library> libraries) {
		libraryRepository.saveAll(libraries);
		libraryRepository.flush();
		return "all Libraries saved";
	}
	
	@Override
	public Library addLibraryWithSaveAndFlush(Library library) {
		return libraryRepository.saveAndFlush(library);
	}

}
