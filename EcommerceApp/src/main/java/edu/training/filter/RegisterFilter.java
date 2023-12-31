package edu.training.filter;

import java.io.IOException;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;

import edu.training.model.Product;
import edu.training.model.Register;


@WebFilter("/UserRegisterController")
public class RegisterFilter extends HttpFilter implements Filter
{
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException 
	{
		
		try 
		{
			String name = request.getParameter("name");
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			java.util.Date utilDate = df.parse(request.getParameter("dateOfBirth"));   //first parses the date as a java.util.Date, 
			java.sql.Date date = new java.sql.Date(utilDate.getTime());				  //and then converts it to a java.sql.Date using the java.sql.Date.valueOf() method.
			String phoneNumber = request.getParameter("phoneNumber");
			String address = request.getParameter("address");
			String email = request.getParameter("email");
			String pwd = request.getParameter("password");
			String error = "";
			//java.sql.Date d =java.sql.Date.valueOf("2000-01-01");

			if (name.isBlank() || name.length() <= 3) 
			{
				//response.setContentType("text/html");
				//RequestDispatcher rd = request.getRequestDispatcher("Register.jsp");
				//rd.include(request, response);
				error += "Name should be greater than three characters.<br>";
			} 
			if (date.after(df.parse("2000-01-01"))) 
			{
				//response.setContentType("text/html");
				//RequestDispatcher rd = request.getRequestDispatcher("Register.jsp");
				//rd.include(request, response);
				error += "Date of Birth must be before 2000<br>";
			} 
			if (phoneNumber.isBlank() || phoneNumber.length() != 10 || !(phoneNumber.startsWith("7")) && !(phoneNumber.startsWith("8")) && !(phoneNumber.startsWith("9"))) 
			{
				//response.setContentType("text/html");
				//RequestDispatcher rd = request.getRequestDispatcher("Register.jsp");
				//rd.include(request, response);
				error+="Enter valid phone number.<br>";
			} 
			if(address.isBlank())
			{
				//response.setContentType("text/html");
				//response.getWriter().println("Enter address.");
				//RequestDispatcher rd = request.getRequestDispatcher("Register.jsp");
				//rd.include(request, response);
				error+="Enter address.<br>";
			}
			if (email.indexOf('@')==-1 || email.indexOf('.')<=email.indexOf('@') || !isEmailValid(email) || !email.equalsIgnoreCase(email.toLowerCase())) 
			{
				//response.setContentType("text/html");
				//response.getWriter().println("Email should have '@' and followed by '.org' or '.com'.");
				//RequestDispatcher rd = request.getRequestDispatcher("Register.jsp");
				//rd.include(request, response);
				error+="Email valid Email address.<br>";
			} 
			if (pwd.isBlank() || pwd.length()>4 && isPasswordValid(pwd) ) 
			{
				//response.setContentType("text/html");
				//response.getWriter().println("Password must have alphanumeric characters and more than three characters.");
				//RequestDispatcher rd = request.getRequestDispatcher("Register.jsp");
				//rd.include(request, response);
				error +="Password must have alphanumeric characters and more than three characters.<br>";
			} 
			/*else 
			{
				Register r = new Register(name,date,phoneNumber,address,email,pwd);
				request.setAttribute("obj", r);
				chain.doFilter(request, response);
			}*/
			
			if(!error.isEmpty())
			{
				//response.setContentType("text/html");
				//response.getWriter().println(error);
				request.setAttribute("error", error);
				RequestDispatcher rd = request.getRequestDispatcher("Register.jsp");
				rd.forward(request, response);
			}
			else
			{
				Register r = new Register(name,date,phoneNumber,address,email,pwd,null);
				request.setAttribute("obj", r);
				chain.doFilter(request, response);
				
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	
	}
	
	
	
	public boolean isEmailValid(String email)
	{
		String [] domains = {".org",".com",".in"};
		String[] e = email.split("@");
		if(e.length == 2)
		{
			String domain = e[1];    //1 is index of domain part , 0 is index of username part
			for(String d : domains)
			{
				if(domain.endsWith(d))
				{
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean isPasswordValid(String pwd)
	{
		for(char c : pwd.toCharArray())
		{
			if(Character.isLetter(c)  && Character.isDigit(c))
			{
				return true;
			}
		}
		return false;
	}

}
