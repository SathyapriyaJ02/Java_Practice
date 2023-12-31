<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html>

<head>

    <meta charset="UTF-8">

    <title>Product List</title>

    <style>

        body {

            font-family: Arial, sans-serif;

            background-color: #f2f2f2;

            margin: 0;

            padding: 0;

        }

        h1 {

            text-align: center;

            margin-top: 20px;

        }

        table {

            border-collapse: collapse;

            width: 80%;

            margin: 20px auto;

            background-color: white;

        }

        th, td {

            padding: 10px;

            text-align: left;

        }

        th {

            background-color: #333;

            color: white;

        }

        tr:nth-child(even) {

            background-color: #f2f2f2;

        }

        a {

            text-decoration: none;

            padding: 5px 10px;

            background-color: #007bff;

            color: white;

            border-radius: 3px;

        }

        a:hover {

            background-color: #0056b3;

        }

    </style>

</head>

<body>

<header>

        <jsp:include page="CommonAdminPage.jsp" />

    </header>
    <h1>Product List</h1>

    <table>

        <tr>

            <th>Product ID</th>

            <th>Product Name</th>

            <th>Product Description</th>

            <th>Product Price</th>

            <th>Product Quantity</th>

            <th>Action</th>

        </tr>

        <c:forEach var="p" items="${view}">

            <tr>

                <td><c:out value="${p.product_id}"/></td>

                <td><c:out value="${p.product_name}"/></td>

                <td><c:out value="${p.product_description}"/></td>

                <td><c:out value="${p.product_price}"/></td>

                <td><c:out value="${p.product_quantity}"/></td>

                <td>

                    <a href="EditProduct.jsp?product_id=${p.product_id}&product_name=${p.product_name}&product_description=${p.product_description}&product_price=${p.product_price}&product_quantity=${p.product_quantity}">Edit</a>

                    <a href="DeleteProductController?product_id=${p.product_id}">Delete</a>

                </td>

            </tr>

        </c:forEach>

    </table>

</body>

</html>