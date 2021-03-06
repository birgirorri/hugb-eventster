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
						<input type="password" path="password" placeholder="Password" name="password">
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
							<input type="password" path="password" placeholder="Password" name="password">
							<input type="password" path="password1" placeholder="Retype password" name="password1">
						</div>
						<button type="submit">Sign up</button>
					</div>
				</sf:form>
				<c:if test="${not empty errorMsg1}"><div style="color:red; font-weight: bold; margin: 30px 0px;">${errorMsg1}</div></c:if>
			</div>
		</div>
	</main>

</body>
</html>