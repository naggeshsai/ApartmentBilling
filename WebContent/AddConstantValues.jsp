<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Constant Values</title>
</head>
<body>
	<form action="billing/user/addConstantValue" method="post">
		<table align="center">
			<tr>
				<td>Name -</td>
				<td><input type="text" name="name" required></td>
			</tr>
			<tr>
				<td>Amount -</td>
				<td><input type="text" name="amount" required></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Add Value" ></td>
			</tr>
		</table>
	</form>
</body>
</html>