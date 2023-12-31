package com.example.demo.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@EnableMethodSecurity
public class HomeController {
		
		
		@RequestMapping("/public")
		@ResponseBody
		public String publicUser()
		{
			return "im a public user";
		}
		
		@PreAuthorize("hasRole('ADMIN')")
		@RequestMapping("/admin")
		@ResponseBody
		public String adminUser()
		{
			return "im a admin user";
		}
		
		@PreAuthorize("hasRole('CUSTOMER')")
		@RequestMapping("/customer")
		@ResponseBody
		public String customerUser()
		{
			return "im a customer user";
		}
		
}
