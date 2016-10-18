<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Amount</title>
</head>
<body>
	<form action="billing/user/addMoney" method="post">
		<table align="center">
			<tr>
				<td>Name-</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td>Amount-</td>
				<td><input type="text" name="amount"></td>
			</tr>
			<tr>
				<td>Spent by-</td>
				<td><input type="text" name="spentby"></td>
			</tr>
			<tr>
				<td>Date-</td>
				<td><input type="text" name="entereddate"></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Add Money"></td>
			</tr>
		</table>
	</form>
</body>
</html>