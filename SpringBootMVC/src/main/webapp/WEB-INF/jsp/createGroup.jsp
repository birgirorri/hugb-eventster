<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<html lang="en">

    <head>
        <link rel="stylesheet" type="text/css"
	href="<c:url value="/css/Group.css"/>" />
        <title>Create a group</title>
    </head>
    <body>

    <h1>Create a group</h1>
    
    <p>Fill out all the information about your group</p>
    
    <sf:form method="POST" modelAttribute="groups" action="/addGroup">
    <h2>create group</h2>
    <label>Group name
    <input type="text" path="groupName" name = "groupName">
    </label>
    
     <label>about group
    <input type="text" path="groupInfo" name = "groupInfo">
    </label>
   
     <input type="submit" VALUE="create Group"/>
    </sf:form>
    
    
     <sf:form method="POST" modelAttribute="user" action="/CreateGroup_findUser">
    
    	<label>find user by username:
    		<input type=text path="username" name = "username">
   		</label>
   		<input type="submit" value="search!">
    </sf:form>
    
    <sf:form method="POST" modelAttribute="user" action="/CreateGroup_showAllUsers">
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
                        <td><a href="/user/${userObj.getUserID()}">${userObj.username}</a></td>
                        <%--The String in the note attribute--%>
                        <td>${userObj.password}</td>
                        <td>${userObj.email}</td>
                        <td><a href="/addMember/${userObj.email}">add to group</a></td>
                       
                    </tr>
                </c:forEach>
            </table>
        </c:when>

        <%--If all tests are false, then do this--%>
        <c:otherwise>
            <h3>No users!</h3>
        </c:otherwise>
    </c:choose>
    
    <ul>
		<li><a href="/Group">Back</a></li>
	</ul>
    
    
    </body>

</html>