package ser;

import java.io.IOException;
import javax.servlet.http.Cookie;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Servlet2")
public class Servlet2  extends HttpServlet {
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		//String n = ""+request.getAttribute("name");
		//HttpSession sess = request.getSession();
		//String n = ""+sess.getAttribute("name");
		//RequestDispatcher rd = request.getRequestDispatcher("/Servlet3");
		//rd.forward(request, response);
		//response.getWriter().println(n);
		
		
		//urlRedirect
//		String str = request.getParameter("fname");
//		PrintWriter out = response.getWriter();
//		out.println("Hi "+str);
		
		Cookie[] c2=request.getCookies();
		for(Cookie c:c2) {
			if(c.getValue().equals("sudha")) {
			response.getWriter().println(c.getName());
			response.getWriter().println(c.getValue());
		}
			else {
				response.getWriter().println("no");
			}
				
			}
	}

}
