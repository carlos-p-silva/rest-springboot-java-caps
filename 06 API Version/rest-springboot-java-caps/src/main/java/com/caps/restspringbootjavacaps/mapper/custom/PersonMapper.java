package com.caps.restspringbootjavacaps.mapper.custom;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

import com.caps.restspringbootjavacaps.data.vo.v2.PersonVOV2;
import com.caps.restspringbootjavacaps.model.Person;

@Service
public class PersonMapper { 
	
	public PersonVOV2 convertEntityToVo(Person person) {
		PersonVOV2 vo = new PersonVOV2();
		vo.setId(person.getId());
		vo.setFirstName(person.getFirstName());
		vo.setLastName(person.getLastName());
		vo.setAdress(person.getAdress());
		vo.setBirthday(LocalDate.now());
		vo.setGender(person.getGender());
		return vo;
	}
	
	public Person convertVoToEntity(PersonVOV2 person) {
		Person entity = new Person();
		entity.setId(person.getId());
		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setAdress(person.getAdress());
		entity.setGender(person.getGender());
		return entity;
	}

}
