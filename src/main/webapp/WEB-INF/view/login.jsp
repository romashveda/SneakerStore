<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@include file="template/header.jsp"%>
    <br>
    <form action="/login" method="post" style="width: 50%; margin: 0 auto;">
        <div class="alert alert-danger" role="alert">
            <span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
            <span class="sr-only">Error:</span>
            Enter a valid parameters
        </div>

        <div><label for="username">Username:</label></div>
        <input id="logname" class="form-control" type="text" name="username">
        <div><label for="password">Password:</label></div>
        <input id="logpass" class="form-control" type="password" name="password">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <br>
        <input type="submit" class="btn btn-primary" value="Login">
    </form>
<br>
<%@include file="template/footer.jsp"%>