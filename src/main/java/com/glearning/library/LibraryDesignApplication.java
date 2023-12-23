package com.glearning.library;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Sort.Direction;

import com.glearning.library.entity.Library;
import com.glearning.library.model.FullName;
import com.glearning.library.model.GreatLearning;
import com.glearning.library.service.LibraryCountService;
import com.glearning.library.service.LibraryCreateService;
import com.glearning.library.service.LibraryDeleteService;
import com.glearning.library.service.LibraryExistService;
import com.glearning.library.service.LibraryReadService;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class LibraryDesignApplication implements CommandLineRunner {

	@Autowired
	private LibraryReadService libraryReadServiceImpl;
	@Autowired
	private LibraryCreateService createServiceImpl;
	@Autowired
	private LibraryCountService countServiceImpl;
	@Autowired
	private LibraryExistService existServiceImpl;
	@Autowired
	private LibraryDeleteService deleteServiceImpl;

	public static void main(String[] args) {
		SpringApplication.run(LibraryDesignApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//exampleServiceImplImplementation();
		//readServiceImplMethodsExecution();
		//createServiceImplMethodsExecution();
		//countSericeImplMethodsExecution();
		//existsServiceImplMethodsExecution();
		//deleteServiceImplMethodsExecution();

	}
    
	@SuppressWarnings("unused")
	private void deleteServiceImplMethodsExecution() {
//		log.info("delete one library -> {}", deleteServiceImpl
//				.deleteOneLibrary(Library.builder().id(10l).name("C Library").commaSeparatedBooknames("xyz,abc,efg").build()));
//		log.info("prune Library Table complete -> {}", deleteServiceImpl.pruneTable());
//		
//		List<Library> libraries=new ArrayList<>();
//		libraries.add(Library.builder().id(3l).name("Animal Library").commaSeparatedBooknames("").build());
//		libraries.add(Library.builder().id(4l).name("Cloud Library").commaSeparatedBooknames("").build());
//		log.info("delete all these -> {}", deleteServiceImpl.deleteAllThese(libraries));
//		
//		log.info("delete all in Batch -> {}", deleteServiceImpl.deleteAllInBatch());
//		log.info("delete Library by Id -> {}", deleteServiceImpl.deleteLibraryById(2l));
//		
//		List<Library> libraries1=new ArrayList<>();
//		libraries.add(Library.builder().id(3l).name("Animal Library").commaSeparatedBooknames("").build());
//		libraries.add(Library.builder().id(4l).name("Cloud Library").commaSeparatedBooknames("").build());
//		log.info("Deleting all the libraries in batch -> {}", deleteServiceImpl.deleteAllTheseInBatch(libraries1));
	}
    
	@SuppressWarnings("unused")
	private void existsServiceImplMethodsExecution() {
		log.info("check if Library exist by id -> {}", existServiceImpl.checkLibraryExistsById(5l));
		log.info("check if Library exist by example -> {}",
				existServiceImpl.checkLibraryExistsByExample("Mars Red Planet,Titan with water"));
	}
    
	@SuppressWarnings("unused")
	private void countSericeImplMethodsExecution() {
		log.info("count the number of libraries -> {}", countServiceImpl.countLibraries());
		log.info("count the number of libraries with no Books -> {}", countServiceImpl.countLibrariesWithZeroBooks());
	}
    
	@SuppressWarnings("unused")
	private void createServiceImplMethodsExecution() {
		log.info("persist a single Library -> {}", createServiceImpl.addSingleLibraray(
				Library.builder().id(11l).name("E Library").commaSeparatedBooknames("xyz,abc").build()));

		List<Library> libraries = new ArrayList<>();
		libraries.add(Library.builder().id(12l).name("F Library").commaSeparatedBooknames("abc,efg").build());
		libraries.add(Library.builder().id(13l).name("G Library").commaSeparatedBooknames("efg").build());
		log.info("Persist all Libraries -> {}", createServiceImpl.addAllLibraries(libraries));
		
		log.info("persit a Library with saveAndFlush combined -> {}", createServiceImpl.addLibraryWithSaveAndFlush(
				Library.builder().id(14l).name("E-Commerce Library").commaSeparatedBooknames("Amazon,Flipkart").build()));
	}
    
	@SuppressWarnings("unused")
	private void exampleServiceImplImplementation() {
		GreatLearning gLearning = new GreatLearning();
		gLearning.setCourseName("Java");
		gLearning.setCourseType("IT");
		gLearning.setInstructorName(new FullName("Debasish", "Jena"));

		System.out.println("Course name ->" + gLearning.getCourseName());
		System.out.println("Course type ->" + gLearning.getCourseType());
		System.out.println("instructor name ->" + gLearning.getInstructorName());

		GreatLearning glComplexObj = GreatLearning.builder().courseName("Builder design patter").courseType("It")
				.instructorName(FullName.builder().firstName("Debs").lastname("jena").build()).build();
		// System.out.println("Builder design pattern "+glComplexObj);
		log.info("Complex object creation -> {} ", glComplexObj);
	}
    
	@SuppressWarnings("unused")
	private void readServiceImplMethodsExecution() {
		// List<Library> libraries= libraryReadServiceImpl.getAllLibrary();
		// log.info("Fetch all Libraries -> { }" , libraries);

		// it is uquivalent to the above two lines
		log.info("Fetch all Libraries -> {}", libraryReadServiceImpl.getAllLibrary());

		// calling the getAllLibrariesWithNoBooks
		// libraryReadServiceImpl.getAllLibrariesWithNoBooks();
		log.info("Fetch all Libraries with No Books -> {}", libraryReadServiceImpl.getAllLibrariesWithNoBooks());
		log.info("Fetch Libraries in Page Format -> {}",
				libraryReadServiceImpl.getLibrariesPaged().get().collect(Collectors.toList()));
		log.info("Fetch Libraries in custom page format -> {}",
				libraryReadServiceImpl.getLibrariesCustomPaged(2, 2).get().collect(Collectors.toList()));// page number
																											// two with
																											// 2 records
		log.info("fetch libraries with latest added order -> {}",
				libraryReadServiceImpl.getLibrariesWithLatestAddedOrder());
		log.info("fetch libraries custom sorted by id -> {}",
				libraryReadServiceImpl.getLibrariesCustomSortedById(Direction.DESC));
		log.info("fetch libraries custom sorted by Name -> {}",
				libraryReadServiceImpl.getLibrariesCustomSortedByName(Direction.DESC));
		log.info("fetch libraries default paged,sorted and with these books -> {}", libraryReadServiceImpl
				.getLibrariesPagedAndSortedByNameAndWithTheseBooks("xyz,abc,efg").get().collect(Collectors.toList()));
		log.info("fetch libraries default paged and default sorted by name -> {}",
				libraryReadServiceImpl.getLibrariesPagedAndSortedByName().get().collect(Collectors.toList()));
		log.info("fetch libraries custom page and default sorted by name and with these books -> {}",
				libraryReadServiceImpl
						.getLibrariesPagedAndSortedWithDefaultOrderByNameAndWithTheseBooks("xyz,abc,efg", 1, 2).get()
						.collect(Collectors.toList()));
		log.info("fetch libraries with default sorted by name -> {}",
				libraryReadServiceImpl.getLibrariesSortedByNameAndWithTheseBooks("xyz,abc,efg"));

		List<Long> ids = new ArrayList<>();
		ids.add(1l);
		ids.add(2l);
		log.info("fetch libraries by ids -> {}", libraryReadServiceImpl.getLibrariesByIds(ids));

		long id = 15l;
		Optional<Library> optionalLibrary = libraryReadServiceImpl.getALibraryById(id);
		if (optionalLibrary.isPresent()) {
			log.info("fetch library by id -> {}", optionalLibrary.get());
		} else {
			log.info("No matching library with this id :" + id + " was found in the db");
		}

		Optional<Library> optionalSingleLibrary = libraryReadServiceImpl
				.getALibraryWithTheseBooks("life of tommy, life of browine");
		if (optionalSingleLibrary.isPresent()) {
			log.info("fetch libraries with these books -> {}", optionalSingleLibrary.get());
		} else {
			log.info("No library with this id :" + id + " was found in the db");
		}
	}

}
