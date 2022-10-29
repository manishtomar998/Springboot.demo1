package com.manish.demo1.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.manish.demo1.entities.Course;

@Service
public class CourseServiceImpl implements CourseService {
	
	List<Course> list;
	
	public CourseServiceImpl() {
		
		list=new ArrayList<>();
		list.add(new Course(145,"Java","This is java course"));
		list.add(new Course(165,"React","This is React course"));
		}
	
	
	@Override
	public List<Course> getCourses() {
		return list;
	}


	@Override
	public Course getCourse(long courseId) {
		// TODO Auto-generated method stub
		Course c=null;
		for(Course course:list) {
			if(course.getId()==courseId) {
				c=course;
				break;
			}
		}
		return c;
	}


	@Override
	public Course addCourse(Course course) {
		// TODO Auto-generated method stub
		list.add(course);
		return course;
	}

}
