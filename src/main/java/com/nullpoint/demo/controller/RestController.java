package com.nullpoint.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nullpoint.demo.model.ContactModel;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/rest")
public class RestController {

	@GetMapping("/checkrest")
	public ResponseEntity<ContactModel> checkRest() {
		ContactModel contactModel = new ContactModel(2, "Jesús", "De Nazaret", "777-77-77", "Belén");
		return new ResponseEntity<ContactModel>(contactModel, HttpStatus.OK);
	}
}
