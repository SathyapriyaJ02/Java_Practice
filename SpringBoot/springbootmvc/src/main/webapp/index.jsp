<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
Hi Hello Welcome
<form action="/add">
Employee id <input type="text" name="eid">
Employee Name<input type="text" name="ename">
Employee Salary<input type="text" name="esalary">
Department<input type="text" name="edepartment">
<input type ="submit">
</form>
<a href="/viewEmployees">View Employees</a>
</body>
</html>