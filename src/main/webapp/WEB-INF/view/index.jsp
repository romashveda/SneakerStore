<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%@include file="template/header.jsp"%>

<sec:authorize access="hasRole('ROLE_ADMIN')">
    <a href="toAdminPage"><button style="position: relative; bottom: 100px; left: 200px;" class="btn btn-primary">toAdminPage</button></a>
</sec:authorize>

<!--carousel -->
<div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
        <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
        <li data-target="#carousel-example-generic" data-slide-to="1"></li>
        <li data-target="#carousel-example-generic" data-slide-to="2"></li>
        <li data-target="#carousel-example-generic" data-slide-to="3"></li>
        <li data-target="#carousel-example-generic" data-slide-to="4"></li>
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner" role="listbox">
        <div class="item active">
            <a href="#"><img src="/images/banner1.jpg" alt></a>
        </div>
        <div class="item">
            <a href="#"><img src="/images/banner2.jpg"></a>
        </div>
        <div class="item">
            <a href="#"><img src="/images/banner3.jpg"></a>
        </div>
        <div class="item">
            <a href="#"><img src="/images/banner4.jpg"></a>
        </div>
        <div class="item">
            <a href="#"><img src="/images/banner5.jpg"></a>
        </div>
    </div>

    <!-- Controls -->
    <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
        <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
        <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
        <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
        <span class="sr-only">Next</span>
    </a>
</div>

<h3 style="text-align: center;">Brands</h3>
<div class="row">
    <div class="col-xs-6 col-md-3">
        <a href="/brand/Adidas" class="thumbnail inversion">
            <img src="/images/adidas_brand.jpg" alt>
        </a>
    </div>
    <div class="col-xs-6 col-md-3">
        <a href="/brand/Asics" class="thumbnail brands">
            <img style="padding-top: 25px;" src="/images/asics_brand.jpg" alt="...">
        </a>
    </div>
    <div class="col-xs-6 col-md-3">
        <a href="/brand/Nike" class="thumbnail brands inversion">
            <img style="padding-top: 35px;" src="/images/nike_brand.jpg" alt="...">
        </a>
    </div>
    <div class="col-xs-6 col-md-3">
        <a href="/brand/Puma" class="thumbnail brands">
            <img style="padding-top: 20px;" src="/images/puma_brand.jpg" alt="...">
        </a>
    </div>
    <div class="col-xs-6 col-md-3">
        <a href="/brand/New Balance" class="thumbnail brands">
            <img style="padding-top: 10px;" src="/images/newbalance_brand.jpg" alt="...">
        </a>
    </div>
    <div class="col-xs-6 col-md-3">
        <a href="/brand/Reebok" class="thumbnail brands inversion">
            <img style="padding-top: 45px;"src="/images/reebok_brand.jpg" alt="...">
        </a>
    </div>
    <div class="col-xs-6 col-md-3">
        <a href="/brand/Jordan Brand" class="thumbnail brands">
            <img style="padding-top: 10px;" src="/images/jumpmen_brand.jpg" alt="...">
        </a>
    </div>
    <div class="col-xs-6 col-md-3">
        <a href="/brand/Vans" class="thumbnail brands inversion">
            <img src=/images/vans_brand.jpg alt="...">
        </a>
    </div>
</div>

<%@include file="template/footer.jsp"%>
