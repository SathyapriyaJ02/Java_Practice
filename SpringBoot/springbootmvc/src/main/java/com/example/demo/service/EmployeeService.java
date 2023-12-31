package com.example.demo.service;
import java.util.*;
import java.util.ArrayList;


import org.springframework.stereotype.Service;

import com.example.demo.model.Employee;

@Service
public class EmployeeService 
{
	List<Employee> empList = new ArrayList<>();
	public void add(Employee emp)
	{
		empList.add(emp);
		
	}
	public List<Employee> display()
	{
		return empList;
	}
}
