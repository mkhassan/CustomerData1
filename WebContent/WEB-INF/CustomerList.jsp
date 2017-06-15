<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Customer Data Application</title>
</head>
<body>
	<center>
		<h1> Customer Records Manager</h1>
		<h2>
			<a href="/new"> Add New Customer</a>
			<a href="/list"> List All Books </a>
		</h2>
	</center>

	<div align="center">
		<table border="1" cellpadding="5">
		<caption> <h2> List of Customers </h2></caption>
		<tr>
			<th>FirstName</th>
			<th>LastName</th>
			<th>Address</th>
			<th>Actions</th>
		</tr>
		<c:forEach var="customer" items="${listCustomer}">
			<tr>
				<td><c:out value="${customer.firstname}" /></td>
				<td><c:out value="${customer.lastname }"/></td>
				<td><c:out value="${customer.address }"/></td>
				
				<td>
					<a href="/edit?id=<c:out  value='${customer.customerid}' />">Edit</a> 
					<a href="/delete?id=<c:out value='${custmer.customerid }' />">Delete</a>
					
				</td>
			</tr>
			
		</c:forEach>		
				
		</table>
	</div>
</body>
</html>