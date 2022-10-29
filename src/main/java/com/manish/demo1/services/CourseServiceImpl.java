package com.manish.demo1.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.manish.demo1.entities.Course;
import com.manish.demo1.entities.Notfound;

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
		Course c=new Course();
		for(Course course:list) {
			if(course.getId()==courseId) {
				c=course;
				break;
			} else {
				c.setId(90);
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
	
	@Override
	public Notfound deleteCourse(long courseId) {
		// TODO Auto-generated method stub
		List<Course> nako = list;
		list = this.list.stream().filter(e->e.getId()!=courseId).collect(Collectors.toList());
		if(nako.size()==list.size()) {
			Notfound msg = new Notfound();
			msg.setError("Id not found");
			return msg;
		}
		return null;

	}

}
