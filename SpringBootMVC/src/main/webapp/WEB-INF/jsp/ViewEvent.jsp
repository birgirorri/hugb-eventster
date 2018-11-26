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
				<p>${eventObj.getGroupID()}</p>
				<img src="https://notendur.hi.is/ajj10/myndir/${eventObj.getTag()}.jpg">
			</c:forEach>
	</c:when>
	
	<c:otherwise>
		<h3>Úps villa!</h3>
	</c:otherwise>
</c:choose>


<div border="1px black">
	<sf:form method="POST" modelAttribute="userInfo" action="/addmemberToGoing">
	<label> Add Member to going:
	
		<label>Username:
		<input type=text path="userName" name="userName">
		</label>
		
		<label>Email:
		<input type=text path="email" name="email">
		</label>
		
	</label>
	
		
		<input type="submit" value="edit">

	</sf:form>
</div>


<c:choose>
        <%--If the model has an attribute with the name `postitNotes`--%>
        <c:when test="${not empty usersGoing}">
            <%--Create a table for the Postit Notes--%>
            <table class="users" border="1px gray">

                <%--For each postit note, that is in the list that was passed in the model--%>
                <%--generate a row in the table--%>
                <%--Here we set `postit` as a singular item out of the list `postitNotes`--%>
                <c:forEach var="userObj" items="${usersGoing}">
                    <tr>
                        <%--We can reference attributes of the Entity by just entering the name we gave--%>
                        <%--it in the singular item var, and then just a dot followed by the attribute name--%>

                        <%--Create a link based on the name attribute value--%>
                        <td><a href="/user/${userObj.getUserID()}">${userObj.username}</a></td>
                        <%--The String in the note attribute--%>
                        <td>${userObj.email}</td>
           
                       
                    </tr>
                </c:forEach>
            </table>
        </c:when>

        <%--If all tests are false, then do this--%>
        <c:otherwise>
            <h3>None going!</h3>
        </c:otherwise>
    </c:choose>
    
    <button><a href="/attend">Attend this event</a> </button>
    
    <label>Sætisfjöldi: </label>
    <c:choose>
	<c:when test="${not empty currentEvent}">
			<c:forEach var="eventObj" items="${currentEvent}">
				<p>${eventObj.getGoing().size()}/${eventObj.getEventSeats()}</p>
			</c:forEach>
	</c:when>
	
	<c:otherwise>
		<h3>Úps villa!</h3>
	</c:otherwise>
</c:choose>
    

</div>

</body>

</html>