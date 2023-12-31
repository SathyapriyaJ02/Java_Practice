package edu.training.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.filters.CsrfPreventionFilter;

import edu.training.model.Cart;
import edu.training.model.Product;
import edu.training.service.CartService;
import edu.training.service.ProductService;
import edu.training.service.UserService;


@WebServlet("/BuyController")
public class BuyController extends HttpServlet {
	UserService us = new UserService();
	ProductService ps = new ProductService();
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String userOpr = request.getParameter("userOpr");
		if(userOpr.equals("cart"))
		{
		try {
		//int count = Integer.parseInt(request.getParameter("productQ"));
		int productId = Integer.parseInt(request.getParameter("productId"));
		int productQuantity = us.getProductQuantity(productId);
		String userName=request.getParameter("userName");
		
		
		if(productQuantity>0)
		{ 
			CartService cs = new CartService();
			productQuantity = productQuantity-1;
			ps.countQuantity(productId,productQuantity);
			List<Cart> c = new ArrayList<>();
			c = cs.buycart(productId,userName);
			
			request.setAttribute("cart", c);
			
			RequestDispatcher rd = request.getRequestDispatcher("CartPurchase.jsp");
			rd.forward(request, response);
			
		}
		else
		{
			response.setContentType("text/html");
			response.getWriter().println("out of stock");
			RequestDispatcher rd = request.getRequestDispatcher("UserViewProduct.jsp");
			rd.include(request, response);
			
		}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	}
		else
		{
			try 
			{
				int productId = Integer.parseInt(request.getParameter("productId"));
				int productQuantity = us.getProductQuantity(productId);
				if(productQuantity>0)
				{ 
					CartService cs = new CartService();
					productQuantity = productQuantity-1;
					ps.countQuantity(productId,productQuantity);
					List<Product> p = new ArrayList<>();
					p = cs.userviewcart(productId);
					request.setAttribute("cart", p);
					
					RequestDispatcher rd = request.getRequestDispatcher("UserPurchase.jsp");
					rd.forward(request, response);
					

				}
				
			} 
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}	
	
	

}
