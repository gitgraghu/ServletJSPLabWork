<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<nav class="navbar navbar-default">
<div class="container-fluid">
<c:choose>
<c:when test="${not empty userid}">
	<ul class="nav navbar-nav navbar-left">
	 	<li role="presentation"><a href="logout">Logout</a></li>
	 	<li role="presentation"><a href="data">View Items</a></li>
	 	<li role="presentation"><a href="createitem">Create Item</a></li>
 	</ul>
 		<p class="navbar-text navbar-right">Signed in as ${username}</p>
</c:when>
<c:otherwise>
<ul class="nav navbar-nav">
	<li role="presentation"><a href="login.jsp">Login</a></li>
</ul>
</c:otherwise>
</c:choose>
</div>
</nav>