<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    


<!DOCTYPE html>

<html lang="en">

<head>

    <meta charset="UTF-8">

    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>Insert title here</title>

    <link rel="stylesheet" type="text/css" href="style.css">

    <style>

        /* Add your custom styles here */

        body {

            font-family: Arial, sans-serif;

            background-color: #f7f7f7;

            margin: 0;

            padding: 0;

        }

 

        header {

            background-color: #333;

            color: #fff;

            text-align: center;

            padding: 10px;

        }

 

        .form-container {

            max-width: 600px;

            margin: 20px auto;

            padding: 20px;

            background-color: #fff;

            border-radius: 5px;

            box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.2);

        }

 

        form {

            margin: 0;

            padding: 0;

        }

 

        label {

            display: block;

            margin-bottom: 10px;

            font-weight: bold;

            color: #555;

        }

 

        input[type="text"] {

            width: 100%;

            padding: 10px;

            margin-bottom: 15px;

            border: 1px solid #ccc;

            border-radius: 3px;

            color: #333;

        }

 

        input[type="submit"],

        input[type="reset"] {

            background-color: #007bff;

            color: #fff;

            padding: 10px 20px;

            border: none;

            border-radius: 3px;

            cursor: pointer;

            transition: background-color 0.3s ease;

        }

 

        input[type="submit"]:hover,

        input[type="reset"]:hover {

            background-color: #0056b3;

        }

    </style>

</head>

<body>

    <header>

        <jsp:include page="CommonAdminPage.jsp" />

    </header>

    <div class="form-container">

        <form action="./ProductAddController" method="get">

            <label for="product_id">Product ID</label>

            <input type="text" id="product_id" name="product_id" value="" placeholder="Enter product id">

 

            <label for="product_name">Product Name</label>

            <input type="text" id="product_name" name="product_name" value="" placeholder="Enter product name">

 

            <label for="product_description">Product Description</label>

            <input type="text" id="product_description" name="product_description" value="" placeholder="Enter product description">

 

            <label for="product_price">Product Price</label>

            <input type="text" id="product_price" name="product_price" value="" placeholder="Enter price">

 

            <label for="product_quantity">Product Quantity</label>

            <input type="text" id="product_quantity" name="product_quantity" value="" placeholder="Enter quantity">

 

            <input type="submit" name="Add" value="Add Product">

            <input type="reset" name="Reset" value="Clear">

        </form>

    </div>

</body>

</html>