<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<html lang="en">

    <head>
        <title>Group page</title>
    </head>
    <body>

    <h1>Group page</h1>
    <p>Here could be some user information</p>

    
    <sf:form method="POST" modelAttribute="user" action="/addMember">
    <h2>add member</h2>
    <label>username:
    <input type="text" path="username" name = "username">
    </label>
    
     <label>password:
    <input type="text" path="password" name = "password">
    </label>
    
     <label>email:
    <input type="text" path="email" name="email">
    </label>
    
     
    
     <input type="submit" VALUE="add member"/>
    </sf:form>
    
    
    <sf:form method="POST" modelAttribute="user" action="/findUser">
    
    <label>find user:
    <input type=text path="username" name = "username">
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
                        <td>${userObj.username}</td>
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
    
    
    
    </body>

</html>