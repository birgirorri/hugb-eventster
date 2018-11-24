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
<title>Events</title>
</head>
<body>
	<header>
		<div class="header_grid">
			<div class="header_title">
				<h1>Eventster</h1>
			</div>
			<div class="header_pages">
				<ul>
					<li><a class="pages_selected" href="/Events">Events</a></li>
					<li><a href="/user">Users</a></li>
					<li><a href="/Group">Groups</a></li>
					<li><a href="/myPage">My Page</a></li>
				</ul>
			</div>
		</div>
	</header>
	<main>
	<p>Here could be some event information</p>

	<a href="/createEvent" class="button">Create an event</a> <sf:form
		method="POST" modelAttribute="event" action="/findEvent">

		<label>find event: <input type=text path="eventName"
			name="eventName">
		</label>
		<input type="submit" value="search!">

	</sf:form> <sf:form method="POST" modelAttribute="event" action="/showAllEvents">
		<input type="submit" value="show all">
	</sf:form> <c:choose>
		<%--If the model has an attribute with the name `postitNotes`--%>
		<c:when test="${not empty eventList}">
			<%--Create a table for the Postit Notes--%>
			<table class="users" border="1px gray">

				<%--For each postit note, that is in the list that was passed in the model--%>
				<%--generate a row in the table--%>
				<%--Here we set `postit` as a singular item out of the list `postitNotes`--%>
				<c:forEach var="eventObj" items="${eventList}">
					<tr>
						<%--We can reference attributes of the Entity by just entering the name we gave--%>
						<%--it in the singular item var, and then just a dot followed by the attribute name--%>

						<%--Create a link based on the name attribute value--%>
						<td><a href="/event/${eventObj.getEventID()}">${eventObj.getEventName()}</a></td>
						<%--The String in the note attribute--%>
						<td>${eventObj.getEventInfo()}</td>


					</tr>
				</c:forEach>
			</table>
		</c:when>

		<%--If all tests are false, then do this--%>
		<c:otherwise>
			<h3>No events!</h3>
		</c:otherwise>
	</c:choose> <a href="/LoadEvent" class="button1">preload</a> </main>
</body>

</html>