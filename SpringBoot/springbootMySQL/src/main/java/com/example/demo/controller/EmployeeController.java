package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entity.Employee;
import com.example.demo.repo.EmployeeRepo;

@Controller
public class EmployeeController 
{
	@Autowired
	EmployeeRepo repo;
	
	@Autowired
	Employee e;
	
	
	
	@RequestMapping("/")
	
	public String Home()
	{
		return "Home.jsp";
	}
	
	@RequestMapping("/add")
	@ResponseBody
	public String Add(Employee e)
	{
		repo.save(e);
		return "employee create";
	}
	
	@RequestMapping("/search")
	@ResponseBody
	public String Search(String dname)
	{
		
		return repo.findByEdepartment(dname).toString();
	}
	
//	@RequestMapping("/view")
//	@ResponseBody
//	public String View()
//	{
//		
//		return repo.findAll().toString();
//	}
	
	@RequestMapping("/view")
	public ModelAndView displayEmp()
	{
		List<Employee> emp = (ArrayList<Employee>)repo.findAll();
		ModelAndView mv = new ModelAndView("display.jsp");
		mv.addObject("emp",emp);
		return mv;
	}
	
	
}
