package ems;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterService extends HttpServlet
{
	Connection con = null;
	public void init()
	{
		ServletContext context = getServletContext();
		String driverClass = context.getInitParameter("dClass");
		String url = context.getInitParameter("url");
		String userName = context.getInitParameter("userName");
		String password = context.getInitParameter("password");
		try
		{
			Class.forName(driverClass);
			con=DriverManager.getConnection(url,userName,password);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException
	{
		try 
		{
			//Class.forName("com.mysql.cj.jdbc.Driver");
			//Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/prodapt","root","root");
			PreparedStatement ps = con.prepareStatement("insert into employees values(?,?,?,?,?)");
			ps.setString(1, req.getParameter("fname"));
			ps.setString(2, req.getParameter("lname"));
			ps.setString(3, req.getParameter("email"));
			ps.setString(4, req.getParameter("mobile"));
			ps.setString(5, req.getParameter("pwd"));
			ps.executeUpdate();
			res.getWriter().println("<h1>This employee registered successfully<h1>");
			RequestDispatcher rd = req.getRequestDispatcher("login.html");
        	rd.forward(req, res);
		} 
		catch (Exception e) 
		{
			System.out.println(e);
		} 
	}

}
