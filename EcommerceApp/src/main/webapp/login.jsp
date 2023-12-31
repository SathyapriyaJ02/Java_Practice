<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>

<html>

<head>

    <meta charset="ISO-8859-1">
	<title>Login Page</title>
	<style>
		body 
		{
			background-image: url('Login.jpg');
			background-size: 1250px 850px;
			background-repeat: no-repeat;
			background-position: center;
			font-family: Arial, sans-serif; /* Set a custom font */
		}

 		h1 
 		{
			color: #333; /* Change the heading color */
		}
		form 
        {
			background-color: rgba(255, 255, 255, 0.8); /* Semi-transparent white background */
			padding: 20px;
			border-radius: 10px;
			width: 200px;
			margin: 0 auto;

        }

 		label 
 		{
			display: block;
			margin-bottom: 10px;
			font-weight: bold;
		}

        input[type="text"],
		input[type="password"] 
		{
			width: 100%;
			padding: 10px;
			margin-bottom: 15px;
			border: 1px solid #ccc;
			border-radius: 5px;
			font-size: 16px;
		}

 		input[type="submit"],
		input[type="reset"] 
		{
			background-color: #007BFF; /* Button background color */
			color: #fff; /* Button text color */
			padding: 10px 20px;
			border: none;
			border-radius: 5px;
			cursor: pointer;
			font-size: 18px;
		}
		input[type="submit"]:hover,
		input[type="reset"]:hover 
		{
			background-color: #0056b3; /* Button background color on hover */
		}
		center
		{

            margin-top: 50px;
		}

    </style>

</head>

<body>

    <center>

        <h1>LOGIN HERE</h1>
		<form action="./LoginController" method="post">
			<label for="userName">User Name</label>
			<input type="text" id="userName" name="userName" placeholder="Enter your user name" required>
			<br>
			<label for="pwd">Password</label>
			<input type="password" id="pwd" name="pwd" placeholder="Enter your password" required>
			<br>
			<input type="submit" value="Login">
			<input type="reset" value="Reset">
		</form>

    </center>

</body>
</html>