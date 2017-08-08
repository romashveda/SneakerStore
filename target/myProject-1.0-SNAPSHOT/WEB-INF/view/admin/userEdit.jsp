<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h4>Editing form</h4>
    <sf:form action="/editUser" method="post" modelAttribute="user">
        <p>${user.id} ${user.username} ${user.email} ${user.phone}</p>
        <sf:hidden path="id"/>
        <sf:hidden path="username"/>
        <sf:hidden path="email"/>
        <sf:hidden path="phone"/>
        <sf:hidden path="password"/>
        <sf:hidden path="confirmationpass"/>
        <label name="authority">authority:</label>
        <sf:select path="authority">
            <sf:option value="ROLE_USER">ROLE_USER</sf:option>
            <sf:option value="ROLE_ADMIN">ROLE_ADMIN</sf:option>
        </sf:select>
        <label name="accountNonExpired">accountNonExpired:</label>
        <sf:select path="accountNonExpired">
            <sf:option value="true">true</sf:option>
            <sf:option value="false">false</sf:option>
        </sf:select>
        <label name="accountNonLocked">accountNonLocked:</label>
        <sf:select path="accountNonLocked">
            <sf:option value="true">true</sf:option>
            <sf:option value="false">false</sf:option>
        </sf:select>
        <label name="credentialsNonExpired">credentialsNonExpired:</label>
        <sf:select path="credentialsNonExpired">
            <sf:option value="true">true</sf:option>
            <sf:option value="false">false</sf:option>
        </sf:select>
        <label name="enabled">enabled:</label>
        <sf:select path="enabled">
            <sf:option value="1">true</sf:option>
            <sf:option value="0">false</sf:option>
        </sf:select>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <sf:button>Edit</sf:button>
    </sf:form>
</body>
</html>
