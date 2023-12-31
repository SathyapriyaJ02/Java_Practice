package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

 

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="t_order_line_items")
public class OrderLineItems 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Integer id;
	private String productName; //skew code
	private Integer productQuantity;
	private Double productPrice;
}
