<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="Package.FeedbackBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		FeedbackBean fb = (FeedbackBean) request.getAttribute("feedbackBean");
	%>
	<h3>Your Feedback:</h3>
	<table>
		<tr>
			<th>Registration No</th>
			<th>Name</th>
			<th>Question 1</th>
			<th>Question 2</th>
			<th>Question 3</th>
			<th>Question 4</th>
			<th>Question 5</th>
		</tr>
		<tr>
			<td><%=fb.getRegno() %></td>
			<td><%=fb.getStdName() %></td>
			<td><%=fb.getQ1() %></td>
			<td><%=fb.getQ2() %></td>
			<td><%=fb.getQ3() %></td>
			<td><%=fb.getQ4() %></td>
			<td><%=fb.getQ5() %></td>
		</tr>
	</table>
	<h2>Thank You for your Feedback..!!!</h2>
	<form action="logout">
		<table>
			<tr>
				<td><button class="b">Logout</button></td>
			</tr>
		</table>
	</form>
</body>
</html>