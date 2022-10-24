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
        
        <c:if test="${users.size() gt 0}">
            <table id="table">
                <tr>
                    <th>Email</th>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Role</th>
                    <th></th>
                    <th></th>
                </tr>
                <c:forEach items="${users}" var="user">
                    <tr>
                        <td>${user.email}</td>
                        <td>${user.firstName}</td>
                        <td>${user.lastName}</td>
                        <td>${user.role.roleName}</td>
                        <td>Edit</td>
                        <td><a href="user?action=delete&amp;userEmail=${user.email}">Delete</a></td>
                    </tr>
                </c:forEach>
            </table>
        </c:if>
        
        <c:if test="${users.size() eq 0}">
            <p>No users found. Please add a user.</p>
        </c:if>
        
        <h2>Add User</h2>
        <form action="user" method="post">
            Email: <input type="email" name="email" required><br />
            First Name: <input type="text" name="fname" required><br />
            Last Name: <input type="text" name="lname" required><br />
            Password: <input type="text" name="password" required><br />
            Role: <select name="role">
                <c:forEach items="${roles}" var="role">
                    <option value="${role.id}">${role.roleName}</option>
                </c:forEach>
            </select><br />
            
            <input type="hidden" name="action" value="add">
            <input type="submit" value="Add User">
        </form>
    </body>
</html>
