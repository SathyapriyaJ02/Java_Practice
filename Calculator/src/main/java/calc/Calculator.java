package calc;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Calculator extends HttpServlet
{
	public void process(HttpServletRequest req,HttpServletResponse res)throws IOException
	{
		String num1 = req.getParameter("n1");
		String num2 = req.getParameter("n2");
		int n1 = Integer.parseInt(num1);
		int n2 = Integer.parseInt(num2);
		String operator = req.getParameter("op");
		PrintWriter out = res.getWriter();
		String result = null;
		switch (operator)
		{
			case "Addition":
				result = "The sum is "+(n1+n2);
				break;
			case "Subtraction":
				result="The difference is "+(n1-n2);
				break;
			case "Multiplication":
				result = "The product is "+(n1*n2); 
				break;
			case "Division":
				result="The division is "+(n1/n2);
				break;
		}
		/*
		 * out.println("<!DOCTYPE html>\r\n" + "<html>\r\n" + "<head>\r\n" +
		 * "<meta charset=\"ISO-8859-1\">\r\n" + "<title>Insert title here</title>\r\n"
		 * + "</head>\r\n" + "<body>\r\n" + "<h1>Calculator</h1>\r\n" +
		 * "<form action=\"./myCal\" method=\"get\">\r\n" +
		 * "	<label>Number 1</label>\r\n" +
		 * "	<input type=\"text\" name=\"n1\" value=\"\" placeholder=\"Enter number 1\">\r\n"
		 * + "	<label>Number 2</label>\r\n" +
		 * "	<input type=\"text\" name=\"n2\" value=\"\" placeholder=\"Enter number 2\"><br>\r\n"
		 * +
		 * "	<input type=\"radio\" name=\"op\"  value=\"Addition\">Addition</label><br>\r\n"
		 * +
		 * "	<input type=\"radio\" name=\"op\"  value=\"Subtraction\">Subtraction</label><br>\r\n"
		 * +
		 * "	<input type=\"radio\" name=\"op\"  value=\"Multiplication\">Multiplication</label><br>\r\n"
		 * +
		 * "	<input type=\"radio\" name=\"op\"  value=\"Division\">Division</label><br>\r\n"
		 * + "	<input type=\"submit\" name=\"Calculate\">\r\n" +
		 * "    <input type=\"reset\" name=\"reset\">\r\n" + "</form>\r\n"+result +
		 * "</body>\r\n" + "</html>");
		 */
		out.println("<!DOCTYPE html>\r\n"
				+ "<html>\r\n"
				+ "<head>\r\n"
				+ "<meta charset=\"ISO-8859-1\">\r\n"
				+ "<title>Insert title here</title>\r\n"
				+ "</head>\r\n"
				+ "<body>\r\n"
				+ "<center><h1>Calculator</h1></center>\r\n"
				+ "<form action=\"./myCal\" method=\"get\">\r\n"
				+ "	<center>\r\n"
				+ "	<label>Number 1</label>\r\n"
				+ "	<input type=\"text\" name=\"n1\" value=\"\" placeholder=\"Enter number 1\">\r\n"
				+ "	<br>\r\n"
				+ "	<br>\r\n"
				+ "	<label>Number 2</label>\r\n"
				+ "	<input type=\"text\" name=\"n2\" value=\"\" placeholder=\"Enter number 2\"><br><br>\r\n"
				+ "	<input type=\"radio\" name=\"op\"  value=\"Addition\">   Addition</label>\r\n"
				+ "	<input type=\"radio\" name=\"op\"  value=\"Subtraction\">   Subtraction</label>\r\n"
				+ "	<input type=\"radio\" name=\"op\"  value=\"Multiplication\">Multiplication</label>\r\n"
				+ "	<input type=\"radio\" name=\"op\"  value=\"Division\">Division</label><br><br>\r\n"
				+result+"<br><br><input type=\"submit\" name=\"Calculate\">\r\n"
				+ "    <input type=\"reset\" name=\"reset\">\r\n"
				+ "    </center>\r\n"
				+ "</form>\r\n"
				+ "</body>\r\n"
				+ "</html>");
	}
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException
	{
		process(req,res);
	}
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException
	{
		process(req,res);
	}
	
}
