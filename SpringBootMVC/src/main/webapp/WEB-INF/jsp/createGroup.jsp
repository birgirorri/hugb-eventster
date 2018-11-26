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
<title>Create a group</title>
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
	<main>
	<div class="container">
		<h1>Create a group</h1>

		<p>Fill out all the information about your group</p>

		<sf:form method="POST" modelAttribute="groups" action="/addGroup">

			<div class="groupCreate">
				<input type="text" placeholder="Group Name" name="groupName">

				<select path="groupVisable" name="groupVisable">
					<option value="private">Private</option>
					<option value="public">Public</option>
				</select>

			</div>
			<label>About group:</label>
			<textarea rows="10" cols="20" placeholder="Info about the group..."
				name="groupInfo"></textarea>




			<button type="submit">create Group</button>
		</sf:form>

	</div>
	</main>
</body>

</html>