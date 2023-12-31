<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="emp" class="edu.training.dao.Employee"></jsp:useBean>

<jsp:setProperty property="eid" name="emp" value="105"/>
<jsp:setProperty property="ename" name="emp" value="DDD"/>
<jsp:setProperty property="salary" name="emp" value="14000"/>

<c:out value="${emp }"></c:out><br>
<jsp:getProperty property="eid" name="emp"/>
<jsp:getProperty property="ename" name="emp"/>
<jsp:getProperty property="salary" name="emp"/><br>

<sql:setDataSource var="con" driver="com.mysql.cj.jdbc.Driver" url="jdbc:mysql://localhost:3306/prodapt" user="root" password="root"/>


<sql:update var="temp" dataSource="${con}">insert into emp values(<jsp:getProperty property="eid" name="emp"/>,'<jsp:getProperty property="ename" name="emp"/>','<jsp:getProperty property="salary" name="emp"/>') </sql:update>

<sql:query var="data" dataSource="${con }">select * from emp</sql:query>

<c:forEach var="e" items="${data.rows }">
<c:out value="${e.eid }"></c:out>
<c:out value="${e.ename }"></c:out>
<c:out value="${e.salary }"></c:out><br>

<jsp:setProperty property="eid" name="emp" value="${e.eid }"/>
<jsp:setProperty property="ename" name="emp" value="${e.ename }"/>
<jsp:setProperty property="salary" name="emp" value="${e.salary }"/>

<c:out value="${emp }"></c:out><br>
</c:forEach>

</body>
</html>