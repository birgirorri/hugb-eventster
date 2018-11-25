<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

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
                <h1> Eventster</h1>
            </div>
            <div class="header_pages">
                <ul>
                    <li><a href="/Events">Events</a> </li>
                    <li><a class = "pages_selected" href="/user">Users</a> </li>
                    <li><a href="/Group">Groups</a></li>
                    <li><a href="/myPage">My Page</a></li>
                </ul>
                <button class="btn"> <a href="/signOut">Log Out</a> </button>
            </div>
        </div>
    </header>
	<main>
    <p>Here could be some user information</p>
    
    <sf:form method="POST" modelAttribute="user" action="/findUser">
    
    <label>find user by username:
    	<input type=text path="username" name = "username">
    </label>
    <input type="submit" value="search!">
    </sf:form>
    
    <sf:form method="POST" modelAttribute="user" action="/findUserbyEmail">
    
    <label>find user:
    <input type=text path="email" name = "email">
    </label>
    <input type="submit" value="search!">
    
    </sf:form>
    
    <sf:form method="POST" modelAttribute="user" action="/showAllUsers">
    <input type="submit" value="show all">
    </sf:form>
    
    
       <c:choose>
        <%--If the model has an attribute with the name `postitNotes`--%>
        <c:when test="${not empty userList}">
            <%--Create a table for the Postit Notes--%>
            <table class="users" border="1px gray">

                <%--For each postit note, that is in the list that was passed in the model--%>
                <%--generate a row in the table--%>
                <%--Here we set `postit` as a singular item out of the list `postitNotes`--%>
                <c:forEach var="userObj" items="${userList}">
                    <tr>
                        <%--We can reference attributes of the Entity by just entering the name we gave--%>
                        <%--it in the singular item var, and then just a dot followed by the attribute name--%>

                        <%--Create a link based on the name attribute value--%>
                        <td><a href="/user/${userObj.getUserID()}">${userObj.username}</td>
                        <%--The String in the note attribute--%>
                        <td>${userObj.password}</td>
                        <td>${userObj.email}</td>
                       
                    </tr>
                </c:forEach>
            </table>
        </c:when>

        <%--If all tests are false, then do this--%>
        <c:otherwise>
            <h3>No users!</h3>
        </c:otherwise>
    </c:choose>
    
    
    </main>
    </body>

</html>