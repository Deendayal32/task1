<%@ page import="com.employee.entity.Employe" %> 
<html>
<head>
<body>
	<center>
	<%
	Employe employe=(Employe)request.getAttribute("e");
	
	%><%=employe.getEid() %>
	<form method="post" action="/edit">
		 <input type="hidden" name="eid" value="<%= employe.getEid() %>" / ><br>
		First Name <input type="text" name="firstName" value="<%= employe.getFirstName() %>"/ ><br>
		List Name  <input type="text" name="LastName" value="<%= employe.getLastName() %>"/><br>
		Salary <input type="text" name="salary" value="<%= employe.getSalary() %>"/><br>
		Department <input type="text" name="department" value="<%= employe.getDepartment() %>"/><br>
		Position <input type="text" name="position" value="<%= employe.getPosition() %>"/><br>
		Email Address <input type="email" name="email" value="<%= employe.getEmail() %>"/><br>
		Contact Number <input type="number" name="contactNumber" value="<%= employe.getContactNumber() %>"/><br>
		<input type="submit"/>
	</form>
	<a href="/show">View Employee</a>
	</center>
</body>
</head>
</html>