package crudop;


import java.util.*;
import java.sql.*;

public class EmployeeService 
{
	static Employee emp = new Employee();
	static PreparedStatement ps;
	static ResultSet rs;
	static Scanner sc = new Scanner(System.in);
	
	
	public static void createEmp(Connection con,int eid) throws SQLException
	{
		
		Employee e =searchEmp(con,emp.getEid());
		System.out.println("Employee already exist");
		
		if(e==null)
		{
			System.out.print("Enter employee name : ");
			emp.setEname(sc.next());
			System.out.print("Enter employee designation : ");
			emp.setEdes(sc.next());
			System.out.print("Enter employee salary : ");
			emp.setEsalary(sc.nextDouble());
			
			ps = con.prepareStatement("insert into employee values(?,?,?,?)");
			ps.setInt(1,emp.getEid());
			ps.setString(2, emp.getEname());
			ps.setString(3, emp.getEdes());
			ps.setDouble(4, emp.getEsalary());
			
			int r = ps.executeUpdate();
			if(r==1)
			{
				System.out.println("\nNew employee created.");
			}
			else
			{
				System.out.println("Creating new employee failed");
			}
		}
	}
	public static void updateEmp(Connection con)throws SQLException

	{
		Employee e =searchEmp(con,emp.getEid());
		int ur = 0;
		if(e==null)
		{
			System.out.println("Employee doesnt exist");
		}
		else
		{
			System.out.println(e);
			System.out.println("1.update name");
			System.out.println("2.update designation");
			System.out.println("3.update salary");
			System.out.println("select the option");
			int choice = sc.nextInt();
			
			switch(choice)
			{
			case 1:
				
				System.out.println("Enter the new name");
				emp.setEname(sc.next());
				ps = con.prepareStatement("update employee set ename=? where eid=?");
				ps.setString(1,emp.getEname());
				ps.setInt(2, emp.getEid());
				ps.executeUpdate();
				break;
				
			case 2:
				System.out.println("Enter the new designation");
				emp.setEdes(sc.next());
				ps = con.prepareStatement("update employee set edes=? where eid=?");
				ps.setString(1, emp.getEdes());
				ps.setInt(2, emp.getEid());
				ur = ps.executeUpdate();
				break;
				
				
				
			case 3:
				System.out.println("Enter the new salary");
				emp.setEsalary(sc.nextDouble());
				ps = con.prepareStatement("update employee set esalary=? where eid=?");
				ps.setDouble(1, emp.getEsalary());
				ps.setInt(2, emp.getEid());
				ur= ps.executeUpdate();
				break;
				
			}
			if(ur==1)
			{
				
				System.out.println("Employee details successfully updated.");
				
			}
			else
			{
				System.out.println("Update failed.");
				
			}
		}
		
	}
	public static Employee searchEmp(Connection con,int eid) throws SQLException
	{
		Employee e = null;
		System.out.println("Enter Employee ID:");
		int id = sc.nextInt();
		ps = con.prepareStatement("select * from employee where eid=?");
		ps.setInt(1,id);
		rs=ps.executeQuery();
		while(rs.next())
		{
			e = new Employee(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDouble(4));
		}
		return e;
		
		
	} 
	public static void deleteEmp(Connection con,int eid) throws SQLException
	{
		
		Employee e = searchEmp(con,emp.getEid());
		
		if(e==null)
		{
			System.out.println("Employee doesnt exist");
		}
		else
		{
			ps=con.prepareStatement("delete from employee where eid=?");
			ps.setInt(1, emp.getEid());
		    int d=ps.executeUpdate();
		    System.out.println("Employee "+eid+" deleted successfully.");
		}
		
		
	}
	public static void displayEmp(Connection con) throws SQLException
	{
			
			ps = con.prepareStatement("select * from employee");
			rs = ps.executeQuery();
			
			while(rs.next()) 
			{
				
				emp.setEid(rs.getInt(1));
				emp.setEname(rs.getString(2));
				emp.setEdes(rs.getString(3));
				emp.setEsalary((int) rs.getDouble(4));
				System.out.println(emp);
				System.out.println();
			}
		
		}
}
