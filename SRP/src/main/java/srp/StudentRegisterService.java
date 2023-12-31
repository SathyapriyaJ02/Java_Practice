package srp;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
		urlPatterns = { "/reg" }, 
		initParams = { 
				@WebInitParam(name = "dClass", value = "com.mysql.cj.jdbc.Driver"), 
				@WebInitParam(name = "url", value = "jdbc:mysql://localhost:3306/prodapt"), 
				@WebInitParam(name = "userName", value = "root"), 
				@WebInitParam(name = "password", value = "root")
		})
public class StudentRegisterService extends HttpServlet 
{
	Connection con;
	public void init(ServletConfig sc)
	{
		
		String driverClass =(String)sc.getInitParameter("dClass");
		String url = (String)sc.getInitParameter("url");
		String userName = (String)sc.getInitParameter("userName");
		String password =(String)sc.getInitParameter("password");
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
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		try
		{
		PreparedStatement ps = con.prepareStatement("insert into students_registration values(?,?,?,?,?,?)");
		ps.setString(1, request.getParameter("fname"));
		ps.setString(2, request.getParameter("lname"));
		ps.setString(3, request.getParameter("dept"));
		ps.setString(4, request.getParameter("email"));
		ps.setString(5, request.getParameter("mobile"));
		ps.setString(6, request.getParameter("pwd"));
		ps.executeUpdate();
		//response.getWriter().println("<h1>Registered Successfully<h1>");
		
		RequestDispatcher rd = request.getRequestDispatcher("Login.html");
    	rd.forward(request, response);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	}

}
