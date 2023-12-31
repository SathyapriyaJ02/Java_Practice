package com.example.demo.repository;

import java.util.List;



import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Inventory;

 



 

public interface InventoryRepo extends JpaRepository<Inventory, Integer> 
{
	List<Inventory> findByProductNameIn(List<String> productName);

 

}