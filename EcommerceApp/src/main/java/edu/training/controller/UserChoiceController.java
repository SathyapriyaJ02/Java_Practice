package edu.training.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.training.model.Product;
import edu.training.model.Register;
import edu.training.service.ProductService;


@WebServlet("/UserChoiceController")
public class UserChoiceController extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String useropr = request.getParameter("UserOpr");
		ProductService ps = new ProductService(); 
		HttpSession session = request.getSession();
		
		if(useropr!= null && useropr.equals("viewProduct"))
		{
			try {
			List<Product> list;
			list = ps.viewProduct();
			request.setAttribute("view",list);
			RequestDispatcher rd = request.getRequestDispatcher("UserViewProduct.jsp");
			rd.forward(request, response);
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		}
//		if(useropr.equals("search"))
//		{
//			try{
//				String keyword = request.getParameter("searchKeyword");
//				List<Product> list = ps.searchProduct(keyword); 
//				System.out.println(list);
//				request.setAttribute("search",list);
//				RequestDispatcher rd = request.getRequestDispatcher("searchProduct.jsp");
//				rd.forward(request, response);
//			}
//			catch(Exception e)
//			{
//				System.out.println(e);
//			}
//		}
		if(useropr.equals("logout"))
		{
			session.invalidate();
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		}
	}

}
