<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="template/header.jsp"%>

<c:if test="${order.productList.isEmpty()}">
   <div style="text-align: center; width: 100%; height: 300px;"><h3>Curt is empty</h3></div>
</c:if>
<c:if test="${!order.productList.isEmpty()}">
<table class="table mytable">
    <caption>Currently in your Shoping Bag</caption>
    <thead>
    <th class="width45">Your item</th>
    <th class="width20">Description</th>
    <th class="width20"></th>
    <th>Item price</th>
    </thead>
    <tbody>
    <c:forEach items="${order.productList}" var="o">
    <tr>
        <td><a href="/product/${o.model}"><img src="${o.avatar}" class="avatar"></a></td>
        <td class="descr">
            <p><a href="brand/${o.brand.brandName}"><strong><ins>${o.brand.brandName}</ins></strong></a> ${o.model}</p>
            <p><b>Size:</b> ${o.size.sizeNum}</p>
        </td>
        <td><a class="but"  href="/deleteFromCurt/${o.model}"><button class="btn btn-primary btn-sm">Remove</button></a></td>
        <td><strong>${o.price} UAH</strong></td>
    </tr>
    </c:forEach>
    </tbody>
    <tfoot>
    <tr>
            <td class="width10"><strong>Subtotal:</strong></td>
            <td class="width10">${order.price} UAH</td>
            <td><a href="/checkOut" class="but"><button class="btn btn-danger">Check Out</button></a></td>
    </tr>
    </tfoot>
</table>
</c:if>
<%@include file="template/footer.jsp"%>
