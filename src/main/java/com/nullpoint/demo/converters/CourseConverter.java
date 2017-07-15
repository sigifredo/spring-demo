package com.nullpoint.demo.converters;

import org.springframework.stereotype.Component;

import com.nullpoint.demo.entity.Course;
import com.nullpoint.demo.models.CourseModel;

@Component("courseConverter")
public class CourseConverter {

	public CourseModel entity2model(Course course) {
		CourseModel courseModel = new CourseModel();

		courseModel.setName(course.getName());
		courseModel.setDescription(course.getDescription());
		courseModel.setPrice(course.getPrice());
		courseModel.setHours(course.getHours());

		return courseModel;
	}

	public Course model2entity(CourseModel courseModel) {
		Course course = new Course();

		course.setName(courseModel.getName());
		course.setDescription(courseModel.getDescription());
		course.setPrice(courseModel.getPrice());
		course.setHours(courseModel.getHours());

		return course;
	}

}
