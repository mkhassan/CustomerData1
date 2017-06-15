<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title> Customers Form App</title>
</head>
<body>
	<center>
	<h1> Customers Manager </h1>
	<h2>
		<a href="/new"> Add New Customer</a>
		<a href="/list"> List Customers</a>
	</h2>
	</center>
	
	<div align="center">
		 <c:if test="${customer != null }">
		 <form action="update" method="post">
		 </c:if>
		 </form>
		 
		 
		 <c:if test="${customer == null }">
		 <form action="insert" method="post">
		 </c:if>
		 <table border="1" cellpadding="5">
		 	<caption>
		 		<h2>
		 			<c:if test = "${customer != null }">
		 			Edit Customer
		 			</c:if>
		 			<c:if test="${book == null }">
		 			Add New Customer
		 			</c:if>
		 		</h2>
		 	</caption>
		 		<c:if test="${book != null }">
		 			<input type="hidden" name="customerid" value=<c:out value='${customer.customerid }' />" />
		 		</c:if>
		 	<tr>
		 	    <th>FirstName: </th>
                <td>
                    <input type="text" name="firstname" size="45"
                            value="<c:out value='${customer.firstname}' />"
                        />
                </td>	 	
		 	</tr>
		 	<tr>
                <th>LastName: </th>
                <td>
                    <input type="text" name="lastname" size="45"
                            value="<c:out value='${customer.lastname}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Address: </th>
                <td>
                    <input type="text" name="address" size="5"
                            value="<c:out value='${customer.address}' />"
                    />
                </td>
            </tr>
              <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save" />
                </td>
            </tr>
           	
		 </table>
		 </form>
	</div>

</body>
</html>