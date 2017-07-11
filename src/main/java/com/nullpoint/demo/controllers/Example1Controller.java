package com.nullpoint.demo.controllers;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.nullpoint.demo.components.Example1Component;
import com.nullpoint.demo.models.Person;

@Controller
@RequestMapping("/example1")
public class Example1Controller {

	public static final String HELLO_VIEW = "hello";
	private static final Log LOGGER = LogFactory.getLog(Example1Controller.class);

	@Autowired
	@Qualifier("example1Component")
	private Example1Component example1Component;

	@GetMapping("/hello/{name}")
	public ModelAndView hello(@PathVariable("name") String name) {
		LOGGER.info("INFO TRACE");
		LOGGER.warn("WARNING TRACER");
		LOGGER.error("ERROR TRACER");
		LOGGER.debug("DEBUG TRACER");
		example1Component.sayHello();

		Person person = new Person(name, 33);
		LOGGER.info("INFO: " + person);

		ModelAndView modelAndView = new ModelAndView(HELLO_VIEW);
		modelAndView.addObject("name", name);
		return modelAndView;
	}
}
