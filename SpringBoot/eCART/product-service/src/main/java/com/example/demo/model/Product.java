package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product 
{
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer productID;
	private String productName;
	private Double productPrice;
	private Integer productQuantitiy;

}
