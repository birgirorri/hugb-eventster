<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<html lang="en">

    <head>
    <link rel="stylesheet" type="text/css"
	href="<c:url value="/css/Group.css"/>" />
<link rel="stylesheet" type="text/css"
	href="<c:url value="/css/Header.css"/>" />
        <title>Groups</title>
    </head>
    <body>
    <header>
		<div class="header_grid">
			<div class="header_title">
				<h1>Eventster</h1>
			</div>
			<div class="header_pages">
				<ul>
					<li><a class="pages_selected" href="/Events">Events</a></li>
					<li><a href="/user">Users</a></li>
					<li><a href="/Group">Groups</a></li>
					<li><a href="/myPage">My Page</a></li>
				</ul>
				<button class="btn"> <a href="/signOut">Log Out</a> </button>
			</div>
		</div>
	</header>
    <main>

    <p>Here could be some group information</p>
    
       <a href="/createGroup" class="button">Create a group</a>
        
    <sf:form method="POST" modelAttribute="groups" action="/findGroups">
    
    <label>find group:
    <input type=text path="groupName" name = "groupName">
    </label>
    <input type="submit" value="search!">
    
    </sf:form>
    
    <sf:form method="POST" modelAttribute="groups" action="/showAllGroups">
    <input type="submit" value="show all">
    </sf:form>
    
    
       <c:choose>
        <%--If the model has an attribute with the name `postitNotes`--%>
        <c:when test="${not empty groupsList}">
            <%--Create a table for the Postit Notes--%>
            <table class="users" border="1px gray">

                <%--For each postit note, that is in the list that was passed in the model--%>
                <%--generate a row in the table--%>
                <%--Here we set `postit` as a singular item out of the list `postitNotes`--%>
                <c:forEach var="groupObj" items="${groupsList}">
                    <tr>
                        <%--We can reference attributes of the Entity by just entering the name we gave--%>
                        <%--it in the singular item var, and then just a dot followed by the attribute name--%>

                        <%--Create a link based on the name attribute value--%>
                        <td> <a href="/group/${groupObj.getGroupID()}" >${groupObj.getGroupName()}</a></td>
                        <%--The String in the note attribute--%>
                        <td>${groupObj.getGroupInfo()}</td>
                        
                       
                    </tr>
                </c:forEach>
            </table>
        </c:when>

        <%--If all tests are false, then do this--%>
        <c:otherwise>
            <h3>No users!</h3>
        </c:otherwise>
    </c:choose>
    
    <a href="/LoadGroup" class="button1">preload</a>
    
    </main>
    </body>

</html>