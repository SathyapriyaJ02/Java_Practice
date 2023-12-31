package edu.training.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.training.model.Product;
import edu.training.service.ProductService;

/**
 * Servlet implementation class DeleteProductController
 */
@WebServlet("/DeleteProductController")
public class DeleteProductController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String i = request.getParameter("product_id");
		int id = Integer.parseInt(i);
		
		//Product p = (Product)request.getAttribute("obj");
		ProductService ps = new ProductService ();
		boolean deleted = ps.deleteProduct(id);
		if(deleted)
		{
			response.getWriter().println("Deleted");
		}
		else
		{
			response.getWriter().println("Not Deleted");
		}
	}

}
