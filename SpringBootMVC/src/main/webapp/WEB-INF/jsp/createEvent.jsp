<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<html lang="en">

<head>
<link rel="stylesheet" type="text/css"
	href="<c:url value="/css/createEvent.css"/>" />
<title>Create an event</title>
</head>
<body>

	<h1>Create an event</h1>
	<p>Fill out all the information about your event</p>


	<sf:form method="POST" modelAttribute="event" action="/addEvent">

		<label>Name of event: <input type="text" path="eventName"
			name="eventName">
		</label>

		<label>Info of event: <input type="text" path="eventInfo"
			name="eventInfo">
		</label>

		<div class="category">
			<label class="category_chooser"></label> <select
				class="catecory_select" field="*{size}" path="category">
				<option value="Category" disabled="disabled" selected="true">Category</option>
				<option value="bbq">BBQ</option>
				<option value="birthday">Birthday</option>
				<option value="dinnerParty">Dinner Party</option>
				<option value="gig">Gig/Show</option>
				<option value="graduation">Graduation</option>
				<option value="lan">LAN</option>
				<option value="party">Party</option>
				<option value="sports">Sports</option>
				<option value="studySession">Study Session</option>
				<option value="theatre">Theatre</option>
				<option value="wedding">Wedding</option>
			</select>
		</div>

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
							<option value="/group/${groupObj.getGroupID()}">${groupObj.getGroupName()}</option>
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