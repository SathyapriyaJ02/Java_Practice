package ser;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/servlet1")
public class Servlet1 extends HttpServlet
{
public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
{
	//request.setAttribute("name", request.getParameter("fname"));
	//HttpSession sess = request.getSession();
	//sess.setAttribute("name", request.getParameter("fname"));
	//RequestDispatcher rd = request.getRequestDispatcher("New2.html");
	//rd.forward(request, response);
	
	
	//urlRedirect
//	String str = request.getParameter("fname");
//	response.sendRedirect("Servlet2?fname="+str);
	
	Cookie c1=new Cookie("name",request.getParameter("fname"));
	response.addCookie(c1);
	response.sendRedirect("Servlet2");
}

}
