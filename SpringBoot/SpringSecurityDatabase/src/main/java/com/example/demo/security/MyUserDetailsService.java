package com.example.demo.security;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.example.demo.entity.User;
import com.example.demo.repo.UserRepo;

@Component
public class MyUserDetailsService implements UserDetailsService {

	
	@Autowired
	UserRepo repo;
	
	@Override
	public UserDetails loadUserByUsername(String uname) throws UsernameNotFoundException {
		
		User user = repo.findByUname(uname);
		if(user==null)
		{
			throw new UsernameNotFoundException("User 404");
		}
		return new MyUserDetails(user);
	}

}
