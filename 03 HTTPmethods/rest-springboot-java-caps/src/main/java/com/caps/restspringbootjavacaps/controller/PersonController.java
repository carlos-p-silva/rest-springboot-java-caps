package com.caps.restspringbootjavacaps.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.caps.restspringbootjavacaps.model.Person;
import com.caps.restspringbootjavacaps.service.PersonService;

@RestController
@RequestMapping("/person")
public class PersonController {
	
	@Autowired
	private PersonService personService;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE )
	public Person findById(@PathVariable(value = "id") String id) {
		return personService.findById(id);
	}
	
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Person> findAll() {
		return personService.findAll();
	}
	
	@RequestMapping(method = RequestMethod.POST, 
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Person create(@RequestBody Person person) {
		return personService.create(person);
	}

	@RequestMapping(method = RequestMethod.PUT, 
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Person update(@RequestBody Person person) {
		return personService.create(person);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void delete(@RequestBody String id) {
		personService.delete(id);
	}

}
