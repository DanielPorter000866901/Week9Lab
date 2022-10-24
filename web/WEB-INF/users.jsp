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
        <ul>
            <c:forEach items="${users}" var="user">
                <li>${user.email}, ${user.firstName}, ${user.lastName}, ${user.password}, ${user.role}</li>
            </c:forEach>
        </ul>
        
        <ul>
            <c:forEach items="${roles}" var="role">
                <li>${role.id}: ${role.roleName}</li>
            </c:forEach>
        </ul>
    </body>
</html>
