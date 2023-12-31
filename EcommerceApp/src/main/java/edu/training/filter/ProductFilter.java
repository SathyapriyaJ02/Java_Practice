package edu.training.filter;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;

import edu.training.model.Dao;
import edu.training.model.Product;

@WebFilter("/ProductAddController")
public class ProductFilter extends HttpFilter implements Filter 
{
       
    public void destroy() 
    {
    	
	}
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException
	{
		String i = request.getParameter("product_id");
		int id = Integer.parseInt(i);
		String name = request.getParameter("product_name");
		String desc = request.getParameter("product_description");
		String price = request.getParameter("product_price");
		String quan = request.getParameter("product_quantity");
		int quantity = Integer.parseInt(quan);
		
		if((name.length()>3) && (price != "0"))
		{
			Product p = new Product(id,name,desc,price,quantity);
			request.setAttribute("obj", p);
			chain.doFilter(request, response);
		}
		else
		{
			response.setContentType("text/html");
			response.getWriter().println("Enter valid details");
			RequestDispatcher rd = request.getRequestDispatcher("addProduct.jsp");
			rd.include(request, response);
		}
		
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
