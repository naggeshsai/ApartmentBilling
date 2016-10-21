<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.billing.apartment.UserService"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js">
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
	<p id="demo" align="center"></p>
	<form action="billing/user/authencticateUser" method="post">
	<table align="center">
		<tr>
			<td>Email:- </td><td><input type="email" name="email" required></td>
		</tr>
		<tr>
			<td>Password:- </td><td><input type="password" name="password" required><br></td>
		</tr>
		<tr>
			<td><input type="submit" value="Loign" name="submit"></input></td>
			<td><a href="/ApartmentBilling/AddUser.jsp">Sign Up</a></td>
		</tr>
	</table>
	</form>
</body>
</html>