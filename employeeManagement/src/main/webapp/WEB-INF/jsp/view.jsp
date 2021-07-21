<%@ page import="com.employee.entity.Employe" %>  
<%@ page import="java.util.List" %>  
<html>
<body>

<hr>

<center><h1>Employee table</h1></center>
<% 
	List<Employe> employe=(List)request.getAttribute("lists");
	for(Employe e:employe)
	{
	%>
	<center>
	
	<table>
	<th>First Name</th>
	<th> Last Name</th>
	<th> Salary</th>
	<th>Department</th>
	<th>position</th>
	<th>Image</th>
	<th>Update</th>
	<th>Delete</th>
	<tr>
	<td><%= e.getFirstName() %></td>
	<td><%=e.getLastName() %></td>
	<td><%=e.getSalary() %></td>
	<td><%=e.getDepartment() %></td>
	<td><%=e.getPosition() %></td>
	<td>
	<img src="/img/<%=e.getImageName()%>" height="50" width="50"/>
	</td>
	<td><a href="/update/<%=e.getEid() %>">Update</a></td>
	<td><a href="/delete/<%=e.getEid() %>">Delete</a></td>
	<% }
	
	%>
	</tr>
	</h1>
</hr>
           
</table></center>



            </body>
  </html>