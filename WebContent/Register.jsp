<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add User</title>
</head>
<body>
	<form action="billing/user/addUser" method="post">
		<table align="center">
			<tr>
				<td>Name -</td>
				<td><input type="text" name="name" required></td>
			</tr>
			<tr>
				<td>Email -</td>
				<td><input type="email" name="email" required></td>
			</tr>
			<tr>
				<td>Password -</td>
				<td><input type="password" name="password" required></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Register"></td>
			</tr>
		</table>
	</form>
</body>
</html>