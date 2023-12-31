package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

 

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderLineItemsDto
{

	private Integer productId;
	private String productName;
	private Double productPrice;
	private Integer productQuantity;

 

}
