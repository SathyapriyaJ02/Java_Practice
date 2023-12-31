package edu.training.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/adminChoiceController")
public class AdminChoiceController extends HttpServlet {
	
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String adminopr = request.getParameter("AdminOpr");
		
		
		if(adminopr!= null && adminopr.equals("View Users"))
		{
			RequestDispatcher rd = request.getRequestDispatcher("ViewUserController");
			rd.forward(request, response);
		}
		
		else if(adminopr!= null && adminopr.equals("Add Product"))
		{
			RequestDispatcher rd = request.getRequestDispatcher("addProduct.jsp");
			rd.forward(request, response);
			//response.getWriter().println("Add");
		}
		else
		{
			RequestDispatcher rd = request.getRequestDispatcher("ProductViewController");
			rd.forward(request, response);
			//response.getWriter().println("View");
		}
		
	}

	
}
