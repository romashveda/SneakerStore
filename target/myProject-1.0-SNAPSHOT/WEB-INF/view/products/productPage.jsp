<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@include file="../template/header.jsp"%>
<div class="singleprod">
    <div class="sneakerpic">
        <h1 class="title">${product.brand.brandName} ${product.model}</h1>
        <div class="mainImage">
            <img src="${product.avatar}">
        </div>
    </div>
    <div class="sidebar">
        <div class="logo-div">
            <c:if test="${product.brand.brandName == 'Nike'}">
                <img src="/images/nike_brand.jpg" alt="...">
            </c:if>
            <c:if test="${product.brand.brandName == 'Adidas'}">
                <img src="/images/adidas_brand.jpg" alt="...">
            </c:if>
            <c:if test="${product.brand.brandName == 'Asics'}">
                <img src="/images/asics_brand.jpg" alt="...">
            </c:if>
            <c:if test="${product.brand.brandName == 'Puma'}">
                <img src="/images/puma_brand.jpg" alt="...">
            </c:if>
            <c:if test="${product.brand.brandName == 'Reebok'}">
                <img src="/images/reebok_brand.jpg" alt="...">
            </c:if>
            <c:if test="${product.brand.brandName == 'Jordan Brand'}">
                <img src="/images/jumpnen_brand.jpg" alt="...">
            </c:if>
            <c:if test="${product.brand.brandName == 'New Balance'}">
                <img src="/images/newbalance_brand.jpg" alt="...">
            </c:if>
            <c:if test="${product.brand.brandName == 'Vans'}">
                <img src="/images/vans_brand.jpg" alt="...">
            </c:if>
        </div>
        <div class="price-div">${product.price} UAH</div>
        <%--<c:forEach>--%>
            <%----%>
        <%--</c:forEach>--%>
        <!--                <div>select size dropdown</div>-->
        <sec:authorize access="isAnonymous()">
            <a data-toggle="modal" data-target="#myModalLogin" class="add-curt-a">
        </sec:authorize>
        <sec:authorize access="hasRole('ROLE_USER')">
        <a href="/addToCurt/${product.id}" class="add-curt-a">
        </sec:authorize>
            <button type="submit" class="add-curt">ADD TO CURT</button>
        </a>
    </div>
</div>
<%@include file="../template/footer.jsp"%>
