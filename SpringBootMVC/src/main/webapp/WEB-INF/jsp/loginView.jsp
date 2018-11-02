<!doctype html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
</head>

<body>

<p>this is login</p>

<sf:form action="/login" method="GET">

<label>
Email:
<input type="text" path="email" placeholder="username here" name="email"> 
</label>

<label>
password:
<input type="text" path="password" placeholder="password here" name="password">
</label>

<a href="/login">
<input type="submit" VALUE="login">
</a>

</sf:form>

</body>
</html>