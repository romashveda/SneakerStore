<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: shved
  Date: 11.06.2017
  Time: 22:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sex</title>
</head>
<body>
    <h1>Sex Page</h1>
    <a href="toAdminPage">Back to Admin Page</a>
    <h4>Form for adding:</h4>
    <sf:form action="addSex" method="post" modelAttribute="sex">
        <label for="sexName">New sex:</label>
        <sf:input path="sexName"/>
        <button>Submit</button>
    </sf:form>
    <h4>Form for deleting:</h4>
    <sf:form action="deleteSex" method="post">
        <label for="id">Delete sex by id:</label>
        <input name="id" type="text">
        <button>Submit</button>
    </sf:form>
    <h4>All sex:</h4>
    <core:forEach items="${sexAll}" var="s">
        <p>${s.id} ${s.sexName}</p>
    </core:forEach>
</body>
</html>
