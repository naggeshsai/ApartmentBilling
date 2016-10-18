<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js">
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>PerPerson Expenses</title>
</head>
<body>
	<p id="demo"></p>
	<script>
		$(document)
				.ready(
						function() {
							$("button")
									.click(
											function() {
												$
														.ajax({
															url : "http://localhost:8080/ApartmentBilling/billing/user/getAmountPerPerson",
															contentType : "application/json; charset=utf-8",
															type : "GET",
															success : function(
																	data) {
																var perPersonExpensess = data;
																var tabledef="<table><th>Id</th><th>Spent by</th><th>Amount</th>";
																var tableend="</table>";
																var outputtext = "";
																for (var i = 0; i < perPersonExpensess.length; i++) {
																	outputtext = outputtext	+ "<tr><td>" +perPersonExpensess[i].id + "</td><td>" + perPersonExpensess[i].spentby + "</td><td>" + perPersonExpensess[i].amount + "</td></tr>";
																}
																document.getElementById("demo").innerHTML =tabledef+outputtext+tableend;
															},
															error : function(x,
																	y, z) {
																alert(x.responseText
																		+ "  "
																		+ x.status);
															}
														});
											});
						});
	</script>
	<button>Calculate PerPersonExpenses</button>
</body>
</html>