<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../template/header.jsp"%>
<style>
    .maincont{
        width:222px;
        height: 250px;
        float: left;
        margin: 0 20px;
    }
    .maincont a{
        text-decoration: none;
    }
    .upcont{
        width: 220px;
        height: 160px;
    }

    .upcont img{
        width: 220px;
        height: 160px;
    }

    .middlecont{
        margin: 5px 0 0 10px;
        width: 80px;
        height: 25px;
    }

    .block{

        background: #20B2AA;
        text-align: center;
        color: snow;
        z-index: 1000;
        font-size: 12pt;
        font-family: tahoma;
        position: relative;
        bottom: 25px;
    }
    .triangle{
        width: 10px;
        height: 10px;
        transform: rotate(45deg);
        background: #20B2AA;
        position: relative;
        left: 10px;
        bottom: 30px;
    }

    .downcont{
        width: 222px;
        height: 70px;
        font-size: 12pt;
        color: black;
        position: relative;
        bottom: 25px;
    }

    .brand{
        height: 20px;
        text-align: center;
    }

    .model{
        height: 30px;
        text-align: center;
    }
    .price{
        font-weight: bolder;
        text-align: center;
    }

</style>
<c:if test="${products.isEmpty()}">
    <div style="height: 300px;">
    <h3 style="text-align: center;">No items. Make another request.</h3>
    </div>
</c:if>
<c:if test="${!products.isEmpty()}">
<c:forEach items="${products}" var="ms">
    <!--    Головний контейнер-->
    <div class="maincont"><a href="/product/${ms.model}">
        <!--        Верхній контейнер-->
        <div class="upcont">
            <img src="${ms.avatar}">
        </div>
        <!--        Середній контейнер-->
        <div class="middlecont">
            <c:if test="${ms.onSale == true}">
                <div class="block">Sale</div>
                <div class="triangle"></div>
            </c:if>
        </div>
        <!--        Нижній контейнер-->
        <div class="downcont">
            <div class="brand">${ms.brand.brandName}</div>
            <div class="model">${ms.brandModel.brandModelName} ${ms.model}</div>
            <div class="price">${ms.price} UAH</div>
        </div>
    </a></div>
</c:forEach>
</c:if>
<%@include file="../template/footer.jsp"%>
