<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>





<sql:setDataSource var ="db" 
driver="com.mysql.cj.jdbc.Driver" 
url="jdbc:mysql://localhost:3306/prodapt" 
user="root" 
password="root" />
<sql:query var="rs" dataSource="${db}">select * from employees</sql:query>
<c:forEach var="emp" items="${rs.rows }">
<c:out value="${emp.First_Name}"></c:out>
<c:out value="${emp.Last_Name}"></c:out>
<c:out value="${emp.Email}"></c:out>
<c:out value="${emp.Mobile_Number}"></c:out><br>
</c:forEach> 


</body>
</html>