package edu.training.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;

import edu.training.model.Dao;
import edu.training.model.Product;

public class ProductService 
{
	static Dao d = new Dao();
	 
	static PreparedStatement ps;
	public void addProduct(Product p)
	{
		
		Connection con = d.getConnection();
		try
		{
			 ps = con.prepareStatement("insert into product values(?,?,?,?,?)");
			 ps.setInt(1,p.getProduct_id());
			 ps.setString(2, p.getProduct_name());
			 ps.setString(3,p.getProduct_description());
			 ps.setString(4,p.getProduct_price());
			 ps.setInt(5,p.getProduct_quantity());
			 ps.executeUpdate();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	public boolean deleteProduct(int id)
	{
		Connection con = d.getConnection();
		try
		{
			ps = con.prepareStatement("delete from product where product_id=?");
			ps.setInt(1,id);
			int temp = ps.executeUpdate();
			return temp>0;
			
		}
		catch(Exception e)
		{
			System.out.println(e);
			return false;
		}
		
	}
	
	public boolean updateProduct(int id,String price,int quantity)
	{
		Connection con = d.getConnection();
		try
		{
			ps = con.prepareStatement("update product SET product_price=?,product_quantity=? where product_id=?");
			ps.setString(1,price);
			ps.setInt(2,quantity);
			ps.setInt(3,id);
			int temp = ps.executeUpdate();
			return temp>0;
		}
		catch(Exception e)
		{
			System.out.println(e);
			return false;
		}
	}
	
	public List<Product> viewProduct() throws SQLException
	{
		Connection con = d.getConnection();
		List<Product> list = new ArrayList();
		ps = con.prepareStatement("select * from product");
		ResultSet rs = ps.executeQuery();
		while(rs.next())
		{
			list.add(new Product(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5)));
		}
		return list;
		
	}
	
	public void countQuantity(int productId,int count) throws SQLException
	{
		Connection con = d.getConnection();
		ps = con.prepareStatement("UPDATE product SET product_quantity=? where product_id=?");
		ps.setInt(1, count);
		ps.setInt(2, productId);
		ps.executeUpdate();
	}
	public List<Product> searchProduct(String keyword) throws SQLException
	{
		Connection con = d.getConnection();
		List<Product> list = new ArrayList();
		ps = con.prepareStatement("Select * from product where product_name LIKE?");
		ps.setString(1, "%" + keyword + "%");
		ResultSet rs = ps.executeQuery();
		while(rs.next())
		{
			list.add(new Product(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5)));
		}
		return list;

	}
	
}
