<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html>

<head>

    <meta charset="ISO-8859-1">

    <title>Admin Dashboard</title>

    <style>

        body {

            font-family: Arial, sans-serif;

            margin: 0;

            padding: 0;

        }

 

        .header {

            background-color: #333;

            color: #fff;

            padding: 10px 0;

            text-align: center;

        }

 

        .nav-menu {

            display: flex;

            justify-content: center;

            background-color: #444;

        }

 

        .nav-menu a {

            color: #fff;

            text-decoration: none;

            padding: 10px 20px;

            transition: background-color 0.3s;

        }

 

        .nav-menu a:hover {

            background-color: #555;

        }

    </style>

</head>

<body>

    <div class="header">

        <h1>Admin Dashboard</h1>

    </div>

    <div class="nav-menu">

        <a href="./adminChoiceController?AdminOpr=Add Product">Add Product</a>

        <a href="./adminChoiceController?AdminOpr=View Product">View Product</a>

        <a href="./adminChoiceController?AdminOpr=View Users">View Users</a>

        <a href="./login.jsp">Logout</a>

    </div>

</body>

</html>

