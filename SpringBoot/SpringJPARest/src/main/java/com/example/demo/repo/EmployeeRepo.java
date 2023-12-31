package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.demo.entity.Employee;


@RepositoryRestResource(collectionResourceRel = "employee" , path="employee")
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

}
