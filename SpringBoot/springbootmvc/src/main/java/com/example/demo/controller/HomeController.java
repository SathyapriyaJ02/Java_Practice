package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;

@Controller
public class HomeController 
{
	@Autowired
	Employee e;
	EmployeeService es = new EmployeeService ();
	
	@RequestMapping("/")
	public String homePage()
	{
		return "index.jsp";
		//return "Hi";
	}
	
//	@RequestMapping("/display")
//	public ModelAndView displayPage(String uname)
//	{
//		ModelAndView mv = new ModelAndView("display.jsp");
//		mv.addObject("uname",uname);
//		return mv;
//	}
	

	@RequestMapping("/add")
	public String displayPage(Employee emp)
	{
		es.add(emp);
		return "index.jsp";
	}
	
	 @RequestMapping("/viewEmployees")
	    public ModelAndView viewEmployees() {
		 	List<Employee> dispList = new ArrayList<>();
		 	dispList = es.display();
	        ModelAndView mv = new ModelAndView("display.jsp");
	        mv.addObject("employeeList", dispList);
	        return mv;
	    }
	
//	
//	
//	@RequestMapping("/display")
//	public ModelAndView displayPage(String uname)
//	{
//		ModelAndView mv = new ModelAndView("display.jsp");
//		mv.addObject("emp",e);
//		return mv;
//	}
//	
}
