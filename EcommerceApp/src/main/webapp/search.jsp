<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="UserHomePage.jsp" />
<center>
<form action="SearchController" method="GET">

		<input type="hidden" name="UserOpr" value="search">
	        
        <label for="searchKeyword">Search for Products:</label>

        <input type="text" id="searchKeyword" name="searchKeyword" required>

        <button type="submit">Search</button>
	</center>
    </form>
</body>
</html>