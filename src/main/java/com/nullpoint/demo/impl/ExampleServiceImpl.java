package com.nullpoint.demo.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.nullpoint.demo.models.Person;
import com.nullpoint.demo.services.ExampleService;

@Service("exampleService")
public class ExampleServiceImpl implements ExampleService {

	@Override
	public List<Person> getListPeople() {
		List<Person> people = new ArrayList<Person>();

		people.add(new Person("Jesús", 33));
		people.add(new Person("Raul", 27));
		people.add(new Person("Pablo", 40));

		// TODO Auto-generated method stub
		return people;
	}

}
