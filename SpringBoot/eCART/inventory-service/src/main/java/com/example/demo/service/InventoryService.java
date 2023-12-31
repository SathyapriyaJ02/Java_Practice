package com.example.demo.service;

import java.util.List;



import org.springframework.stereotype.Service;

import com.example.demo.dto.RequestInventory;
import com.example.demo.model.Inventory;
import com.example.demo.repository.InventoryRepo;

import lombok.RequiredArgsConstructor;

 

@Service
@RequiredArgsConstructor
public class InventoryService 
{
	private final InventoryRepo inventoryRepository;
	public List<RequestInventory> isInStock(List<String> productName)
	{
		List<Inventory> iList = inventoryRepository.findByProductNameIn(productName);
		List<RequestInventory> rList = iList.stream().map(product -> mapToRequestInventory(product)).toList();
		return rList;

	}


	public RequestInventory mapToRequestInventory(Inventory inv)
	{
		return RequestInventory.builder()
				.productName(inv.getProductName())
				.quantity(inv.getQuantity()>0)
				.build();


	}


 

}
