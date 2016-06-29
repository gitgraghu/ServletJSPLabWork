<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
<%@include file="WEB-INF/header.jsp" %>
<h2>Enter Login credentials:</h2>
<form method="post" action="login-post">
<p><input type="text" name="user" /></p>
<p><input type="password" name="password" /></p>
<p><input type="submit" value="Login" /></p>
</form>
</body>
</html>