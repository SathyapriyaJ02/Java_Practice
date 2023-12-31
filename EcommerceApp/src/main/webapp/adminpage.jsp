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

  background-color: #f0f0f0;

  margin: 0;

  padding: 0;

  display: flex;

  justify-content: center;

  align-items: center;

  height: 100vh;

}

 

.container {

  text-align: center;

  background-color: #fff;

  border-radius: 5px;

  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);

  padding: 20px;

  margin-top: -50px; /* Adjust this value to move the UI up or down */

}

 

h1 {

  font-size: 24px;

}

 

.button-container {

  display: flex;

  justify-content: space-between;

  margin-top: 20px;

}

 

.button {

  background-color: #007bff;

  color: #fff;

  border: none;

  padding: 10px 20px;

  cursor: pointer;

  border-radius: 3px;

  flex-grow: 1;

  margin: 0 10px;

  text-decoration: none;

  text-align: center;

  font-size: 16px;

}

 

.button:hover {

  background-color: #0056b3;

}

 

.logout-container {

  margin-top: 20px; /* Adjust the margin-top to separate the logout button container */

}

 

.logout-button {

  background-color: #dc3545;

  color: #fff;

  border: none;

  padding: 10px 20px;

  cursor: pointer;

  border-radius: 3px;

  text-decoration: none;

  font-size: 16px;

}

 

.logout-button:hover {

  background-color: #c82333;

}

</style>

</head>

<body>

<div class="container">

  <h1>Admin Dashboard</h1>

  <div class="button-container">

    <a href="./adminChoiceController?AdminOpr=Add Product" class="button">Add Product</a>

    <a href="./adminChoiceController?AdminOpr=View Product" class="button">View Product</a>

    <a href="./adminChoiceController?AdminOpr=View Users" class="button">View Users</a>

  </div>

  <div class="logout-container">

    <a href="./home" class="button logout-button">Logout</a>

  </div>

</div>

</body>

</html>