<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<body>
<%@ page import="java.util.*" %>
<%@ page import = "com.example.demo.entity.Employee" %>
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
<% List<Employee> nList=(ArrayList<Employee>)request.getAttribute("emp"); 
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