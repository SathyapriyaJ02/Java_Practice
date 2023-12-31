package com.example.demo.repo;

import org.springframework.data.repository.CrudRepository;


import com.example.demo.model.Person;

public interface PersonRepo extends CrudRepository<Person,Integer>
{
	
}
