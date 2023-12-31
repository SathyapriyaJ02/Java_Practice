package crudop;

import java.util.*;
import java.sql.*;


public class Main 
{
	public static void main(String a[]) 
	{
		Employee emp = new Employee();      //obj of pojo class
		try
		{
			Scanner sc = new Scanner(System.in);
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("success");
			System.out.println("Welcome to Employee Database");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/prodapt","root","root");
			int choice = 0;
			while(choice != 6)
			{
			
				System.out.println("\nService Provided ");
				System.out.println("1.Create\n2.Update\n3.Search\n4.Delete\n5.Display\n6.Exit");
				System.out.println("Enter your choice :\n");
				choice = sc.nextInt();
				
				switch(choice)
				{
				case 1 : 
					EmployeeService.createEmp(con,emp.getEid());
					break;
				case 2:
					EmployeeService.updateEmp(con);
					break;
				case 3:
					Employee e = EmployeeService.searchEmp(con,emp.getEid());
					if(e == null)
					{
						System.out.println("Employee doesnt exist.");
					}
					else
					{
						System.out.println("Employee Found.");
						System.out.println(e);
					}
					
					break;
				case 4:
					EmployeeService.deleteEmp(con,emp.getEid());
					break;
				case 5:
					EmployeeService.displayEmp(con);
				case 6:
					System.exit(1);
					break;
				default:
					System.out.println("Enter Valid Option!!!");
					
				}
			}
						
		}
		catch(ClassNotFoundException e)
		{
			System.out.println(e);
		}
		catch(SQLException e)
		{
			System.out.println(e);
		}
		
	}
}
