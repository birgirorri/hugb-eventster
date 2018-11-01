<!doctype html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
</head>

<body>

<p>this is login</p>

<sf:form>




<label>
Username:
<input type="text" path="username" placeholder="username here"> 
</label>



<label>
password:
<input type="text" path="password" placeholder="password here">
</label>

<a href="/user">
<input type="submit" VALUE="login">
</a>



</sf:form>

</body>
</html>