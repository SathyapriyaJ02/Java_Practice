package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


import com.example.demo.entity.Product;
import com.example.demo.repo.ProductRepo;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class ProductController 
{
	@Autowired
	ProductRepo repo;
	
	
	@CrossOrigin(origins="http://localhost:4200")
	@PostMapping("/add")
	public String addProduct(@RequestBody Product p)
	{
		repo.save(p);
		return "added";
	}
	@CrossOrigin(origins="http://localhost:4200")
	@GetMapping("/pview")
	@ResponseBody
	public List<Product> viewProduct()
	{
		return repo.findAll();
	}
	
	
	@RequestMapping("/pview/{pid}")
	public String viewProductById(@PathVariable("pid") String pid)
	{
		return repo.findById(pid).toString();
	}
	
	@CrossOrigin(origins="http://localhost:4200")
	@DeleteMapping("/delete/{product_id}")
	public String deleteProductById(@PathVariable("product_id") String product_id) {
	    repo.deleteById(product_id);
	    return "deleted";
	}
	
	
	
}
