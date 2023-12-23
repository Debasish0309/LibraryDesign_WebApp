package com.glearning.library.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GreatLearning {
	
	private String courseName;
	private String courseType;
	private FullName instructorName;
	
	public GreatLearning(String courseName){
		this.courseName = courseName;
	}
	
	public GreatLearning(String courseName,String courseType){
		this.courseName = courseName;
		this.courseType = courseType;
	}
	

}
