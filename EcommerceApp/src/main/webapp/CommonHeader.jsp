<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<style>

    .header-container {

        display: flex;

        justify-content: center;

        align-items: center;

        background-color: #f0f0f0; /* Background color for the header */

        padding: 10px 0; /* Add padding for spacing */

    }

 

    .header-link {

        text-decoration: none;

        padding: 10px 20px; /* Add padding to style as buttons */

        background-color: #007bff; /* Button background color */

        color: #fff; /* Text color */

        border-radius: 5px; /* Rounded corners */

        margin: 0 10px; /* Margin between buttons */
        
        font-family: "Times New Roman", Times, serif;

    }

</style>

 

<div class="header-container">

    <a class="header-link" href="Home.jsp">Home</a>

    <a class="header-link" href="login.jsp">Login</a>

    <a class="header-link" href="Register.jsp">Register</a>

</div>
</body>
</html>