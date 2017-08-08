<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: shved
  Date: 11.06.2017
  Time: 13:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>BrandModel</title>
</head>
<body>
    <h1>Brand Model Page</h1>
    <a href="toAdminPage">Back to Admin Page</a>
    <h4>Form for adding</h4>
    <sf:form action="addBrandModel" method="post" modelAttribute="brandModel">
        <label for="brandModelName">New Brand Model:</label>
        <sf:input path="brandModelName" />
        <sf:select path="brand">
            <core:forEach items="${brands}" var="a">
                <sf:option value="${a.id}">${a.brandName}</sf:option>
            </core:forEach>
        </sf:select>
        <sf:button>Submit</sf:button>
    </sf:form>
    <h4>Form for deleting</h4>
    <sf:form action="deleteBrandModel" method="post">
        <label for="id">Delete Brand Model by id:</label>
        <input name="id" type="text">
        <button>Submit</button>
    </sf:form>
    <h4>All Brand Models:</h4>
    <core:forEach items="${brandModels}" var="bm">
        <p>${bm.id} ${bm.brandModelName}</p>
    </core:forEach>
</body>
</html>
