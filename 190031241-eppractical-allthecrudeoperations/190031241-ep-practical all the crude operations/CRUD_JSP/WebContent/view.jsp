<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="java.sql.ResultSet"%>
<%@ page import="java.sql.Connection"%>
<%@ page import="java.sql.PreparedStatement"%>
<%@ page import="Package.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Details</title>
</head>
<body>
	<%
		Connection con = DBUtil.DBConnection();
		String q = "select * from student_crud";
		PreparedStatement ps = con.prepareStatement(q);
		ResultSet d = (ResultSet) ps.executeQuery();
	%>

	<h2 align="center">Details of All Students</h2>
	<table align="center" border="1" width="60%">
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Email</th>
			<th>Department</th>
			<th>Actions</th>
		</tr>
		<%
			while (d.next()) {
		%>
		<tr>
			<td><%=d.getInt(1)%></td>
			<td><%=d.getString(2)%></td>
			<td><%=d.getString(3)%></td>
			<td><%=d.getString(4)%></td>
			<td>&nbsp;&nbsp;<a href="Edit.html">Edit</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<a href="Servlet_3?id=<%=d.getInt(1)%>">Delete</a>&nbsp;&nbsp;
			</td>
		</tr>
		<%
			}
		%>
	</table>
</body>
</html>