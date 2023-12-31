package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.model.Inventory;
import com.example.demo.repository.InventoryRepo;

 



 

@SpringBootApplication
public class InventoryServiceApplication 
{

	//@Bean
	public CommandLineRunner loadData(InventoryRepo inventoryRepository)
	{
		return args -> {
			Inventory phone = Inventory.builder().build();

			phone.setProductName("Moto");
			phone.setQuantity(9);

			inventoryRepository.save(phone);

			Inventory laptop = Inventory.builder().build();

			laptop.setProductName("Asus");
			laptop.setQuantity(92);

			inventoryRepository.save(laptop);

		};
	}

 

	public static void main(String[] args) 
	{
		SpringApplication.run(InventoryServiceApplication.class, args);
	}

 

}
