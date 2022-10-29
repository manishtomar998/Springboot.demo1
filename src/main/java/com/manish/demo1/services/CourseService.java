package com.manish.demo1.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.manish.demo1.entities.Course;
import com.manish.demo1.entities.Errors;

public interface CourseService {

	public List<Course> getCourses();
	
	public ResponseEntity<Errors> getCourse(long courseId);
	
	public Course addCourse(Course course);
}
