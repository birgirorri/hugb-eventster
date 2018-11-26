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
				<button class="btn">
					<a href="/signOut">Log Out</a>
				</button>
			</div>
		</div>
	</header>
	<main>
	<div class="top_container">

	<sf:form method="POST" modelAttribute="event" action="/showAllEvents">
		<button type="submit">Show all</button>
	</sf:form> 
	<div class="search_container">
	<sf:form method="POST" modelAttribute="event" action="/findEvent">
		<input type=text placeholder="Name" name="eventName">
		<input type=text placeholder="Date" name="eventName">
		<input type=text placeholder="Category" name="eventName">
		<button type="submit">search!</button>
	</sf:form> 
	</div>

	<button>
		<a href="/createEvent">Create an event</a> 	
	</button>
	</div>
	
	<c:choose>
		<%--If the model has an attribute with the name `postitNotes`--%>
		<c:when test="${not empty eventList}">
			<%--Create a table for the Postit Notes--%>
			<div class="events" border="1px gray">

				<%--For each postit note, that is in the list that was passed in the model--%>
				<%--generate a row in the table--%>
				<%--Here we set `postit` as a singular item out of the list `postitNotes`--%>
				<c:forEach var="eventObj" items="${eventList}">
					<a href="/event/${eventObj.getEventID()}">
						<div class="card">
							<div class="img_container">
								<img
									src="https://notendur.hi.is/ajj10/myndir/${eventObj.getTag()}.jpg">
							</div>

							<%--We can reference attributes of the Entity by just entering the name we gave--%>
							<%--it in the singular item var, and then just a dot followed by the attribute name--%>

							<%--Create a link based on the name attribute value--%>
							<h1>${eventObj.getEventName()}</h1>
							<%--The String in the note attribute--%>
							<div class="time-container">
								<p>From: ${eventObj.getStartDate()}</p>
								<p>To: ${eventObj.getEndDate()}</p>
							</div>
							<p>Location: ${eventObj.getLocation()}</p>
						</div>
					</a>
				</c:forEach>
			</div>
		</c:when>

		<%--If all tests are false, then do this--%>
		<c:otherwise>
			<h3>No events!</h3>
		</c:otherwise>
	</c:choose> <a href="/LoadEvent" class="button1">preload</a> </main>
</body>

</html>