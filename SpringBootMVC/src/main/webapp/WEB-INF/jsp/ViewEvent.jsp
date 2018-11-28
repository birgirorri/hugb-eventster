<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<html lang="is">

<head>
<link rel="stylesheet" type="text/css"
	href="<c:url value="/css/viewEvent.css"/>" />
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
					<li><a href="/showAllEvents">Events</a></li>
					<li><a href="/user">Users</a></li>
					<li><a href="/showAllGroups">Groups</a></li>
					<li><a href="/myPage">My Page</a></li>
				</ul>
				<button class="btn"> <a href="/signOut">Log Out</a> </button>
			</div>
		</div>
	</header>

<div class="cards">
<div class="card">
	<div class="card_title">
	<c:choose>
	<c:when test="${not empty currentEvent}">
			<c:forEach var="eventObj" items="${currentEvent}">
				<h1>${eventObj.getEventName()}</h1>
			</c:forEach>
	</c:when>
	</c:choose>
	</div>
	<c:choose>
	<c:when test="${not empty currentEvent}">
			<c:forEach var="eventObj" items="${currentEvent}">
				<p>${eventObj.getEventInfo()}</p>
				<img src="https://notendur.hi.is/ajj10/myndir/${eventObj.getTag()}.jpg">
			</c:forEach>
	</c:when>
	</c:choose>
	<a href="/attend">
	<button>Attend this event</button>
	</a>
<div>
	<sf:form method="POST" modelAttribute="userInfo" action="/addmemberToGoing">
	<label> Add Member to event:</label>
	<div>
		<input type=text path="email" name="email" placeholder = "email">
		
		<button type="submit">Add member</button>
	</div>
	</sf:form>
</div>
</div>

<div class="card">
<div><h1>Going</h1></div>
<c:choose>
	<c:when test="${not empty currentEvent}">
			<c:forEach var="eventObj" items="${currentEvent}">
				  <label>Sætisfjöldi: <p>${eventObj.getGoing().size()}/${eventObj.getEventSeats()}</p></label>
			</c:forEach>
	</c:when>
	</c:choose>
	<c:choose>
        <%--If the model has an attribute with the name `postitNotes`--%>
        <c:when test="${not empty usersGoing}">
            <%--Create a table for the Postit Notes--%>
            <div class="users" border="1px gray">

                <%--For each postit note, that is in the list that was passed in the model--%>
                <%--generate a row in the table--%>
                <%--Here we set `postit` as a singular item out of the list `postitNotes`--%>
                <c:forEach var="userObj" items="${usersGoing}">
                <a href="/user/${userObj.getUserID()}">
                    <div class=user_row>
                        <%--We can reference attributes of the Entity by just entering the name we gave--%>
                        <%--it in the singular item var, and then just a dot followed by the attribute name--%>

                        <%--Create a link based on the name attribute value--%>
                        <p>${userObj.username}</p>
                        <%--The String in the note attribute--%>
                       
                    </div>
                </a>
                </c:forEach>
            </div>
        </c:when>

        <%--If all tests are false, then do this--%>
        <c:otherwise>
            <h3>None going!</h3>
        </c:otherwise>
    </c:choose>
</div>
    </div>


</body>

</html>