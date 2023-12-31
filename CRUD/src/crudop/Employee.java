package crudop;

public class Employee {
	
	private int eid;
	private String ename;
	private String edes;
	private double esalary;
	
	
	Employee(){}
	
	Employee(int eid,String ename,String edes,double esalary)
	{
		this.eid = eid;
		this.ename = ename;
		this.edes = edes;
		this.esalary = esalary;
	}
	public int getEid() 
	{
		return eid;
	}


	public void setEid(int eid) 
	{
		this.eid = eid;
	}


	public String getEname() 
	{
		return ename;
	}


	public void setEname(String ename)
	{
		this.ename = ename;
	}
	
	public String getEdes()
	{
		return edes;
	}
	
	public void setEdes(String edes)
	{
		this.edes=edes;
	}


	public double getEsalary() 
	{
		return esalary;
	}


	public void setEsalary(double esalary) 
	{
		this.esalary = esalary;
	}
	
	
	public String toString() {
		return eid+" "+ename+" "+edes+" "+esalary;
	}
	
	

}
