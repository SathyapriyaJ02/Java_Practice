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
import javax.servlet.http.HttpSession;

import edu.training.model.Cart;
import edu.training.service.CartService;
import edu.training.service.ProductService;

/**
 * Servlet implementation class UserAddToCartController
 */
@WebServlet("/UserAddToCartController")
public class UserAddToCartController extends HttpServlet {
	CartService cs = new CartService ();
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String userOpr = request.getParameter("userOpr");
		if(userOpr.equals("AddToCart"))
		{
		int pid = Integer.parseInt(request.getParameter("productId"));
		String pname = request.getParameter("productname");
		String pdes = request.getParameter("productdes");
		int price = Integer.parseInt(request.getParameter("productprice")); 
		int pquantity = Integer.parseInt(request.getParameter("productQ"));
		
		HttpSession session = request.getSession();
		String userEmail = (String) session.getAttribute("userName");
		System.out.println("User name "+userEmail);
		System.out.println("ProductId "+pid);
		Cart c = new Cart(pid,pname,pdes,price);
		try {
			
			int existingQ = cs.getExistingQ(userEmail, pid);
			System.out.println(existingQ);
			
			
		
			if(existingQ>0) 
			{
				int updateQuantity = existingQ+1;
				System.out.println(updateQuantity);
				cs.updateCartQuantity(userEmail, pid, updateQuantity);
			}
			else
			{	
			cs.addToCart(c,userEmail,1);
			response.getWriter().println("Added");
			RequestDispatcher rd = request.getRequestDispatcher("mycart.jsp");
			rd.forward(request, response);
			}
		}
		
		catch(Exception e)
		{
			System.out.println(e);
		}
		}
		if(userOpr.equals("SearchCart"))
		{
		int pid = Integer.parseInt(request.getParameter("productId"));
		String pname = request.getParameter("productname");
		String pdes = request.getParameter("productdes");
		int price = Integer.parseInt(request.getParameter("productprice")); 
		int pquantity = Integer.parseInt(request.getParameter("productQ"));
		
		HttpSession session = request.getSession();
		String userEmail = (String) session.getAttribute("userName");
		System.out.println("User name "+userEmail);
		System.out.println("ProductId "+pid);
		Cart c = new Cart(pid,pname,pdes,price);
		try {
			
			int existingQ = cs.getExistingQ(userEmail, pid);
			System.out.println(existingQ);
			
			
		
			if(existingQ>0) 
			{
				int updateQuantity = existingQ+1;
				System.out.println(updateQuantity);
				cs.updateCartQuantity(userEmail, pid, updateQuantity);
			}
			else
			{	
			cs.addToCart(c,userEmail,1);
			response.getWriter().println("Added");
			RequestDispatcher rd = request.getRequestDispatcher("MyWishList.jsp");
			rd.include(request,response);
			}
		}
		
		catch(Exception e)
		{
			System.out.println(e);
		}
		}
		if(userOpr.equals("viewCart"))
		{
			HttpSession session = request.getSession();
			String userEmail = (String) session.getAttribute("userName");
			List<Cart> c = new ArrayList();
			try {
				c=cs.viewCart(userEmail);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}			request.setAttribute("obj",c);
			   RequestDispatcher rd = request.getRequestDispatcher("mycart.jsp");			rd.forward(request, response);
		
		}
		
		if(userOpr.equals("Remove"))
		{
			int pid = Integer.parseInt(request.getParameter("productId"));
			HttpSession session = request.getSession();
			String userEmail = (String) session.getAttribute("userName");
			try
			{
				cs.removeFromCart(userEmail,pid);
				response.sendRedirect("mycart.jsp");
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		}
		
		
	}
}
