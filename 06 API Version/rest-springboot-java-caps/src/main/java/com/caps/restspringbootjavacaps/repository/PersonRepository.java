package com.caps.restspringbootjavacaps.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.caps.restspringbootjavacaps.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {}
