<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<nav class="navbar navbar-default">
<div class="container-fluid">
<c:choose>
<c:when test="${not empty userid or not empty cookie.userid.value}">
	<ul class="nav navbar-nav navbar-left">
	 	<li role="presentation"><a href="logout">Logout</a></li>
	 	<li role="presentation"><a href="data">View Items</a></li>
	 	<li role="presentation"><a href="create.jsp">Create Item</a></li>
 	</ul>
 	<c:choose>
 	<c:when test="${not empty username}">
 		<p class="navbar-text navbar-right">Signed in as ${username}  </p>
	</c:when>
	<c:otherwise>
		<p class="navbar-text navbar-right">Signed in as ${cookie.username.value}  </p>
	</c:otherwise>
	</c:choose>
</c:when>
<c:otherwise>
<ul class="nav navbar-nav">
	<li role="presentation"><a href="login.jsp">Login</a></li>
</ul>
</c:otherwise>
</c:choose>
</div>
</nav>