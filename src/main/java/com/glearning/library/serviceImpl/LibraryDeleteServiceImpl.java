package com.glearning.library.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.glearning.library.entity.Library;
import com.glearning.library.repository.LibraryRepository;
import com.glearning.library.service.LibraryDeleteService;

@Service
public class LibraryDeleteServiceImpl implements LibraryDeleteService {
	
	@Autowired
	private LibraryRepository libraryRepository;
	
	@Override
	public String deleteOneLibrary(Library library) {
		libraryRepository.delete(library);
		return "delete the Library successfully: "+library;
	}
	
	@Override
	public String pruneTable() {
		libraryRepository.deleteAll();
		return "prune complete";
	}
	
	@Override
	public String deleteAllThese(List<Library> libraries) {
		libraryRepository.deleteAll(libraries);
		return "delete all complete";
	}
	
	@Override
	public String deleteAllInBatch() {
		//deleteAllInBatch it will delete few records at a time 
		libraryRepository.deleteAllInBatch();
		return "delete all in batch completed";
	}
	
	@Override
	public String deleteLibraryById(Long id) {
		libraryRepository.deleteById(id);
		return "Library with id -"+id+" is deleted";
	}
	
	@Override
	public String deleteAllTheseInBatch(List<Library> libraries) {
		libraryRepository.deleteInBatch(libraries);
		return "deleted all libraries in the list in batch mode";
	}

}
