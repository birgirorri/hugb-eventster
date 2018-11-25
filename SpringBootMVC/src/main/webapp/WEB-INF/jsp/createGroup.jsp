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
        <title>Create a group</title>
    </head>
    <body>
<header>
		<div class="header_grid">
			<div class="header_title">
				<h1>Eventster</h1>
			</div>
			<div class="header_pages">
				<ul>
					<li><a href="/Events">Events</a></li>
					<li><a href="/user">Users</a></li>
					<li><a href="/Group">Groups</a></li>
					<li><a href="/myPage">My Page</a></li>
				</ul>
				<button class="btn"> <a href="/signOut">Log Out</a> </button>
			</div>
		</div>
	</header>
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
    
    <select path="groupVisable" name="groupVisable">
    <option value="private">Private</option>
    <option value="public">Public</option>
    </select>
    
   
     <input type="submit" VALUE="create Group"/>
    </sf:form>
    
    
     
    
    <ul>
		<li><a href="/Group">Back</a></li>
	</ul>
    
    
    </body>

</html>