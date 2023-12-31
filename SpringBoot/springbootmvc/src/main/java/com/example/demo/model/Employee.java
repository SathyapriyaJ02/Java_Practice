package com.example.demo.model;

import org.springframework.stereotype.Component;

@Component
public class Employee {
	int eid;
	String ename;
	int esalary;
	String edepartment;
	
	
	
	
	
	public int getEid() {
		return eid;
	}





	public void setEid(int eid) {
		this.eid = eid;
	}





	public String getEname() {
		return ename;
	}





	public void setEname(String ename) {
		this.ename = ename;
	}





	public int getEsalary() {
		return esalary;
	}





	public void setEsalary(int esalary) {
		this.esalary = esalary;
	}





	public String getEdepartment() {
		return edepartment;
	}





	public void setEdepartment(String edepartment) {
		this.edepartment = edepartment;
	}





	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", ename=" + ename + ", esalary=" + esalary + "]";
	}
	
	

}
