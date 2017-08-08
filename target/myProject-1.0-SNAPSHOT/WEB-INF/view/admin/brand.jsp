<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: shved
  Date: 10.06.2017
  Time: 16:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Brand</title>
</head>
<body>
    <h1>Brand Page</h1>
    <a href="toAdminPage">Back to Admin Page</a>
    <h4>Form for adding</h4>
    <sf:form action="addBrand" method="post" modelAttribute="brand">
        <label for="brandName">New Brand:</label>
        <sf:input path="brandName"/>
        <%--<input type="submit">--%>
        <button>Submit</button>
    </sf:form>
    <h4>Form for deleting</h4>
    <sf:form action="deleteBrand" method="post" modelAttribute="brand">
        <label for="id">Delete brand by id:</label>
        <input type="text" name="id">
        <button>Submit</button>
    </sf:form>

    <h4>All brands</h4>
    <core:forEach items="${brands}" var="b">
        <p>${b.id} ${b.brandName}</p>
    </core:forEach>

</body>
</html>
