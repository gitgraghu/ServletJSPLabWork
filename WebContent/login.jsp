<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="css/bootstrap.min.css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
<%@include file="WEB-INF/header.jsp" %>
<div class="container">
<h3>Enter Login credentials</h3>
<form class="form-horizontal" method="post" action="home">
<div class="form-group">
	<div class="col-sm-4">
		<input class="form-control" type="text" name="user" placeholder="Username"/>
	</div>
</div>
<div class="form-group">
	<div class="col-sm-4">
		<input class="form-control" type="password" name="password" placeholder="Password"/>
	</div>
</div>
<div class="form-group">
<div class="col-sm-4">
<input type="submit" class="btn btn-info" value="Login">
</div>
</div>
</form>
</div>
</body>
</html>