package com.manish.demo1.services;

import java.util.List;

import com.manish.demo1.entities.Course;
import com.manish.demo1.entities.Notfound;

public interface CourseService {

	public List<Course> getCourses();
	
	public Course  getCourse(long courseId);
	
	public Course addCourse(Course course);

	public Notfound deleteCourse(long parseLong);
}
