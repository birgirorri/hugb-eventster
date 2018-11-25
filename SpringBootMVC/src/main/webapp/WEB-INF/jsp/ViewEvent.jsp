<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<html lang="is">

<head>
<link rel="stylesheet" type="text/css"
	href="<c:url value="/css/Events.css"/>" />
	<link rel="stylesheet" type="text/css"
	href="<c:url value="/css/Header.css"/>" />
<title>Events Page</title>
</head>
<body>
<header>
		<div class="header_grid">
			<div class="header_title">
				<h1>Eventster</h1>
			</div>
			<div class="header_pages">
				<ul>
					<li><a href="/Events">Events</a></li>
					<li><a href="/user">Users</a></li>
					<li><a href="/Group">Groups</a></li>
					<li><a href="/myPage">My Page</a></li>
				</ul>
				<button class="btn"> <a href="/signOut">Log Out</a> </button>
			</div>
		</div>
	</header>

<div class="event__view">
<c:choose>
	<c:when test="${not empty currentEvent}">
			<c:forEach var="eventObj" items="${currentEvent}">
				<h1>${eventObj.getEventName()}</h1>
				<p>${eventObj.getEventInfo()}</p>
			</c:forEach>
	</c:when>
	
	<c:otherwise>
		<h3>Úps villa!</h3>
	</c:otherwise>
</c:choose>

</div>

</body>

</html>