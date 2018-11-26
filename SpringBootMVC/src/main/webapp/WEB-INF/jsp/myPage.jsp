<!DOCTYPE html>


<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<html lang="is">

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
					<li><a href="/showAllEvents">Events</a></li>
					<li><a href="/user">Users</a></li>
					<li><a href="/showAllGroups">Groups</a></li>
					<li><a class="pages_selected" href="/myPage">My Page</a></li>
				</ul>
				<button class="btn"> <a href="/signOut">Log Out</a> </button>
			</div>
		</div>
	</header>
	<main>
	<div class="cards">
	<div class="userRow">
	<div class= "userCard">
	<c:choose>
	<c:when test="${not empty currentSession}">
			<c:forEach var="userObj" items="${currentSession}">
				<h1>${userObj.getUsername()}</h1>
			</c:forEach>
	</c:when>
	</c:choose>
	<div class="column">
	<c:choose>
	<c:when test="${not empty currentSession}">
			<c:forEach var="userObj" items="${currentSession}">
				<p>Email:  ${userObj.getEmail()}</p>
				<p>Birthday:  ${userObj.getBirthday()}</p>
				<p>Phone nr:  ${userObj.getPhone()}</p>
				<p>Zodiac:  ${userObj.getZodiac()}</p>
			</c:forEach>
	</c:when>
	</c:choose>
	</div>
	</div>
	
	
	<div class= "userCard">
		<h1>Edit</h1>
	<div class="column">
	<sf:form method="POST" modelAttribute="userInfo" action="/changeUserInfo" border="1px gray">
	<div class="column">
		<label>Birthday:
		<input type=text path="birthday" name="birthday">
		</label>
		
		<label>phone number:
		<input type=text path="phone" name="phone">
		</label>
		
		<label>Zodiac:
		<select path="zodiac" name="zodiac">
			<option>Not Registered</option>
			<option>Aquarius</option>
			<option>Pisces</option>
			<option>Aries</option>
			<option>Taurus</option>
			<option>Gemini</option>
			<option>Cancer</option>
			<option>Leo</option>
			<option>Virgo</option>
			<option>Libra</option>
			<option>Scorpio</option>
			<option>Sagittarius</option>
			<option>Capricorn</option>
			
		</select>
		</label>
		
		<button type="submit">Confirm</button>
	</div>
	</sf:form>
	</div>
	</div>
	</div>
	<div class="userRow">
		<div class="userCard">
			<sf:form method="POST" modelAttribute="event" action="/findEventsImIn">
				<input type=text path="eventName"
					name="eventName">
				<button type="submit">Search Events</button>

			</sf:form>

			<sf:form method="POST" modelAttribute="event" action="/showGoingEvents">
				<button type="submit">Show All</button>
			</sf:form>
			
			<c:choose>
				<%--If the model has an attribute with the name `postitNotes`--%>
				<c:when test="${not empty eventListUser}">
					<%--Create a table for the Postit Notes--%>
					<div class="users" border="1px gray">

						<%--For each postit note, that is in the list that was passed in the model--%>
						<%--generate a row in the table--%>
						<%--Here we set `postit` as a singular item out of the list `postitNotes`--%>
						<c:forEach var="eventObj" items="${eventListUser}">
						<a href="/event/${eventObj.getEventID()}">
							<div class = "user_row">
								<%--We can reference attributes of the Entity by just entering the name we gave--%>
								<%--it in the singular item var, and then just a dot followed by the attribute name--%>

								<%--Create a link based on the name attribute value--%>
								<p>${eventObj.getEventName()}</p>
							</div>
							</a>
						</c:forEach>
					</div>
				</c:when>

				<%--If all tests are false, then do this--%>
				<c:otherwise>
					<h3>No events!</h3>
				</c:otherwise>
			</c:choose>
		</div>


		<div class="userCard">

			<sf:form method="POST" modelAttribute="groups" action="/findGroupsImIn">
				<input type=text path="groupName"
					name="groupName">
				<button type="submit">Search Group</button>

			</sf:form>

			<sf:form method="POST" modelAttribute="groups"
				action="/showGroupsImIn">
				<button type="submit">Show All</button>
			</sf:form>

			<c:choose>
				<%--If the model has an attribute with the name `postitNotes`--%>
				<c:when test="${not empty groupsList}">
					<%--Create a table for the Postit Notes--%>
					<div class="users" border="1px gray">

						<%--For each postit note, that is in the list that was passed in the model--%>
						<%--generate a row in the table--%>
						<%--Here we set `postit` as a singular item out of the list `postitNotes`--%>
						<c:forEach var="groupObj" items="${groupsList}">
						<a href="/group/${groupObj.getGroupID()}">
							<div class="user_row">
								<%--We can reference attributes of the Entity by just entering the name we gave--%>
								<%--it in the singular item var, and then just a dot followed by the attribute name--%>

								<%--Create a link based on the name attribute value--%>
								<p>${groupObj.getGroupName()}</p>
							</div>
						</a>
						</c:forEach>
					</div>
				</c:when>

				<%--If all tests are false, then do this--%>
				<c:otherwise>
					<h3>No Groups!</h3>
				</c:otherwise>
			</c:choose>
		</div>
		</div>
	</div>
	</main>
</body>
</html>