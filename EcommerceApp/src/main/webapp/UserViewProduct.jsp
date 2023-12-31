<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
  <jsp:include page="UserHomePage.jsp" />
<center>
 <table>

        <tr>

            <th>Product ID</th>

            <th>Product Name</th>

            <th>Product Description</th>

            <th>Product Price</th>

            <th>Action</th><br>

        </tr>

        <c:forEach var="p" items="${view}">
        

            <tr>

                <td><c:out value="${p.product_id}"/></td>

                <td><c:out value="${p.product_name}"/></td>

                <td><c:out value="${p.product_description}"/></td>

                <td><c:out value="${p.product_price}"/></td>
               
               <input type="hidden" name="productQ" value="${p.product_quantity}">                

                <td>

                    <a href="./UserWishListController?userOpr=Wishlist&productId=${p.product_id}" class="button"> Add to WishList</a>
                    <a href="./UserAddToCartController?userOpr=AddToCart&productId=${p.product_id}&productname=${p.product_name}&productdes=${p.product_description}&productprice=${p.product_price}&productQ=${p.product_quantity}" class="button">Add to cart</a>
                    <a href="./BuyController?userOpr=userView&productId=${p.product_id}&productQ=${p.product_quantity}" class="button">Buy</a>
                </td>

            </tr>

        </c:forEach>

    </table>
    </center>

</body>
</html>




 