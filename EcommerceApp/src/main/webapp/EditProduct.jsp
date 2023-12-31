<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
 <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
 <jsp:include page="CommonAdminPage.jsp" />
<form action="./EditProductController">
<%
	request.setAttribute("price", request.getParameter("product_price"));
request.setAttribute("quantity", request.getParameter("product_quantity"));
	%>
<table cellpadding=15>
<tr>
<td><label>Product ID</label></td>
<td><%session.setAttribute("id", Integer.parseInt(request.getParameter("product_id"))); 
		out.println(request.getParameter("product_id"));
		%>
</tr><tr>
<td><label>Product Name</label></td>
<td><% out.println(request.getParameter("product_name"));%></td><br>
</tr><tr>
<td><label>Product Description</label></td>
<td><% out.println(request.getParameter("product_description"));%></td><br>
</tr><tr>
<td><label>Product Price</label></td><td><input type="text" name="product_price" value="${price}"></td><br>
</tr><tr>
<td><label>Product Quantity</label></td><td><input type="text" name="product_quantity" value="${quantity}" ><td><br>
</tr>
</table>
<input type="submit" name="Edit" value="Edit Product">
<input type="reset" name="Reset"  value="Clear">

</form>
<%--<c:out value="${product_id}"></c:out> --%>
</body>
</html>