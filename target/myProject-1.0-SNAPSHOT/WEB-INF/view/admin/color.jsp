<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: shved
  Date: 11.06.2017
  Time: 22:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Color</title>
</head>
<body>
    <h1>Color Page</h1>
    <a href="toAdminPage">Back to Admin Page</a>
    <h4>Form for adding:</h4>
    <sf:form action="addColor" method="post" modelAttribute="color">
        <label for="colorName">New Color:</label>
        <sf:input path="colorName"/>
        <button>Submit</button>
    </sf:form>
    <h4>Form for deleting:</h4>
    <sf:form action="deleteColor" method="post">
        <label for="id">Delete color by id:</label>
        <input name="id" type="text">
        <button>Submit</button>
    </sf:form>
    <h4>All Colors</h4>
    <core:forEach items="${colors}" var="c">
        <p>${c.id} ${c.colorName}</p>
    </core:forEach>
</body>
</html>
