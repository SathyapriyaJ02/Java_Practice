package com.example.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ProductRequest;
import com.example.demo.dto.ProductResponse;
import com.example.demo.service.ProductService;

@RestController
@RequestMapping("/product")

public class ProductController

{

//	private final ProductService productService;

	@Autowired
	ProductService productService;

	

	@PostMapping
	public void createProduct(@RequestBody ProductRequest productRequest)
	{
		productService.createNewProduct(productRequest);
	}
	
	@GetMapping
	public List<ProductResponse> getAllProducts()

	{

		List<ProductResponse> pList = productService.getProducts();

		return pList;

	}

 

}
