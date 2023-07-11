<%@page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html>
<body bgcolor="lavender">
	<h1>
		<center>Classic Book House</center>
	</h1>

	<h2>${message}</h2>
	<!--  Design the page as per the requirements-->
	<center>
		<table border="2" width="40%" cellpadding="2">
			<tr>
				<th>ISBN</th>
				<th>Book Name</th>
				<th>Book Category</th>
				<th>Quantity</th>
				<th>Price</th>
			</tr>
			<c:forEach var="v" items="${bookList}">
				<tr>
					<td>${v.isbn }</td>
					<td>${v.bookName}</td>
					<td>${v.category}</td>
					<td>${v.quantity}</td>
					<td>${v.price}</td>


				</tr>
			</c:forEach>


		</table>

	<a href="index">Back to Home</a>
	</center>


</body>
</html>