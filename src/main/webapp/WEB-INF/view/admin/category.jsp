<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: shved
  Date: 11.06.2017
  Time: 21:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Category</title>
</head>
<body>
    <h1>Category Page</h1>
    <a href="toAdminPage">Back to Admin Page</a>
    <h4>Form for adding:</h4>
    <sf:form action="addCategory" method="post" modelAttribute="category">
        <label for="categoryName">New Category:</label>
        <sf:input path="categoryName"/>
        <button>Submit</button>
    </sf:form>
    <h4>Form for deleting:</h4>
    <sf:form action="deleteCategory" method="post">
        <label for="id">Delete category by id:</label>
        <input name="id" type="text">
        <button>Submit</button>
    </sf:form>
    <h4>All Categories:</h4>
    <core:forEach items="${categories}" var="c">
        <p>${c.id} ${c.categoryName}</p>
    </core:forEach>
</body>
</html>
