package srp;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(
		urlPatterns = { "/login" }, 
		initParams = { 
				@WebInitParam(name = "dClass", value = "com.mysql.cj.jdbc.Driver"), 
				@WebInitParam(name = "url", value = "jdbc:mysql://localhost:3306/prodapt"), 
				@WebInitParam(name = "userName", value = "root"), 
				@WebInitParam(name = "password", value = "root")
		})
public class StudentLoginService extends HttpServlet {
	private static final long serialVersionUID = 1L;
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
			String email = request.getParameter("email");
			String pwd = request.getParameter("pwd");
			PreparedStatement ps = con.prepareStatement("select email_id,password from students_registration where email_id=?");
			ps.setString(1,email);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			if(pwd.equals(rs.getString(2)) && email.equals(rs.getString(1))) 
            {
				request.setAttribute("name",request.getParameter("email") );
            	RequestDispatcher rd = request.getRequestDispatcher("/home");
            	rd.forward(request, response);
            }
            else 
            {
            	RequestDispatcher rd = request.getRequestDispatcher("Login.html");
            	rd.forward(request, response);
            }
			RequestDispatcher rd = request.getRequestDispatcher("Login.html");
	    	rd.forward(request, response);
           }
		
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}