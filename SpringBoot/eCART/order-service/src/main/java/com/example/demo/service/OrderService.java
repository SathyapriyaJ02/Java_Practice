package com.example.demo.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

 

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.demo.dto.OrderLineItemsDto;
import com.example.demo.dto.OrderRequest;
import com.example.demo.dto.RequestInventory;
import com.example.demo.model.Order;
import com.example.demo.model.OrderLineItems;
import com.example.demo.repository.OrderRepo;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class OrderService 
{
	private final OrderRepo orderRepository;
	
	private final WebClient.Builder webClientBuilder;

	public String placeOrder(OrderRequest orderRequest)
	{
		
		String msg;
		Order order= new Order();
		order.setOrderNumber(UUID.randomUUID().toString());  //generate random numberOrderLineItemsDto
		order.setOrderLineItems(orderRequest.getOrderLineItemsDtoList().stream().map(dto ->mapToDto(dto)).toList());
		
		List<String> productName = order.getOrderLineItems().stream().map(names->names.getProductName()).toList();
		
		//Connection between order and inventory
		RequestInventory[] inventoryResponseArray = webClientBuilder.build().get()
		.uri("http://localhost:8181/inventory",uriBuilder -> uriBuilder.queryParam("pName", productName).build())		
		.retrieve()
		
		//converting list to object
		.bodyToMono(RequestInventory[].class)
		.block();
		
		boolean stockCheckStatics = Arrays.stream(inventoryResponseArray).allMatch(inventory -> inventory.isQuantity());
		
		if(stockCheckStatics)
		{		
			orderRepository.save(order);
			msg="Order placed successfully";
		}
		else
		{
			msg="Out of stock";
			//throw new IllegalArgumentException("Out Of stock!!");

		}

		return msg;
		
	}


	public OrderLineItems mapToDto(OrderLineItemsDto dto)
	{
		return OrderLineItems.builder()
				.id(dto.getProductId())
				.productName(dto.getProductName())
				.productPrice(dto.getProductPrice())
				.productQuantity(dto.getProductQuantity())
				.build();
	}
}