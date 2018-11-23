<!DOCTYPE html>


<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<html>

<head>
<link rel="stylesheet" type="text/css"
	href="<c:url value="/css/myPage.css"/>" />
<link rel="stylesheet" type="text/css"
	href="<c:url value="/css/Header.css"/>" />
<title>My Page</title>
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
					<li><a class="pages_selected" href="/myPage">My Page</a></li>
				</ul>
			</div>
		</div>
	</header>
	<main>

	<div class="myPage_container">
		<div class="myPage_column">
			<sf:form method="POST" modelAttribute="event" action="/findEvent">

				<label>find event: <input type=text path="eventName"
					name="eventName">
				</label>
				<input type="submit" value="search!">

			</sf:form>

			<sf:form method="POST" modelAttribute="event" action="/showAllEvents">
				<input type="submit" value="show all">
			</sf:form>

			<c:choose>
				<%--If the model has an attribute with the name `postitNotes`--%>
				<c:when test="${not empty eventListUser}">
					<%--Create a table for the Postit Notes--%>
					<table class="users" border="1px gray">

						<%--For each postit note, that is in the list that was passed in the model--%>
						<%--generate a row in the table--%>
						<%--Here we set `postit` as a singular item out of the list `postitNotes`--%>
						<c:forEach var="eventObj" items="${eventListUser}">
							<tr>
								<%--We can reference attributes of the Entity by just entering the name we gave--%>
								<%--it in the singular item var, and then just a dot followed by the attribute name--%>

								<%--Create a link based on the name attribute value--%>
								<td><a href="/myPage/${eventObj.getEventID()}">${eventObj.getEventName()}</a></td>
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
			</c:choose>
		</div>


		<div class="myPage_column">

			<sf:form method="POST" modelAttribute="groups" action="/findGroups">

				<label>find group: <input type=text path="groupName"
					name="groupName">
				</label>
				<input type="submit" value="search!">

			</sf:form>

			<sf:form method="POST" modelAttribute="groups"
				action="/showAllGroups">
				<input type="submit" value="show all">
			</sf:form>

			<c:choose>
				<%--If the model has an attribute with the name `postitNotes`--%>
				<c:when test="${not empty groupsList}">
					<%--Create a table for the Postit Notes--%>
					<table class="users" border="1px gray">

						<%--For each postit note, that is in the list that was passed in the model--%>
						<%--generate a row in the table--%>
						<%--Here we set `postit` as a singular item out of the list `postitNotes`--%>
						<c:forEach var="groupObj" items="${groupsList}">
							<tr>
								<%--We can reference attributes of the Entity by just entering the name we gave--%>
								<%--it in the singular item var, and then just a dot followed by the attribute name--%>

								<%--Create a link based on the name attribute value--%>
								<td><a href="/group/${groupObj.getGroupID()}">${groupObj.getGroupName()}</a></td>
								<%--The String in the note attribute--%>
								<td>${groupObj.getGroupInfo()}</td>


							</tr>
						</c:forEach>
					</table>
				</c:when>

				<%--If all tests are false, then do this--%>
				<c:otherwise>
					<h3>No users!</h3>
				</c:otherwise>
			</c:choose>
		</div>
	</div>
	</main>
</body>
<footer>Class HBV501G, University of Iceland</footer>
</html>