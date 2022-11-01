package com.manish.demo1.services;

import java.util.List;
import java.util.concurrent.ExecutionException;

import com.manish.demo1.entities.Course;

public interface CourseService {

	public List<Course> getCourses() throws InterruptedException, ExecutionException;
	
	public Course getCourse(String documentId) throws InterruptedException, ExecutionException;
		
	public String addCourse(Course course) throws InterruptedException, ExecutionException;
	
	public String updateCourse(Course course) throws InterruptedException, ExecutionException;

	public String deleteCourse(String documentId);


}
