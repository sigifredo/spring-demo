package com.nullpoint.demo.service.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.nullpoint.demo.entity.Course;
import com.nullpoint.demo.repository.CourseJpaRepository;
import com.nullpoint.demo.services.CourseService;

@Service("courseService")
public class CourseServiceImpl implements CourseService {

	private static final Log LOGGER = LogFactory.getLog(CourseServiceImpl.class);

	@Autowired
	@Qualifier("courseJpaRepository")
	private CourseJpaRepository courseJpaRepository;

	@Override
	public List<Course> listAllCourses() {
		LOGGER.info("Call: listAllCourses()");
		return courseJpaRepository.findAll();
	}

	@Override
	public Course addCourse(Course course) {
		LOGGER.info("Call: addCourse() -- PARAM: " + course);
		return courseJpaRepository.save(course);
	}

	@Override
	public int removeCourse(int id) {
		courseJpaRepository.delete(id);
		return 0;
	}

	@Override
	public Course updateCourse(Course course) {
		return courseJpaRepository.save(course);
	}

}
