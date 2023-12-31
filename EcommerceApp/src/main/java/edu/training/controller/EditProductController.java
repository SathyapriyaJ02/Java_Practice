package edu.training.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.training.model.Product;
import edu.training.service.ProductService;

/**
 * Servlet implementation class EditProductController
 */
@WebServlet("/EditProductController")
public class EditProductController extends HttpServlet {
	

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session = request.getSession();
		int id = (int)session.getAttribute("id");
	
		//String name = request.getParameter("product_name");
		//String desc = request.getParameter("product_description");
		String price = request.getParameter("product_price");
		String quan = request.getParameter("product_quantity");
		int quantity = Integer.parseInt(quan);
		
			//request.setAttribute("id", id);
			//request.setAttribute("price",price);
			//request.setAttribute("quan",quan);
			ProductService ps = new ProductService();
			boolean temp = ps.updateProduct(id,price,quantity);
			if(temp)
			{
				//RequestDispatcher rd = request.getRequestDispatcher("EditProduct.jsp");
				//rd.forward(request,response);
				response.getWriter().println("Updated");
			}
			else
			{
				response.getWriter().println(" Not Updated");
			}
		
			
		
	}

}
