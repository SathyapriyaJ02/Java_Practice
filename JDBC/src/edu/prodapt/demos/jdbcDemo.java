package edu.prodapt.demos;
import java.util.*;
import java.sql.*;

public class jdbcDemo {

	public static void main(String[] args) {
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Loaded successfully");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/prodapt","root","root");
			//con.createStatement();	
			//Statement stmt = con.createStatement();
			
			//System.out.println("Value Inserted");
			/*ResultSet rs = stmt.executeQuery("select * from student where marks>"+86);
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3));
			}*/
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter id :");
			int id = sc.nextInt();
			System.out.println("Enter name :");
			String name = sc.next();
			System.out.println("Enter mark :");
			int mark = sc.nextInt();
			//int temp = stmt.executeUpdate("insert into student values("+id+",'"+name+"',"+mark+")");
			
			String query = "insert into student value(?,?,?,)";
			//String query =("select * from student where marks>?;");
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1,id);
			ps.setString(2,name);
			ps.setInt(3,mark);
			//int temp = ps.executeUpdate();
			System.out.println("Enter mark need to be displayed  ");
			int num = sc.nextInt();
			ps.executeQuery("select * from student where marks>"+num);
			
			
			//int num = sc.nextInt();
			//ResultSet rs =ps.executeQuery("select * from student where marks>"+num);
			/*while(.next())
			{
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3));
			}*/
			
			
			
			
			
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
