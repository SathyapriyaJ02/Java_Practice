package edu.training.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.training.model.Product;
import edu.training.service.ProductService;
import edu.training.service.UserService;

@WebServlet("/UserWishListController")
public class UserWishListController extends HttpServlet {
	
	UserService us = new UserService();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String Opr = request.getParameter("userOpr");
		if(Opr.equals("Wishlist")) {
		
		String productId = request.getParameter("productId");
		int pid = Integer.parseInt(productId);
		try 
		{
			HttpSession session = request.getSession();
			List<Product> wishList = (List<Product>) session.getAttribute("wishList");
			if(wishList == null)
			{
				wishList=new ArrayList<>();
			}
			boolean isProductInWishlist=false;
			for(Product productInWishlist : wishList)
			{
				if(productInWishlist.getProduct_id() == pid)
				{
					isProductInWishlist=true;
					response.setContentType("text/html");
					response.getWriter().println("Already added");
					//RequestDispatcher rd = request.getRequestDispatcher("UserChoiceController?UserOpr=viewProduct");
					//rd.include(request, response);
					break;
				}
			}
			if(!isProductInWishlist)
			{
				Product p = us.getProductByID(pid);
				System.out.println(p.getProduct_id());
				wishList.add(p);
			}
			
			
			session.setAttribute("wishList",wishList);
			response.sendRedirect("UserChoiceController?UserOpr=viewProduct");
		} 
		
		
		
		catch (Exception e) 
		{
			System.out.println(e);
		}
		}
		if(Opr.equals("remove"))
		{
			
			HttpSession session = request.getSession();
			String removeProductId = request.getParameter("productId");
			int pid = Integer.parseInt(removeProductId);
			us.removeProduct(session,pid);
			//response.getWriter().println("removed");
			response.sendRedirect("MyWishList.jsp");
			
		}
		if(Opr.equals("search"))
		{
			RequestDispatcher rd = request.getRequestDispatcher("searchProduct.jsp");
			rd.forward(request, response);
		}
	}

}
