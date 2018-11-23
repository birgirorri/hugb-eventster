<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<html lang="en">

    <head>
    <link rel="stylesheet" type="text/css"
	href="<c:url value="/css/Events.css"/>" />
        <title>Create an event</title>
    </head>
    <body>

    <h1>Create an event</h1>
    <p>Fill out all the information about your event</p>

    
    <sf:form method="POST" modelAttribute="event" action="/addEvent">
    
    <label>Name of event:
    <input type="text" path="eventName" name = "eventName">
    </label>
    
     <label>Info of event:
    <input type="text" path="eventInfo" name = "eventInfo">
    </label>
    
     <label>Group:
    <input type="text" path="groupID" name="groupID">
    </label>
    
    <label>tags:
    <input type="text" path="eventTags" name="eventTags">
    </label>
    
    
     <input type="submit" VALUE="Create Event"/>
    </sf:form>
    
    <ul>
		<li><a href="/Events">Back</a></li>
	</ul>
    
    </body>

</html>