<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<style>
* {
	box-sizing: border-box;
}

.row {
	margin-left: -5px;
	margin-right: -5px;
}

.column {
	float: left;
	width: 60%;
	padding: 3px;
}

.column1 {
	float: left;
	width: 25%;
	padding: 3px;
}

/* Clearfix (clear floats) */
.row::after {
	content: "";
	clear: both;
	display: table;
}

table {
	border-collapse: collapse;
	border-spacing: 0;
	width: 100%;
}

th, td {
	text-align: left;
	padding: 5px;
}

#message {
	color: red;
}
</style>
</head>

<body style="background-color: lavender">

	<h1><center>Classic Book House</center>
	</h1>
	<form:form  method="POST" action="addBook" modelAttribute="book">
		<div class="row">
			<div class="column1">
				<table>
					<tr>
						<td><a href="index">Home</a><br></td>
					<tr>
						<td><a href="viewList">View All Books</a></td>
					</tr>
				</table>
			</div>
			<div class="column">
				<table
					style="margin: 0px auto; margin-left: auto; margin-right: auto">


					<tr>
						<td>ISBN</td>
						<td><input type="text" id="isbn" name="isbn" /></td>
					</tr>
					<tr>
						<td>Book Name</td>
						<td><input type="text" id="bookName" name="bookName" /></td>
					</tr>
					<tr>
						<td>Quantity</td>
						<td><input type="text" id="quantity" name="quantity" /></td>
					</tr>
					<tr>
						<td>Book Category</td>
						 <td><form:select path="category">
								<form:option value="NONE" label="Science" />
								 <form:options items="${bookCategory}"/>
							</form:select> 
							</td> 
					</tr>

					<tr>
						<td>Book Price</td>
						<td><input type="text" id="price" name="price" /></td>
					</tr>

					<tr>
						<td></td>
						<td><input type="submit" id="submit" name="submit"
							value="AddBook" /></td>
					</tr>

				</table>
			</div>
		</div>
		<center>
			<div id="message">${message}</div>
		</center>
	</form:form>


</body>
</html>
