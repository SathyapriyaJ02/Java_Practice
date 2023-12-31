package edu.training.model;

import java.sql.Connection;
import java.sql.DriverManager;

public class Dao 
{
	Connection con;
	public Connection getConnection()
	{
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/prodapt","root","hr");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return con;
	}
	

}
