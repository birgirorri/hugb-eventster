<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<html lang="en">

<head>
<link rel="stylesheet" type="text/css"
	href="<c:url value="/css/Events.css"/>" />
<title>Events Page</title>
</head>
<body>


<div class="user__view">
<c:choose>
	<c:when test="${not empty currentUser}">
			<c:forEach var="userObj" items="${currentUser}">
				<h1>${userObj.getUsername()}</h1>
				<p>Email: ${userObj.getEmail()}</p>
			</c:forEach>
	</c:when>
	
	<c:otherwise>
		<h3>Úps villa!</h3>
	</c:otherwise>
</c:choose>

</div>

</body>

</html>