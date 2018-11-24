<!doctype html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<html lang="en">
<head>
<link rel="stylesheet" type="text/css"
	href="<c:url value="/css/login.css"/>" />
</head>

<head>

    <meta charset="utf-8">
    <title>Eventster!</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/login.css"/>" />
</head>

<body>
	<header>
      <div class = "protection">
        <div class="headText">
          <h1>Eventster</h1>
          <h2>M�gulega besta vefs��a � heimi</h2>
        </div>
      </div>
    </header>
	<div class="container">
		<div class="login">
			<h2>Login to your account</h2>

			<sf:form method="GET"  action="/Login">
				<div class="column">
				
				
					<label> Email: <input type="text" path="email"
						placeholder="email here" name="email">
					</label> <label> Password: <input type="text" path="password"
						placeholder="password here" name="password">
						
					</label> <a > <input type="submit" VALUE="Login">
					</a>
				</div>
			</sf:form>
		</div>


		<div class="signUp">
			<h2>Dont have an account? Sign up here</h2>
			<sf:form method="POST" action="/signUp" >
				<div class="column">
					<label> Email: <input type="text" path="email"
						placeholder="email here" name="email">
					</label> <label> Username: <input type="text" path="username"
						placeholder="username here" name="username">
					</label> <label> Password: <input type="text" path="password"
						placeholder="password here" name="password">
					</label> <label> Retype password: <input type="text"
						path="password1" placeholder="password here" name="password1">
					</label> <a> <input type="submit" VALUE="Sign up">
					</a>

				</div>
			</sf:form>
		</div>
	</div>

	

	<ul>
		<li><a href="/postit">Click here for Persistence Layer Demo</a></li>
		<li><a href="/user">User</a></li>
		<li><a href="/myPage">My Page</a></li>
		<li><a href="/Group">Group page</a></li>
		<li><a href="/Events">Events page</a></li>
		<li><a href="/createEvent">Create Event</a></li>
		<li><a href="/ViewEvent">Event Information</a></li>


	</ul>
	
	<a href="/GuestUser" class="buttonGuest">Sign in as guest</a>
	
	<a href="/LoadUser" class="button">preload</a>
</body>
</html>