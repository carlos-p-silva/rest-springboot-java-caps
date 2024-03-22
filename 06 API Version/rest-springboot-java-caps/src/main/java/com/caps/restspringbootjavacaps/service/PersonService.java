package com.caps.restspringbootjavacaps.service;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caps.restspringbootjavacaps.data.vo.v1.PersonVO;
import com.caps.restspringbootjavacaps.data.vo.v2.PersonVOV2;
import com.caps.restspringbootjavacaps.exceptions.ResourceNotFoundException;
import com.caps.restspringbootjavacaps.mapper.ModelMapperConfig;
import com.caps.restspringbootjavacaps.mapper.custom.PersonMapper;
import com.caps.restspringbootjavacaps.model.Person;
import com.caps.restspringbootjavacaps.repository.PersonRepository;

@Service
public class PersonService {
	
	@Autowired
	private PersonRepository repository;
	@Autowired
	private PersonMapper mapper;
	
	private Logger logger = Logger.getLogger(PersonService.class.getName());
	
	public List<PersonVO> findAll() {
		logger.info("Finding all persons");
		return ModelMapperConfig.parseListObject(repository.findAll(), PersonVO.class);
	}
	
	public PersonVO findById(Long id) {
		logger.info("Finding a person");
		var entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records for this ID"));
		return ModelMapperConfig.parseObject(entity, PersonVO.class);
	}

	
	public PersonVO create(PersonVO person) {
		logger.info("Create a person");
		var entity = ModelMapperConfig.parseObject(person, Person.class);
		var vo = ModelMapperConfig.parseObject(repository.save(entity), PersonVO.class);
		return vo;
	}
	
	public PersonVOV2 createV2(PersonVOV2 person) {
		logger.info("Create a person");
		var entity = mapper.convertVoToEntity(person);
		var vo = mapper.convertEntityToVo(entity);
		return vo;
	}
	
	public PersonVO update(PersonVO person) {
		logger.info("Update a person");
		
		var entity = repository.findById(person.getId())
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

			entity.setFirstName(person.getFirstName());
			entity.setLastName(person.getLastName());
			entity.setAdress(person.getAdress());
			entity.setGender(person.getGender());
			
			var vo =  ModelMapperConfig.parseObject(repository.save(entity), PersonVO.class);
			return vo;
	}
	
	public void delete(Long id) {
		logger.info("Delete a person");
		var entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records for this ID"));
		repository.delete(entity);
	}
	
}
