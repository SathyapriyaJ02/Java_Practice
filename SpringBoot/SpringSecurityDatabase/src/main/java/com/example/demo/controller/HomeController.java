package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.repo.UserRepo;

@RestController
@RequestMapping("/")
public class HomeController 
{
	@Autowired
	UserRepo repo;
	@GetMapping
	public ResponseEntity<String> home()
	{
		return ResponseEntity.ok("my Applicaion Started");
	}
	@GetMapping("/public")
	public ResponseEntity<String> publicUser()
	{
		User user = new User();
		user.setUid(20);
		user.setUname("Sathya");
		user.setPwd(new BCryptPasswordEncoder().encode("1234"));
		user.setRole("ROLE_ADMIN");
		repo.save(user);
		return ResponseEntity.ok("I am a public user");
	}
	
	@GetMapping("/admin")
	public ResponseEntity<String> adminUser()
	{
		return ResponseEntity.ok("I am a admin user");
	}
	
	@GetMapping("/customer")
	public ResponseEntity<String> customerUser()
	{
		
		
		return ResponseEntity.ok("I am a Customer User");
	}
	
}
