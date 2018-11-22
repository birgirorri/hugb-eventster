<!doctype html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="en">
<head>
<link rel="stylesheet" type="text/css"
	href="<c:url value="/css/login.css"/>" />
</head>

<body>

	<h1>Halló heimur, þetta er Eventster</h1>

	<div class="container">
		<div class="login">
			<h2>Login to your account</h2>

			<sf:form action="/login" method="GET">
				<div class="column">

					<label> Email: <input type="email" path="email"
						placeholder="email here" name="email">
					</label> <label> password: <input type="text" path="password"
						placeholder="password here" name="password">
					</label> <a href="/login"> <input type="submit" VALUE="login">
					</a>
				</div>
		</div>
		</sf:form>



		<div class="signUp">
			<h2>Dont have an account? Sign up here</h2>
			<sf:form action="/signUp" method="GET">
				<div class="column">
					<label> Email: <input type="email" path="email"
						placeholder="email here" name="email">
					</label> <label> Username: <input type="text" path="username"
						placeholder="username here" name="username">
					</label> <label> password: <input type="password" path="password"
						placeholder="password here" name="password">
					</label> <label> retype password: <input type="password"
						path="password" placeholder="password here" name="password">
					</label> <a href="/login"> <input type="submit" VALUE="Sign up">
					</a>

				</div>
		</div>
	</div>

	</sf:form>

	<ul>
		<li><a href="/postit">Click here for Persistence Layer Demo</a></li>
		<li><a href="/user">user</a></li>
		<li><a href="/myPage">My Page</a></li>
		<li><a href="/Group">Group page</a></li>
		<li><a href="/Events">Events page</a></li>


	</ul>



</body>
</html>