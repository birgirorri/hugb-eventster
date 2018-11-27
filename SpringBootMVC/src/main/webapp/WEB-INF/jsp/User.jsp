<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<html lang="en">

<head>
<link rel="stylesheet" type="text/css"
	href="<c:url value="/css/User.css"/>" />
<link rel="stylesheet" type="text/css"
	href="<c:url value="/css/Header.css"/>" />
<title>User Page</title>
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
					<li><a class="pages_selected" href="/user">Users</a></li>
					<li><a href="/showAllGroups">Groups</a></li>
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
		<sf:form method="POST" modelAttribute="user" action="/showAllUsers">
			<button type="submit">Show All</button>
		</sf:form>
		<sf:form method="POST" modelAttribute="user" action="/findUser">
			<div>
				<label>find user by username: <input type=text
					path="username" name="username">
				</label>
				<button type="submit">Search username</button>
			</div>
		</sf:form>
	<sf:form method="POST" modelAttribute="user" action="/findUserbyEmail">
		<div>
			<label>find user: <input type=text path="email" name="email">
			</label>
			<button type="submit">Search email</button>
		</div>

	</sf:form>
	</div>

	<c:choose>
		<%--If the model has an attribute with the name `postitNotes`--%>
		<c:when test="${not empty userList}">
			<%--Create a table for the Postit Notes--%>
			<div class="Users">

				<%--For each postit note, that is in the list that was passed in the model--%>
				<%--generate a row in the table--%>
				<%--Here we set `postit` as a singular item out of the list `postitNotes`--%>
				<c:forEach var="userObj" items="${userList}">
					<a href="/user/${userObj.getUserID()}">
						<div class="card">
							<div class="img_container">
								<img src="https://notendur.hi.is/ajj10/myndir/user.png">
							</div>
							<h1>${userObj.username}</h1>
							<p>${userObj.email}</p>
						</div>
					</a>
				</c:forEach>
			</div>

		</c:when>
		<c:otherwise>
					<h3>No Users!</h3>
				</c:otherwise>
	</c:choose> </main>
</body>

</html>