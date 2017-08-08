<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: shved
  Date: 14.06.2017
  Time: 12:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>singleProduct</title>
</head>
<body>
    <img src="${product.avatar}">
        <p>${product.id} ${product.brand.brandName} ${product.model} ${product.price} ${product.onSale}</p>
</body>
</html>
