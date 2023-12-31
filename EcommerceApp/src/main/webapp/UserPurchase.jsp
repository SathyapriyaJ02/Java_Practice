<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <header>

        

    </header>
   
    <h1>Purchase List</h1>

	<center>
    <table cellpadding="15">

        <tr>

            <th>Product ID</th>

            <th>Product Name</th>

            <th>Product Description</th>

            <th>Product Price</th>

            <th>Action</th>

        </tr>

        <c:forEach var="p" items="${cart}">

            <tr>

                <td><c:out value="${p.product_id}"/></td>

                <td><c:out value="${p.product_name}"/></td>

                <td><c:out value="${p.product_description}"/></td>

                <td><c:out value="${p.product_price}"/></td>

                

                <td>

                   <a href="buy.jsp" class="button">Pay</a>

                </td>

            </tr>

        </c:forEach>

    </table>
    </center>
    

</body>
</html>