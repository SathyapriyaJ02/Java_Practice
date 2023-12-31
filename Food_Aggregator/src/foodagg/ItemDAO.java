package foodagg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ItemDAO
{
	PreparedStatement ps;
	//Connection con;
	ResultSet rs;
	Item item = new Item();
	Scanner sc = new Scanner(System.in);
	
	
	public void addItem(Item item) throws SQLException
	{
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/prodapt","root","root");
		ps = con.prepareStatement("insert into food(name,price,type) values(?,?,?)");
		ps.setString(1, item.getName());
		ps.setDouble(2, item.getPrice());
		ps.setString(3, item.getType());
		int update = ps.executeUpdate();
		if(update == 1)
		{
			System.out.println("Item added successfully.");
		}
		else
		{
			System.out.println("Failed to add.");
		}
		
		
	}
	public void bulkCopy(List<Item> itemList) throws SQLException
	{
		for(Item i : itemList)
		{   ItemDAO dao = new ItemDAO();
			dao.addItem(i);
		}
	}
	public List<Item> findItem(String type) throws SQLException
	{
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/prodapt","root","root");
		ps = con.prepareStatement("select * from food where type = ?");
		ps.setString(1, type);
		ResultSet rs = ps.executeQuery();
		List<Item> itemList = new ArrayList<>();
		while(rs.next())
		{
			Item item = new Item(rs.getString(1),rs.getDouble(2),rs.getNString(3));
			itemList.add(item);
		}
		return itemList;
		
	}
	public List<Item> findItem(double price) throws SQLException
	{
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/prodapt","root","root");
		ps = con.prepareStatement("select * from food where price = ?");
		ps.setDouble(1, price);
		ResultSet rs = ps.executeQuery();
		List<Item> itemList = new ArrayList<>();
		while(rs.next())
		{
			Item item = new Item(rs.getString(1),rs.getDouble(2),rs.getNString(3));
			itemList.add(item);
		}
		return itemList;
		
	}
	public void disp(List<Item> items)
	{
		for(Item i : items)
		{
			System.out.format("%-20s%-5.2f%s\n",i.getName(),i.getPrice(),i.getType());
		}
	}
	
}
