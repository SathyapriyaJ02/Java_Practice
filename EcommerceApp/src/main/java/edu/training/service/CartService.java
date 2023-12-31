package edu.training.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.training.model.Cart;
import edu.training.model.Dao;
import edu.training.model.Product;

public class CartService 
{
	static Dao d = new Dao();
	static PreparedStatement ps;
	Connection con = d.getConnection();
	
	public void addToCart(Cart cart,String userName,int quantity) throws SQLException
	{
		int existingQ = getExistingQ(userName,cart.getProduct_id());
		if(existingQ>0)
		{
			quantity += existingQ;
			updateCartQuantity(userName,cart.getProduct_id(),quantity);
		}
		else
		{
			quantity = 1;
			PreparedStatement ps = con.prepareStatement("Insert into cart (User_Name, Product_Id, Product_Name, Product_Des, Product_Price, Quantity) values(?,?,?,?,?,?)");	
			ps.setString(1,userName);
			ps.setInt(2, cart.getProduct_id());
			ps.setString(3, cart.getProduct_name());
			ps.setString(4, cart.getProduct_desc());
			ps.setInt(5,cart.getProduct_price());
			ps.setInt(6,quantity);
			ps.executeUpdate();
		}
	}
	public List<Cart> viewCart(String userName) throws SQLException
	{
		List<Cart> viewCart = new ArrayList();
		PreparedStatement ps = con.prepareStatement("Select * from cart where user_name=?");
		ps.setString(1, userName);
		ResultSet rs = ps.executeQuery();
		while(rs.next())
		{
			viewCart.add(new Cart(rs.getString(1),rs.getInt(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getInt(6)));
		}
		return viewCart;
	}
	
	public int getExistingQ(String userEmail,int pid) throws SQLException
	{
		PreparedStatement ps = con.prepareStatement("Select quantity from cart where user_name=? AND Product_Id=?");
		ps.setString(1, userEmail);
		ps.setInt(2, pid);
		ResultSet rs = ps.executeQuery();
		int quantity=0;
		while(rs.next())
		{
			quantity = rs.getInt("quantity");
		}
		return quantity;
	}
	
	public void updateCartQuantity(String userName,int productId,int quantity) throws SQLException
	{
		int currentPrice=0;
		PreparedStatement statement = con.prepareStatement("Select product_price from cart where user_name=? AND product_id=?");
		statement.setString(1,userName);
		statement.setInt(2,productId);
		ResultSet rs = statement.executeQuery();
		if(rs.next()) {
			currentPrice = rs.getInt("product_price");
		}
		int TotalPrice = currentPrice*quantity;
		PreparedStatement ps = con.prepareStatement("UPDATE cart SET quantity=?, product_price=? where user_name=? AND product_id=? ");
		ps.setInt(1, quantity);
		ps.setInt(2, TotalPrice);
		ps.setString(3, userName);
		ps.setInt(4,productId);
		ps.executeUpdate();
	}
	public void removeFromCart(String userName,int pid) throws SQLException
	{
//		int existingQ= getExistingQ(userName,pid);
//		if(existingQ>1)
//		{
//			int quantity=0;
//			updateCartQuantity(userName,pid,existingQ-1);
//			PreparedStatement s = con.prepareStatement("select quantity from cart where product_id=? AND user_name=?");
//			ps.setString(1, userName);
//			ps.setInt(2,pid);
//			ResultSet rs = ps.executeQuery();
//			while(rs.next())
//			{
//				quantity=rs.getInt("quantity");
//			}
//			int currentPrice = getProductPrice(userName,pid);
//			int totalPrice = currentPrice-(currentPrice/(quantity));
//			PreparedStatement ps = con.prepareStatement("UPDATE cart SET product_price=? where user_name=? AND product_id=? ");
//			ps.setInt(1, totalPrice);
//			ps.setString(2, userName);
//			ps.setInt(3, pid);
//		}
		
		PreparedStatement ps = con.prepareStatement("DELETE from cart where user_name=? AND product_id=?");
		ps.setString(1, userName);
		ps.setInt(2, pid);
		ps.executeUpdate();
		
	}
	public int getProductPrice(String userName,int pid) throws SQLException
	{
		int currentPrice = 0;
		PreparedStatement statement = con.prepareStatement("Select product_price from cart where user_name=? AND product_id=?");
		statement.setString(1,userName);
		statement.setInt(2,pid);
		ResultSet rs = statement.executeQuery();
		if(rs.next()) 
		{
			currentPrice = rs.getInt("product_price");
		}
		return currentPrice;
		
	}
	public List<Cart> buycart(int productId,String userName) throws SQLException
	{
		List<Cart> c = new ArrayList<>();
		PreparedStatement ps = con.prepareStatement("select * from cart where product_id=? and user_name=?");
		ps.setInt(1, productId);
		ps.setString(2, userName);
		ResultSet rs = ps.executeQuery();
		if(rs.next())
		{
			c.add(new Cart(rs.getString(1),rs.getInt(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getInt(6)));
		}
		return c;
	}
	public List<Product> userviewcart(int pid) throws SQLException
	{
		List<Product> p = new ArrayList<>();
		PreparedStatement ps = con.prepareStatement("select * from product where product_id=?");
		ps.setInt(1, pid);
		ResultSet rs = ps.executeQuery();
		if(rs.next())
		{
			p.add(new Product(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5)));
		}
		return p;
	}
	
}
