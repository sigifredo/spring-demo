package com.nullpoint.demo.controllers;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.nullpoint.demo.entity.Course;
import com.nullpoint.demo.services.CourseService;

@Controller
@RequestMapping("/courses")
public class CourseController {

	private static final String COURSES_VIEW = "courses";
	private static final Log LOGGER = LogFactory.getLog(CourseController.class);

	@Autowired
	@Qualifier("courseService")
	private CourseService courseService;

	@GetMapping("/listcourses")
	public ModelAndView listAllCourses() {
		LOGGER.info("Call: listAllCourses()");

		ModelAndView modelAndView = new ModelAndView(COURSES_VIEW);
		modelAndView.addObject("courses", courseService.listAllCourses());
		modelAndView.addObject("course", new Course());
		return modelAndView;
	}

	@PostMapping("/addcourse")
	public String addCourse(@ModelAttribute("course") Course course) {
		LOGGER.info("Call: addCourse() -- PARAM: " + course);

		courseService.addCourse(course);
		return "redirect:/courses/listcourses";
	}
}
