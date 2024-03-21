package com.caps.restspringbootjavacaps.service;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caps.restspringbootjavacaps.exceptions.ResourceNotFoundException;
import com.caps.restspringbootjavacaps.model.Person;
import com.caps.restspringbootjavacaps.repository.PersonRepository;

@Service
public class PersonService {
	
	@Autowired
	private PersonRepository repository;
	
	private Logger logger = Logger.getLogger(PersonService.class.getName());
	
	public Person create(Person person) {
		logger.info("Create a person");
		return repository.save(person);
	}
	
	public Person update(Person person) {
		logger.info("Update a person");
		
		var entity = repository.findById(person.getId())
				.orElseThrow(() -> new ResourceNotFoundException("No records for this ID"));
		
		entity.setId(person.getId());
		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setAdress(person.getAdress());
		entity.setGender(person.getGender());
		
		return repository.save(person);
	}
	
	public void delete(Long id) {
		logger.info("Delete a person");
		var entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records for this ID"));
		repository.delete(entity);
	}
	
	public List<Person> findAll() {
		logger.info("Finding all persons");
		return repository.findAll();
	}
	
	public Person findById(Long id) {
			logger.info("Finding a person");
			return repository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("No records for this ID"));
	}
	
}
