<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <jsp:include page="UserHomePage.jsp" />
 <center>
 <table>

        <tr>

            <th>Product ID</th>

            <th>Product Name</th>

            <th>Product Description</th>

            <th>Product Price</th>
            
            <th>Quantity</th>
            
           

            <th>Action</th><br>

        </tr>

        <c:forEach var="c" items="${obj}">

            <tr>
				
				
                <td><c:out value="${c.product_id}"/></td>

                <td><c:out value="${c.product_name}"/></td>

                <td><c:out value="${c.product_desc}"/></td>

                <td><c:out value="${c.product_price}"/></td>
                
                <td><c:out value="${c.quantity}"/></td>
                
                
               
                    

                <td>

                    <a href="./UserAddToCartController?userOpr=Remove&productId=${c.product_id}" class="button">Remove</a>
                    <a href="./BuyController?userOpr=userView&productId=${c.product_id}&userName=${c.userName}" class="button">Buy</a>
                </td>

            </tr>

        </c:forEach>    
	</center>
    </table>

</body>
</html>




 