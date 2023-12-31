package edu.training.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.training.service.RegisterService;


@WebServlet("/ApproveUserController")
public class ApproveUserController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		RegisterService rs = new RegisterService();
	    try {

	        String userEmail = request.getParameter("userEmail");

	        String action = request.getParameter("action");
	        
	        //System.out.println(userEmail);
	        //System.out.println(action);

	 

	        if (action != null) {

	            if (action.equals("approve")) {

	                // Update approval_status to "approve" for the given userEmail

	                rs.approvalStatus(userEmail, "approve");

	            } else if (action.equals("deny")) {

	                // Update approval_status to "deny" for the given userEmail

	                rs.approvalStatus(userEmail, "deny");

	            }

	        }

	 

	        response.sendRedirect(request.getContextPath() + "/ViewUserController");

	    } catch (Exception e) {

	        e.printStackTrace();

	        // Handle exceptions as needed

	    }

	}

	

}
