package com.example.demo.dto;

import com.example.demo.model.Product;

import jakarta.persistence.Entity;
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
public class ProductRequest 
{
	@Id
	private String productName;

	private Double productPrice;

	private Integer productQuantitiy;
}
