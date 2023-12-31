<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html>

 

<head>

    <meta charset="UTF-8">

    <title>Registration Form</title>

    <style>

        body {

            font-family: "Times New Roman", Times, serif;

            background-image: url('Login.jpg');

            background-size: cover;

            background-repeat: no-repeat;

            background-position: center;

            margin: 0;

            padding: 0;

        }

 

        .container {

            display: flex;

            justify-content: center;

            align-items: center;

            height: 100vh;
            
            padding-top: 30px; /* Add padding at the top for spacing */
            
            

        }

 

        h1 {

            text-align: center;

            font-family: "Times New Roman", Times, serif;

            color: #333;

            margin-top: 10px;

        }

 

        form {

            background-color: rgba(255, 255, 255, 0.8);

            border-radius: 5px;

            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);

            width: 400px;

            padding: 20px;

        }

 

        table {

            width: 100%;

        }

 

        td {

            padding: 10px;

        }

 

        input[type="text"],

        input[type="date"],

        input[type="password"] {

            width: 100%;

            padding: 10px;

            border: 1px solid #ccc;

            border-radius: 3px;

            margin-bottom: 10px;

        }

 

        input[type="submit"],

        input[type="reset"] {

            background-color: #007bff;

            color: #fff;

            border: none;

            padding: 10px 20px;

            cursor: pointer;

            border-radius: 3px;

        }

 

        input[type="submit"]:hover,

        input[type="reset"]:hover {

            background-color: #0056b3;

        }

 

        label {

            font-weight: bold;

        }

 

        .error-message {

            color: red;

            text-align: center;

        }

 

        /* Center the navigation links */

        center {

            display: flex;

            justify-content: center;

            margin-top: 10px;

        }

 

        center a {

            margin: 0 10px;

            text-decoration: none;

            color: #007bff;

            font-weight: bold;

        }

		

   


    </style>

</head>

 

<body>

    <div class="container">
    
   	 

        <form action="./UserRegisterController" method="get">
         <jsp:include page="CommonHeader.jsp" />
           <h1>REGISTER HERE</h1>
           
           
 

            <table cellpadding="10">

                <tr>

                    <td><label>Name</label></td>

                    <td><input type="text" name="name" value="" placeholder="Enter your name"></td>

                </tr>

                <tr>

                    <td><label>Date of Birth</label></td>

                    <td><input type="date" name="dateOfBirth" value="" placeholder="Enter your DOB"></td>

                </tr>

                <tr>

                    <td><label>Mobile Number</label></td>

                    <td><input type="text" name="phoneNumber" value=""

                            placeholder="Enter your mobile number"></td>

                </tr>

                <tr>

                    <td><label>Address</label></td>

                    <td><input type="text" name="address" value="" placeholder="Enter your address"></td>

                </tr>

                <tr>

                    <td><label>Email</label></td>

                    <td><input type="text" name="email" value="" placeholder="Enter your Email-id"></td>

                </tr>

                <tr>

                    <td><label>Password</label></td>

                    <td><input type="password" name="password" value="" placeholder="Enter your password"></td>

                </tr>

            </table>

            <input type="submit" value="Register">

            <input type="reset" value="Reset">

            <div class="error-message">

                <c:if test="${not empty requestScope.error }">

                    ${requestScope.error}

                </c:if>

            </div>

        </form>

    </div>

</body>

 

</html>


