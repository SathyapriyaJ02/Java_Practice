`<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table cellpadding="15" align="center">

        <tr>

            <td><a href="UserHomePage.jsp">Home</a></td>

            <td><a href="UserChoiceController?UserOpr=viewProduct">View Product</a></td>

            <td><a href="search.jsp">Search Product</a></td>
            
            <td><a href="MyWishList.jsp">My Wishlist</a></td>
             
            <td><a href="UserAddToCartController?userOpr=viewCart">My Cart</a></td>
              
            <td><a href="UserChoiceController?UserOpr=logout">Log Out</a></td>

        </tr>

    </table>
    
</body>
</html>