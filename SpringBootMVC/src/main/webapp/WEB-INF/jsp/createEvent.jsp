<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<html lang="en">

<head>
<link rel="stylesheet" type="text/css"
	href="<c:url value="/css/createEvent.css"/>" />
<link rel="stylesheet" type="text/css"
	href="<c:url value="/css/Header.css"/>" />
<title>Create an event</title>
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
				<button class="btn">
					<a href="/signOut">Log Out</a>
				</button>
			</div>
		</div>
	</header>
	<h1>Create an event</h1>
	<p>Fill out all the information about your event</p>


	<sf:form method="POST" modelAttribute="event" action="/addEvent">

		<input type="text" placeholder="Event Name" name="eventName">

		<label>Info of event: </label>
		<textarea rows="10" cols="20" placeholder="Info about the event..."
			name="eventInfo">
		</textarea>

		<input type="text" placeholder="Location" name="eventLocation">

		<div class="dateSelect">
			<input type="date" class="date_input" name="startDate" /> <input
				type="date" class="date_input" name="endDate" />
		</div>

		<select class="catecory_select" field="*{size}" path="category"
			name="category">
			<option value="Category" disabled="disabled" selected="true">Category</option>
			<option value="BBQ">BBQ</option>
			<option value="Birthday">Birthday</option>
			<option value="Concert">Concert</option>
			<option value="Dinner">Dinner Party</option>
			<option value="Gig/Show">Gig/Show</option>
			<option value="Graduation">Graduation</option>
			<option value="LAN">LAN</option>
			<option value="Party">Party</option>
			<option value="Sports">Sports</option>
			<option value="Study-session">Study-session</option>
			<option value="Theatre">Theatre</option>
			<option value="Wedding">Wedding</option>
		</select>

		<input type="text" placeholder="Maximum seats" name="maxSeats">



		<c:choose>
			<%--If the model has an attribute with the name `postitNotes`--%>
			<c:when test="${not empty groupsList}">
				<%--Create a table for the Postit Notes--%>
				<div class="groupSelect" border="1px gray">
					<label class="group_chooser" for="group"></label> <select
						class="group_select" field="*{size}">
						<option value="public" selected="true">Public Event</option>
						<%--For each postit note, that is in the list that was passed in the model--%>
						<%--generate a row in the table--%>
						<%--Here we set `postit` as a singular item out of the list `postitNotes`--%>
						<c:forEach var="groupObj" items="${groupsList}">

							<%--We can reference attributes of the Entity by just entering the name we gave--%>
							<%--it in the singular item var, and then just a dot followed by the attribute name--%>
							<%--Create a link based on the name attribute value--%>
							<option value="/group/${groupObj.getGroupID()}" name = "group">${groupObj.getGroupName()}</option>
						</c:forEach>
					</select>
				</div>
			</c:when>

			<%--If all tests are false, then do this--%>
			<c:otherwise>
				<div class="groupSelect" border="1px gray">
					<label class="group_chooser" for="group"></label> <select
						class="group_select" field="*{size}">
						<option value="public" selected="true">Public Event</option>
					</select>
				</div>
			</c:otherwise>
		</c:choose>


		<input type="submit" VALUE="Create Event" />
	</sf:form>


	<ul>
		<li><a href="/Events">Back</a></li>
	</ul>

</body>

</html>