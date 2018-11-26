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
					<li><a href="/showAllEvents">Events</a></li>
					<li><a href="/user">Users</a></li>
					<li><a class="pages_selected" href="/showAllGroups">Groups</a></li>
					<li><a href="/myPage">My Page</a></li>
				</ul>
				<button class="btn"> <a href="/signOut">Log Out</a> </button>
			</div>
		</div>
	</header>
    <main>
    
    <div class="top_container">
    
    <a href="/showAllGroups">
		<button>Show all</button>
	</a>
	
	<div class="search_container">
	<sf:form method="POST" modelAttribute="event" action="/findEvent">
		<input type=text placeholder="Group Name" name="groupName">
		<button type="submit">search!</button>
	</sf:form> 
	</div>
	
	<a href="/createGroup">
		<button>Create Group</button>
	</a>
	
    </div>
    
    
       <c:choose>
        <%--If the model has an attribute with the name `postitNotes`--%>
        <c:when test="${not empty groupsList}">
        
        	<div class="groups">

				<%--For each postit note, that is in the list that was passed in the model--%>
				<%--generate a row in the table--%>
				<%--Here we set `postit` as a singular item out of the list `postitNotes`--%>
				<c:forEach var="groupObj" items="${groupsList}">
					<a href="/group/${groupObj.getGroupID()}">
						<div class="card">

							<%--We can reference attributes of the Entity by just entering the name we gave--%>
							<%--it in the singular item var, and then just a dot followed by the attribute name--%>

							<%--Create a link based on the name attribute value--%>
							<h1>${groupObj.getGroupName()}</h1>
							<%--The String in the note attribute--%>
							<p>${groupObj.getGroupInfo()}</p>
						</div>
					</a>
				</c:forEach>
			</div>
            <%--Create a table for the Postit Notes--%>
        </c:when>
    </c:choose>
    
    </main>
    </body>

</html>