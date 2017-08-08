<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
    <sf:form action="addUser" method="post" modelAttribute="user">
        <div>
            <label for="username">Name:</label>
            <sf:input path="username"/>
            <sf:errors path="username"/>
            <br>
            <label for="email">Email:</label>
            <sf:input path="email"/>
            <sf:errors path="email"/>
            <br>
            <label for="phone">Phone:</label>
            <sf:input path="phone"/>
            <sf:errors path="phone"/>
            <br>
            <label for="password">Password:</label>
            <sf:input path="password" type="password"/>
            <sf:errors path="password"/>
            <br>
            <label for="confirmationpass">Confirm pass:</label>
            <sf:input path="confirmationpass" type="password"/>
            <sf:errors path="confirmationpass"/>
            <br>
            <input type="submit">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </div>
    </sf:form>
</body>
</html>
