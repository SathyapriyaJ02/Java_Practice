package edu.training.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.training.model.Register;
import edu.training.service.RegisterService;

@WebServlet("/UserRegisterController")
public class UserRegisterController extends HttpServlet 
{
	
    
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		Register r = (Register) request.getAttribute("obj");
		RegisterService rs = new RegisterService();
		String approvalStatus = "pending";
		rs.addUser(r,approvalStatus);
		response.getWriter().println("Added Successfully");
		
	}

	
	
}
