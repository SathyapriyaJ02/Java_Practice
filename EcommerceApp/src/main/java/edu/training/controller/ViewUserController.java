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
import edu.training.model.Register;
import edu.training.service.RegisterService;

@WebServlet("/ViewUserController")
public class ViewUserController extends HttpServlet {
	
	RegisterService rs = new RegisterService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		try 
		{
			
			List<Register> list = rs.viewUser();
			request.setAttribute("users",list);
			RequestDispatcher rd = request.getRequestDispatcher("ViewUsers.jsp");
			rd.forward(request, response);
		} 
		catch (Exception e) 
		{
			System.out.println(e);
		}
	}
	
}	