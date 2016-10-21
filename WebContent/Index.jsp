<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home Page</title>
</head>
<body>
<%
String email="a";
if (request.getParameter("email")!=null){
	email=(String) request.getParameter("email");
	}%>
	<table align="center">
		<tr>
			<td><a href=/ApartmentBilling/Login.jsp>Login</a><br></td>
			<td><a href=/ApartmentBilling/AddConstantValues.jsp?email=<%=email %>>AddConstantValues</a><br>
			</td>
			<td><a href=/ApartmentBilling/AddMoney.jsp?email=<%=email %>>AddMoney</a><br>
			</td>
			<td><a href=/ApartmentBilling/Register.jsp?email=<%=email %>>Register</a><br>
			</td>
			<td><a href=/ApartmentBilling/PerPersonExpenses.jsp?email=<%=email %>>PerPersonExpenses</a><br>
			</td>
			<td><a href=/ApartmentBilling/PerPersonPerMonthExpenses.jsp?email=<%=email %>>PerPersonPerMonthExpenses</a><br>
			</td>
		</tr>
	</table>
</body>
</html>