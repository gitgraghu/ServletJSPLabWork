<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create Item</title>
</head>
<body>
<%@include file="WEB-INF/header.jsp" %>
<form method="post" action="create">
<p>Name: <input type="text" name="itemname" /></p>
<p>Description: <input type="text" name="itemdescription" /></p>
<p>Date: <input type="text" name="date" /></p>
<p>Price: <input type="number" name="price" /></p>
<p>Quantity: <input type="number" name="quantity" /> </p>
<c:choose>
<c:when test="${cookie.userid.value=='1'}">
<p>User Id: <input type="number" name="userid" /> </p>
</c:when>
<c:otherwise>
	<input type="hidden" name="userid" value="${cookie.userid.value}"/>
</c:otherwise>
</c:choose>
<input type="submit" value="Create"/>
</form>

</body>
</html>