<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manage Users</title>
        <link href="${pageContext.request.contextPath}/css/style.css" type="text/css" rel="stylesheet">
    </head>
    <body>
        <h1>Manage Users</h1>
        
        <table>
            <tr>
                <th>Email</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Role</th>
                <th>Edit</th>
                <th>Delete</th>
            </tr>
            <c:forEach items="${users}" var="user">
                <tr>
                    <td>${user.email}</td>
                    <td>${user.firstName}</td>
                    <td>${user.lastName}</td>
                    <td>${user.role.roleName}</td>
                    <td></td>
                    <td></td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
