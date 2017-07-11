package com.nullpoint.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/example1")
public class Example1Controller {

	public static final String HELLO_VIEW = "hello";

	@GetMapping("/hello/{name}")
	public ModelAndView hello(@PathVariable("name") String name) {
		ModelAndView modelAndView = new ModelAndView(HELLO_VIEW);
		modelAndView.addObject("name", name);
		return modelAndView;
	}
}
