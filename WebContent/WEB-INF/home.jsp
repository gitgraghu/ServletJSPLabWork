<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
</head>
<body>
<p> Welcome to the Home page !!</p>
<p> Message: ${message} </p>
<table>
<tr><th>Name</th><th>Description</th><th>Date</th><th>Price</th><th>Quantity</th></tr>

<c:forEach items="${data}" var="item">
<tr>
<td>${item.name}</td>
<td>${item.description}</td>
<td>${item.date}</td>
<td>${item.price}</td>
<td>${item.quantity}</td>
</tr>
</c:forEach> 
</table>

<c:if test="${data == null}">
<p> No items to display.. </p>
</c:if>

</body>
</html>