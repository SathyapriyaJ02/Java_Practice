package edu.training.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.training.model.Product;
import edu.training.service.ProductService;


@WebServlet("/ProductAddController")
public class ProductAddController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		Product p = (Product)request.getAttribute("obj");
		ProductService ps = new ProductService ();
		ps.addProduct(p);
		response.setContentType("text/html");
		response.getWriter().println("Added Successfully");
		RequestDispatcher rd = request.getRequestDispatcher("addProduct.jsp");
		rd.include(request, response);
	}
	

}
