<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<html lang="en">

<head>
<link rel="stylesheet" type="text/css"
	href="<c:url value="/css/Events.css"/>" />
<title>Events Page</title>
</head>
<body>


<div class="group__view">
<c:choose>
	<c:when test="${not empty currentGroup}">
			<c:forEach var="groupObj" items="${currentGroup}">
				<h1>${groupObj.getGroupName()}</h1>
				<p>${groupObj.getGroupInfo()}</p>
			</c:forEach>
	</c:when>
	
	<c:otherwise>
		<h3>Úps villa!</h3>
	</c:otherwise>
</c:choose>

<div border="1px black">
	<sf:form method="POST" modelAttribute="userInfo" action="/addmember">
	<label> Add Member:
	
		<label>Username:
		<input type=text path="userName" name="userName">
		</label>
		
		<label>Email:
		<input type=text path="email" name="email">
		</label>
		
	</label>
	
		
		<input type="submit" value="edit">

	</sf:form>
</div>

       <c:choose>
        <%--If the model has an attribute with the name `postitNotes`--%>
        <c:when test="${not empty membersOfgroup}">
            <%--Create a table for the Postit Notes--%>
            <table class="users" border="1px gray">

                <%--For each postit note, that is in the list that was passed in the model--%>
                <%--generate a row in the table--%>
                <%--Here we set `postit` as a singular item out of the list `postitNotes`--%>
                <c:forEach var="userObj" items="${membersOfgroup}">
                    <tr>
                        <%--We can reference attributes of the Entity by just entering the name we gave--%>
                        <%--it in the singular item var, and then just a dot followed by the attribute name--%>

                        <%--Create a link based on the name attribute value--%>
                        <td><a href="/user/${userObj.getUserID()}">${userObj.username}</a></td>
                        <%--The String in the note attribute--%>
                        <td>${userObj.password}</td>
                        <td>${userObj.email}</td>
                       
                    </tr>
                </c:forEach>
            </table>
        </c:when>

        <%--If all tests are false, then do this--%>
        <c:otherwise>
            <h3>No members!</h3>
        </c:otherwise>
    </c:choose>
    
    
    
    <sf:form method="POST" modelAttribute="user" action="/findUserToAdd">
    
    	<label>find user by username:
    		<input type=text path="username" name = "username">
   		</label>
   		<input type="submit" value="search!">
    </sf:form>
    
    <sf:form method="POST" modelAttribute="user" action="/showUsersToAdd">
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

</div>

</body>

</html>