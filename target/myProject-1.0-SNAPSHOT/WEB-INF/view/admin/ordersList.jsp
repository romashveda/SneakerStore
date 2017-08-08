<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <c:forEach items="${ordersList}" var="ol">
        <div>
            ID Order: ${ol.id}
            <c:forEach items="${ol.getProductList()}" var="prod">
                <p>Item: ${prod.model} ${prod.brand.brandName} Price: ${prod.price}</p>
            </c:forEach>
               <p>Subtotal: ${ol.price}</p>
               Order status: ${ol.status}

        </div>
    </c:forEach>
</body>
</html>
