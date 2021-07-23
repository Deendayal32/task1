<%@ page import="com.employee.entity.Employe" %>  
<%@ page import="java.util.List" %>  
<html>
<body>

<hr>

<center><h1>Employee Records</h1></center>
<% 
	List<Employe> employe=(List)request.getAttribute("lists");
	String msg=(String)request.getAttribute("message");

	for(Employe e:employe)
	{
	%>
	<center>
	
	<table>
		<th>Image</th>
	<th>First Name</th>
	<th> Last Name</th>
	<th>Update</th>
	<th>Delete</th>
	<tr>
	<td>
	<img src="/img/<%=e.getImageName()%>" height="50" width="50"/>
	</td>
	<td><%= e.getFirstName() %></td>
	<td><%=e.getLastName() %></td>
	
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