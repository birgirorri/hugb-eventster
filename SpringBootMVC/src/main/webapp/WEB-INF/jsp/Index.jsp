<!doctype html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<html lang="en">
<head>
<link rel="stylesheet" type="text/css"
	href="<c:url value="/css/login.css"/>" />
</head>

<head>

<meta charset="utf-8">
<title>Eventster!</title>
<link rel="stylesheet" type="text/css"
	href="<c:url value="/css/login.css"/>" />
</head>

<body>
	<header>
		<div class="headText">
			<h1 class="headtext">Eventster</h1>
			<h2 class="headtext">M�gulega besta vefs��a � heimi</h2>
		</div>
	</header>
	<main>
		<div class="container">
			<div class="row">
				<div class="columnheader">
					<h2>Login to your account or as guest</h2>
				</div>	

				<sf:form method="GET" action="/Login">
					<div class="column">
						<input type="text" path="email" placeholder="Email" name="email">
						<input type="text" path="password" placeholder="Password" name="password">
						<button type="submit">Login</button>
					</div>
				</sf:form>
				<form class = "guest" action="/GuestUser">
    				<button type="submit">Login as Guest</button>
				</form>
				<c:if test="${not empty errorMsg}"><div style="color:red; font-weight: bold; margin: 30px 0px;">${errorMsg}</div></c:if>
			</div>


			<div class="row">
				<div class="columnheader">
					<h2> Create an account</h2>
				</div>

				<sf:form method="POST" action="/signUp">
					<div class="column">
						<input type="text" path="email" placeholder="Email" name="email">
						<input type="text" path="username" placeholder="Username" name="username">
						<div class="passwords">
							<input type="text" path="password" placeholder="Password" name="password">
							<input type="text"path="password1" placeholder="Password" name="password1">
						</div>
						<button type="submit">Sign up</button>
					</div>
				</sf:form>
				<c:if test="${not empty errorMsg}"><div style="color:red; font-weight: bold; margin: 30px 0px;">${errorMsg}</div></c:if>
			</div>
		</div>
	</main>



	<ul>
		<li><a href="/postit">Click here for Persistence Layer Demo</a></li>
		<li><a href="/user">User</a></li>
		<li><a href="/myPage">My Page</a></li>
		<li><a href="/Group">Group page</a></li>
		<li><a href="/Events">Events page</a></li>
		<li><a href="/createEvent">Create Event</a></li>
		<li><a href="/ViewEvent">Event Information</a></li>
	</ul>

	<a href="/LoadUser" class="button">preload</a>
</body>
</html>