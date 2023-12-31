package ems;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginService extends HttpServlet
{
	Connection con =null;
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
			con = DriverManager.getConnection(url,userName,password);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException
	{
		try 
		{
			String name = req.getParameter("userName");
			String pwd = req.getParameter("pwd");
			PreparedStatement ps = con.prepareStatement("select first_name,password ,approval_status from employees where first_name=?");
			ps.setString(1,name);
			ps.setString(2, pwd);
			
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) 
			{

                if(pwd.equals(rs.getString(2)) && name.equals(rs.getString(1))) 
                {

                	RequestDispatcher rd = req.getRequestDispatcher("home.html");
                	rd.forward(req, res);
                }
                else 
                {
                	RequestDispatcher rd = req.getRequestDispatcher("login.html");
                	rd.forward(req, res);
                }
              }  
			RequestDispatcher rd = req.getRequestDispatcher("login.html");
        	rd.forward(req, res);
			
		} 
		catch (SQLException e) 
		{
			System.out.println(e);
		}
	}
}
