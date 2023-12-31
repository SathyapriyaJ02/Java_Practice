<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html>

<head>

<meta charset="ISO-8859-1">

<title>Registered Users</title>

</head>

<body>

<center>

<header>

        <jsp:include page="CommonAdminPage.jsp" />

    </header>
    <h1>Registered Users</h1>

    <table border="1">

        <tr>

            <th>Name</th>

            <th>Date of Birth</th>

            <th>Phone Number</th>

            <th>Address</th>

            <th>Email</th>

            <th>Approval Status</th>

            <th>Actions</th>

        </tr>

        <c:forEach var="u" items="${users}">

            <tr>

				<td>${u.name}</td>

                <td>${u.dateOfBirth}</td>

                <td>${u.phoneNumber}</td>

                <td>${u.address}</td>

				<td>${u.email}</td>

                <td>${u.approvalStatus}</td>

                <td>

<a href="./ApproveUserController?action=approve&userEmail=${u.email}">Approve</a>

<a href="./ApproveUserController?action=deny&userEmail=${u.email}">Deny</a>

                </td>

            </tr>

        </c:forEach>

        <tr></tr>

    </table>

</center>

</body>

</html>