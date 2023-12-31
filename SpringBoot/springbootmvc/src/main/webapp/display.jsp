<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<body>
<%@ page import="java.util.List" %>
<%@ page import = "com.example.demo.model.Employee" %>
<table>
<thead>
<tr>
<th>Eid</th>
<th>Ename</th>
<th>Esalary</th>
<th>Department</th>
</tr>
</thead>
<tbody>
<% List<Employee> nList=(List<Employee>)request.getAttribute("employeeList"); 
					for(Employee e : nList)
						{
%>
<tr>
<td>
<%= e.getEid() %>
<%= e.getEname() %>
<%= e.getEsalary() %>
<%= e.getEdepartment() %>
</td>	
</tr>
<% } %>					
</tbody>
</table>
</body>
</html>