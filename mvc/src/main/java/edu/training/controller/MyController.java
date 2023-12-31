package edu.training.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {

	@RequestMapping("/printname")
//	public String printName(HttpServletRequest req)
//	{
//		String uname = req.getParameter("uname");
//		System.out.println(uname);
//		req.setAttribute("uname", uname);
//		
//		return "display.jsp";
//	}
	public ModelAndView print(String uname)
	{
		System.out.println(uname);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("uname",uname);
		mv.setViewName("display.jsp");
		return mv;
	}

}
