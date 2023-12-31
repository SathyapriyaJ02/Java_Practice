package filter;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyFilter extends HttpFilter
{
	Connection con = null;
	public void init()
	{
		
		ServletContext cont = getServletContext();
		String driverClass = cont.getInitParameter("dClass");
		String url = cont.getInitParameter("url");
		String userName = cont.getInitParameter("userName");
		String password = cont.getInitParameter("password");
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
	public void doFilter(HttpServletRequest request, HttpServletResponse response,FilterChain chain) throws IOException, ServletException
	{
		String name = request.getParameter("userName");
		String pass = request.getParameter("pwd");
		PreparedStatement ps;
		try 
		{
			ps = con.prepareStatement("select first_name,password from employees where first_name=?");
			ps.setString(1,name);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) 
			{

	            if(pass.equals(rs.getString(2)) && name.equals(rs.getString(1))) 
	            {
	            	
	            	 request.setAttribute("name", name);
	            	 chain.doFilter(request, response);
	            	
	            }
	            else 
	            {
	            	response.setContentType("text/html");
	            	response.getWriter().write("Invalid");
	            	RequestDispatcher rd = request.getRequestDispatcher("login.html");
	            	rd.include(request, response);     
	            }
	            
	          } 
			//RequestDispatcher rd = request.getRequestDispatcher("login.html");
        	//rd.forward(request, response);    
		} 
		catch (SQLException e) {
			System.out.println(e);
		}
		
	}
	@Override
	public void destroy() {
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
