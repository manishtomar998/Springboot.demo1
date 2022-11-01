package com.manish.demo1.controller;

import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.manish.demo1.entities.Course;
import com.manish.demo1.services.CourseService;


@RestController
public class MyController {
	
	@Autowired
	private CourseService courseService;

	@GetMapping
	public String home() {
		return "This is home page";
	}
	

	
//	get the courses
	
	@GetMapping("/courses")
	public List<Course> getCourses() throws InterruptedException, ExecutionException
	{
		return this.courseService.getCourses();
	}
	
	@GetMapping("/course")
	public Course getCourse(@RequestParam String documentId) throws InterruptedException, ExecutionException
	{
		return this.courseService.getCourse(documentId);
	}
	
	
	@PutMapping("/courses")
	public String updateCourse(@RequestBody Course course) throws InterruptedException, ExecutionException {
		return this.courseService.updateCourse(course);
	}
	
	@PostMapping("/courses")
	public String addCourse(@RequestBody Course course) throws InterruptedException, ExecutionException {
		return this.courseService.addCourse(course);
	}
	
	@DeleteMapping("/courses")
	public String addCourse(@RequestParam String documentId) throws InterruptedException, ExecutionException {
		return this.courseService.deleteCourse(documentId);
	}
	
}
