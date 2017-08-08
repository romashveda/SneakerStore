<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: shved
  Date: 11.06.2017
  Time: 22:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Size</title>
</head>
<body>
    <h1>Size Page:</h1>
    <a href="toAdminPage">Back to Admin Page</a>
    <h4>Form for adding:</h4>
    <sf:form action="addSize" method="post" modelAttribute="size">
        <label for="sizeNum">New size:</label>
        <sf:input path="sizeNum"/>
        <button>Submit</button>
    </sf:form>
    <h4>Form for deleting:</h4>
    <sf:form action="deleteSize" method="post">
        <label for="id">Delete size by id:</label>
        <input name="id" type="text">
        <button>Submit</button>
    </sf:form>
    <h4>All sizes:</h4>
    <core:forEach items="${sizes}" var="s">
        <p>${s.id} ${s.sizeNum}</p>
    </core:forEach>
</body>
</html>
