package com.example.demo.dto;

import com.example.demo.model.Product;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductResponse 
{
	//private Integer productID;

	private String productName;

	private Double productPrice;

	private Integer productQuantitiy;
}
