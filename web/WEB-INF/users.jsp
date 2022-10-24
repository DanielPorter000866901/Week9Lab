<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manage Users</title>
    </head>
    <body>
        <h1>Manage Users</h1>
        <c:if test="${mess ne null}"><h2>Error</h2></c:if>
        <ul>
            <c:forEach items="${users}" var="user">
                <li>${user.email}, ${user.firstName}, ${user.lastName}, ${user.password}, ${user.role.roleName}</li>
            </c:forEach>
        </ul>
        
        <ul>
            <c:forEach items="${roles}" var="role">
                <li>${role.id}: ${role.roleName}</li>
            </c:forEach>
        </ul>
    </body>
</html>
