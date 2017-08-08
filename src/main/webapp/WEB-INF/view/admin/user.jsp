<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: shved
  Date: 29.06.2017
  Time: 18:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Page</title>
</head>
<body>
    <a href="toAdminPage">Back to Admin Page</a>
    <h4>All users:</h4>
    <core:forEach items="${users}" var="u">
        <p>${u.id} ${u.username} ${u.email} ${u.phone} ${u.authority} <strong>accountNonExpired:</strong> ${u.accountNonExpired}
            <strong>accountNonLocked:</strong> </p>${u.accountNonLocked}
        <strong>credentialsNonExpired:</strong> ${u.credentialsNonExpired} <strong>enabled:</strong> ${u.enabled}
        </p>
        <a href="orders/${u.username}"><button>Orders</button></a>
        <p><a href="edituser/${u.id}">Edit user</a></p>
        <hr>
    </core:forEach>

</body>
</html>
