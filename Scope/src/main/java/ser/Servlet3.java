package ser;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Servlet3")
public class Servlet3  extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String n = ""+request.getAttribute("name");
		//RequestDispatcher rd = request.getRequestDispatcher("/Servlet3");
		//rd.forward(request, response);
		response.getWriter().println(n);
		
	}

}

