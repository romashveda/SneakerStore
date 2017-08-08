<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: shved
  Date: 11.06.2017
  Time: 22:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product</title>
</head>
<body>
    <h1>Product Page</h1>
    <a href="toAdminPage">Back to Admin Page</a>
    <h4>Form for adding:</h4>
    <form action="addProduct" method="post" enctype="multipart/form-data">
        <label for="model">Model:</label>
        <input type="text" name="model"/>
        <label for="price">Price</label>
        <input type="text" name="price"/>
        <label for="">onSale:</label>
        <%--<sf:input path="onSale"/>--%>
        <select name="onSale">
            <option value="true">true</option>
            <option value="false">false</option>
        </select>
        <label>Select avatar:</label>
        <input name="avatar" type="file"/>
        <br><br>
        <label>Brand:</label>
        <select name="brand">
            <core:forEach items="${brands}" var="a">
                <option value="${a.id}">${a.brandName}</option>
            </core:forEach>
        </select>
        <label>Brand Model:</label>
        <select name="brandModel">
            <option value="0"></option>
            <core:forEach items="${brandModels}" var="bm">
                <option value="${bm.id}">${bm.brandModelName}</option>
            </core:forEach>
        </select>
        <label>Category:</label>
        <select name="category">
            <core:forEach items="${categories}" var="c">
                <option value="${c.id}">${c.categoryName}</option>
            </core:forEach>
        </select>
        <label>Sex:</label>
        <select name="sex">
            <core:forEach items="${sexAll}" var="sex">
                <option value="${sex.id}">${sex.sexName}</option>
            </core:forEach>
        </select>
        <label>Size:</label>
        <select name="size">
            <core:forEach items="${sizes}" var="s">
                <option value="${s.id}">${s.sizeNum}</option>
            </core:forEach>
        </select>
        <label>Color:</label>
        <select name="color">
            <core:forEach items="${colors}" var="col">
                <option value="${col.id}">${col.colorName}</option>
            </core:forEach>
        </select>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <br><br>
        <button>Submit</button>
    </form>
    <h4>Form for editing</h4>

    <h4>All Products</h4>
    <core:forEach items="${products}" var="p">
        <p><a href="product${p.id}">${p.id} ${p.model} ${p.brand.brandName} ${p.brandModel.brandModelName} ${p.price}</a></p>
    </core:forEach>
</body>
</html>
