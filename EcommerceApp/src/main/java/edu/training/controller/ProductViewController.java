package edu.training.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.training.model.Product;
import edu.training.service.ProductService;

@WebServlet("/ProductViewController")
public class ProductViewController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		ProductService ps = new ProductService ();
		try 
		{
			List<Product> list = ps.viewProduct();
			request.setAttribute("view",list);
			RequestDispatcher rd = request.getRequestDispatcher("viewProduct.jsp");
			rd.forward(request, response);
		} 
		catch (Exception e) 
		{
			System.out.println(e);
		}
		
	}

}
