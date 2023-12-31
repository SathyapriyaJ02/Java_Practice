<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html>

<head>

    <meta charset="UTF-8">

    <title>Search Results</title>

</head>

<body>

<jsp:include page="UserHomePage.jsp" />
<center>
    Search Results

    <c:choose>
    <c:when test = "${not empty search }">

        <table cellpadding="15">

            <tr>

                <th>Product ID</th>

                <th>Product Name</th>

                <th>Product Description</th>

                <th>Product Price</th>

            </tr>

            <c:forEach var="product" items="${search}">

                <tr>

                    <td><c:out value="${product.product_id}" /></td>

                    <td><c:out value="${product.product_name}" /></td>

                    <td><c:out value="${product.product_description}" /></td>

                    <td><c:out value="${product.product_price}" /></td>
                    
                     <input type="hidden" name="productQ" value="${p.product_quantity}">                

                <td>

                    <a href="./UserWishListController?userOpr=search&productId=${product.product_id}" class="button"> Add to WishList</a>
                    <a href="./UserAddToCartController?userOpr=AddToCart&productId=${product.product_id}&productname=${product.product_name}&productdes=${product.product_description}&productprice=${product.product_price}&productQ=${product.product_quantity}" class="button">Add to cart</a>
                    <a href="./BuyController?userOpr=userView&productId=${product.product_id}&productQ=${product.product_quantity}" class="button">Buy</a>
                </td>

                </tr>

            </c:forEach>

        </table>
        </c:when>

    

    <c:otherwise>

        <p>No matching products found.</p>
        </c:otherwise>
        </c:choose>

   
    </center>

</body>

</html>
