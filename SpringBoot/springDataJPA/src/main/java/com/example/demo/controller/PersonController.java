package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.Person;
import com.example.demo.repo.PersonRepo;

public class PersonController 
{
	@Autowired
	PersonRepo repo;
	
	
	@RequestMapping("/")
	public String homePage()
	{
		return "index.jsp";
		
	}
	
	@RequestMapping("/create")
	public String create(Person p)
	{
		repo.save(p);
		return "Person Create";
	}
}
		
