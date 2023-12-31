<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>

    <meta charset="ISO-8859-1">

    <title>User Purchase</title>

</head>

<body>

   <header>

        

    </header>
    <h1>Purchase List</h1>

    <table>

        <tr>

            <th>Product ID</th>

            <th>Product Name</th>

            <th>Product Description</th>

            <th>Product Price</th>

            <th>Product Quantity</th>

            <th>Action</th>

        </tr>

        <c:forEach var="c" items="${cart}">

            <tr>

                <td><c:out value="${c.product_id}"/></td>

                <td><c:out value="${c.product_name}"/></td>

                <td><c:out value="${c.product_desc}"/></td>

                <td><c:out value="${c.product_price}"/></td>

                <td><c:out value="${c.quantity}"/></td>

                <td>

                   <input type="submit" name="" value="pay">

                </td>

            </tr>

        </c:forEach>

    </table>


</body>

</html>

