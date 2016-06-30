<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="css/bootstrap.min.css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create Item</title>
</head>
<body>
<%@include file="WEB-INF/header.jsp" %>
<div class="container">
<form class="form-horizontal" method="post" action="create">
  <div class="form-group">
    <label for="inputName" class="col-sm-2 control-label">Name</label>
    <div class="col-sm-6">
      <input type="text" class="form-control" name="itemname" id="inputName" placeholder="Name">
    </div>
  </div>
  <div class="form-group">
    <label for="inputDescription" class="col-sm-2 control-label">Description</label>
    <div class="col-sm-6">
      <input type="text" name="itemdescription" class="form-control" id="inputDescription" placeholder="Description">
    </div>
  </div>
    <div class="form-group">
    <label for="inputDate" class="col-sm-2 control-label">Date</label>
    <div class="col-sm-6">
      <input type="text" name="date" class="form-control" id="inputDate">
    </div>
  </div>
  <div class="form-group">
    <label for="inputPrice" class="col-sm-2 control-label">Price</label>
    <div class="col-sm-6">
      <input type="number" name="price" class="form-control" id="inputPrice">
    </div>
  </div>
    <div class="form-group">
    <label for="inputQuantity" class="col-sm-2 control-label">Quantity</label>
    <div class="col-sm-6">
      <input type="number" name="quantity" class="form-control" id="inputQuantity">
    </div>
  </div>
  <c:choose>
	<c:when test="${cookie.userid.value=='1'}">
	<div class="form-group">
	<label for="inputUserid" class="col-sm-2 control-label">User Id</label>
	<div class="col-sm-6">
		<input type="number" class="form-control" id="inputQuantity" name="userid" >
	</div>
	</div>
	</c:when>
	<c:otherwise>
		<input type="hidden" name="userid" value="${cookie.userid.value}"/>
	</c:otherwise>
  </c:choose>
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
   		<input type="submit" class="btn btn-info" value="Create"/>
   </div>
  </div>
</form>
</div>
</body>
</html>