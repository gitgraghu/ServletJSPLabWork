<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<ul>
<c:choose>
<c:when test="${not empty cookie.userid.value}">
    <li><a href="logout">Logout</a></li>
    <li><a href="data">View Items</a></li>
     <li><a href="create.jsp">Create Item</a></li>
</c:when>
<c:otherwise>
	<li><a href="login.jsp">Login</a></li>
</c:otherwise>
</c:choose>
</ul>