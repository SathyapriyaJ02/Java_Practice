package edu.training.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.training.model.Dao;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	
	static Dao d = new Dao();
	static PreparedStatement ps;
	Connection con = d.getConnection();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
			
			
		String userName = request.getParameter("userName");
		String pwd = request.getParameter("pwd");
			
				if(isAdmin(userName,pwd))
				{
					RequestDispatcher rd = request.getRequestDispatcher("adminpage.jsp");
					rd.forward(request, response);
				}			
				else if(isUser(userName,pwd))
				{
					request.getSession().setAttribute("userName",userName);
					RequestDispatcher rd = request.getRequestDispatcher("UserHomePage.jsp");
					rd.forward(request, response);
				}
				else
				{
					response.setContentType("text/html");
					response.getWriter().println("username or password invalid");
					RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
					rd.include(request, response);
				}	
					
		}
		public boolean isAdmin(String userName,String password)
		{
			return "Admin".equals(userName) && "123".equals(password);
		}
		public boolean isUser(String userName,String password)
		{
				
			try
				{
					PreparedStatement ps = con.prepareStatement("select email,password,approval_status from userregisteration where email=?");
					ps.setString(1,userName);
					ResultSet rs = ps.executeQuery();
					while(rs.next()) 
					{
						String status = rs.getString("approval_status");
						if (password.equals(rs.getString(2)) && userName.equals(rs.getString(1)) && status.equals("approve"))
						{
							return true;
						}
					}	
				}
				catch(Exception e)
				{
					System.out.println(e);
				}
				return false;
			}
	
	

		
}


