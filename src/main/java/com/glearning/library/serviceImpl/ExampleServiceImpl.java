package com.glearning.library.serviceImpl;

import org.springframework.stereotype.Service;

import com.glearning.library.model.FullName;
import com.glearning.library.model.GreatLearning;
import com.glearning.library.service.ExampleService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ExampleServiceImpl implements ExampleService {

	@Override
	public GreatLearning get() {
		log.info("Inside get() method");
		GreatLearning glearning=new GreatLearning();
		glearning.setCourseName("Learn Controllers in spring boot");
		glearning.setCourseType("IT");
		glearning.setInstructorName(FullName.builder().firstName("Debasish").lastname("jena").build());
		return glearning;
	}

	@Override
	public GreatLearning customInfo(String courseName, String courseType, String firstName, String lastName) {
		log.info("Inside customInfo() method");
		GreatLearning glearning=new GreatLearning();
		glearning.setCourseName(courseName);
		glearning.setCourseType(courseType);
		
		FullName fullName=FullName.builder().firstName(firstName).lastname(lastName).build();
		glearning.setInstructorName(fullName);
		return glearning;
	}

}
