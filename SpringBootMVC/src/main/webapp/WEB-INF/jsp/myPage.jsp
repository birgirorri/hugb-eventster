<!DOCTYPE html>


<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<html>

    <head>
    <link rel="stylesheet" type="text/css"
	href="<c:url value="/css/myPage.css"/>" />
<link rel="stylesheet" type="text/css"
	href="<c:url value="/css/Header.css"/>" />
        <title>My Page</title>
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
                    <li><a href="/user">Users</a> </li>
                    <li><a href="/Group">Groups</a></li>
                    <li><a class = "pages_selected" href="/myPage">My Page</a></li>
                </ul>
            </div>
        </div>
    </header>

    <p>Evenster er best</p>
	
    </body>
    <footer>Class HBV501G, University of Iceland</footer>
</html>