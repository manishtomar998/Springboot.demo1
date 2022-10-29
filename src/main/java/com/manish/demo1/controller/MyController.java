package com.manish.demo1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.manish.demo1.entities.Course;
import com.manish.demo1.entities.Errors;
import com.manish.demo1.services.CourseService;

@RestController
public class MyController {
	
	@Autowired
	private CourseService courseService;

	@GetMapping("/home")
	public String home() {
		return "This is home page";
	}
	
//	get the courses
	
	@GetMapping("/courses")
	public  List<Course> getCourses()
	{
		return this.courseService.getCourses();
	}
	
//	@GetMapping("/courses/{courseId}")
//	public Course getCourse(@PathVariable String courseId) {
//		return this.courseService.getCourse(Long.parseLong(courseId));
//	}
	
	@PostMapping("/courses")
	public Course addCourse(@RequestBody Course course) {
		return this.courseService.addCourse(course);
	}
	
	@GetMapping("/courses/{courseId}")
	public ResponseEntity<Course> getCourse(@PathVariable String courseId){
		try {
			Course x = new Course();
			x = this.courseService.getCourse(Long.parseLong(courseId));
			return new ResponseEntity<>(x,HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		catch(Exception e){
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
