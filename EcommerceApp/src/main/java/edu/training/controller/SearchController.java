package edu.training.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.training.model.Product;
import edu.training.service.ProductService;


@WebServlet("/SearchController")
public class SearchController extends HttpServlet {
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			ProductService ps = new ProductService();
			String keyword = request.getParameter("searchKeyword");
			List<Product> list = ps.searchProduct(keyword); 
			//System.out.println(list);
			request.setAttribute("search",list);
			boolean productsFound = !list.isEmpty();
			request.setAttribute("found", productsFound);
			RequestDispatcher rd = request.getRequestDispatcher("searchProduct.jsp");
			rd.forward(request, response);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

}
