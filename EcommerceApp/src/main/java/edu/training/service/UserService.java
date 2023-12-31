package edu.training.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import edu.training.model.Cart;
import edu.training.model.Dao;
import edu.training.model.Product;

public class UserService 
{
	static Dao d = new Dao();
	 
	static PreparedStatement ps;
	public int getProductQuantity(int id) throws SQLException
	{
		Connection con = d.getConnection();
		ps = con.prepareStatement("select product_quantity from product where product_id=?");
		ps.setInt(1,id);
		ResultSet rs = ps.executeQuery();
		int quantity = 0;
		if(rs.next())
		{
			quantity = rs.getInt("product_quantity");
			System.out.println(quantity);
		}
		return quantity;
		
	}
	public Cart getProductDetailsByID(int id,String userName) throws SQLException
	{
		Connection con = d.getConnection();
		Cart c = null;
		ps = con.prepareStatement("select * from cart where product_id=? and user_name=?");
		ps.setInt(1,id);
		ps.setString(2, userName);
		ResultSet rs = ps.executeQuery();
		if(rs.next())
		{
			c = new Cart(rs.getString(1),rs.getInt(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getInt(6));
		}
		return c;
		
	}
	public void removeProduct(HttpSession session, int pid)
	{
		List<Product> wishList = (List<Product>) session.getAttribute("wishList");
		if(wishList != null)
		{
			for(Product productInWishlist : wishList)
			{
				if(productInWishlist.getProduct_id() == pid)
				{ 
					wishList.remove(productInWishlist);
					break;
				}
			}
			session.setAttribute("wishList", wishList);
		}
	}
	public Product getProductByID(int pid) throws SQLException
	{
		Connection con = d.getConnection();
		Product p = null;
		ps = con.prepareStatement("select * from product where product_id=?");
		ps.setInt(1, pid);
		ResultSet rs = ps.executeQuery();
		while(rs.next())
		{
			p = new Product(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(4));
		}
		return p;
	}
	
}
