package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

 

import org.springframework.stereotype.Service;
import com.example.demo.dto.ProductRequest;
import com.example.demo.dto.ProductResponse;
import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService 
{
	private final ProductRepo productRepository;


	public void createNewProduct(ProductRequest productRequest)
	{
//        Product product = new Product();

//		product.setProductName(productRequest.getProductName());
//		product.setProductPrice(productRequest.getProductPrice());
//		product.setProductQuantitiy(productRequest.getProductQuantitiy());

		Product product=Product.builder()
							.productName(productRequest.getProductName())
							.productPrice(productRequest.getProductPrice())
							.productQuantitiy(productRequest.getProductQuantitiy())
							.build();
		productRepository.save(product);


		//if i am using builder i have to use builder() so that i will get it as prototype otherwise 
		//i will get it as singleton.

	}


	public List<ProductResponse> getProducts()
	{
		List<Product> products = productRepository.findAll();
		List<ProductResponse> responseProduct = new ArrayList<>();
		for(Product p: products)
		{
			responseProduct.add(mapToProductResponse(p));
		}
		return responseProduct;		
	}


	private ProductResponse mapToProductResponse(Product prod)
	{
		ProductResponse ps = new ProductResponse();
		//ps.setProductID(prod.getProductID());
		ps.setProductName(prod.getProductName());
		ps.setProductPrice(prod.getProductPrice());
		ps.setProductQuantitiy(prod.getProductQuantitiy());
		return ps;
	}

 

	

 

}
