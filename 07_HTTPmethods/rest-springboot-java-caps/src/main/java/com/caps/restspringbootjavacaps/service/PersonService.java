package com.caps.restspringbootjavacaps.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import com.caps.restspringbootjavacaps.model.Person;

@Service
public class PersonService {
	
	private final AtomicLong counter = new AtomicLong();
	private Logger logger = Logger.getLogger(PersonService.class.getName());
	
	public Person create(Person person) {
		logger.info("Create a person");
		return person;
	}
	
	public Person update(Person person) {
		logger.info("Update a person");
		return person;
	}
	
	public void delete(String id) {
		logger.info("Delete a person");
	}
	
	public List<Person> findAll() {
		logger.info("Finding all persons");
		List<Person> persons = new ArrayList<>();
		for (int i = 0; i < 8; i++) {
			Person person = mockPerson(i);
			persons.add(person);
		}
		return persons;
	}
	
	public Person findById(String id) {
			logger.info("Finding one person");
			Person person = new Person();
			person.setId(counter.incrementAndGet());
			person.setFirstName("Carlos");
			person.setLastName("Pereira da Silva");
			person.setAdress("Mauá-SP");
			person.setGender("Male");
			return person;
	}
	
	private Person mockPerson(int i) {
		Person person = new Person();
		person.setId(counter.incrementAndGet());
		person.setFirstName("Person First Name: " + i);
		person.setLastName("Person Last Name: " + i);
		person.setAdress("Person Adress: " + i);
		person.setGender("Male");
		return person;
	}

}
