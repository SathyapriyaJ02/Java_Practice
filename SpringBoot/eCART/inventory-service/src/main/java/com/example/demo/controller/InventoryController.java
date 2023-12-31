package com.example.demo.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.dto.RequestInventory;
import com.example.demo.service.InventoryService;
import lombok.RequiredArgsConstructor;

 

@RestController
@RequestMapping("/inventory")
@RequiredArgsConstructor
public class InventoryController 
{

	private final InventoryService inventoryService;

	@GetMapping
	public List<RequestInventory> isInStrock(@RequestParam List<String> pName)
	{
		return inventoryService.isInStock(pName);

	}

 

}
