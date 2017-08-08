<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>SneakerStore</title>

    <meta charset="utf-8">

    <sec:csrfMetaTags/>

    <link rel="shortcut icon" href="">

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

    <link rel="stylesheet" href="css/productstyle.css">

    <link rel="stylesheet" href="/css/singlePr.css">

    <link rel="stylesheet" href="/css/filter.css">
    
    <link rel="stylesheet" href="/css/curtstyle.css">

    <style>

        .dropmen{
            width: 330px;
            text-align: center;
        }

        .dropwomen{
            width: 348px;
            text-align: center;
        }

        li:hover .dropdown-menu{
            display: block;
        }

        .user, .curt{
            float: left;
            width: 20%;

        }

        .brands{
            height: 130px;
        }

        .inversion{
            filter: invert(100%);
        }

        /* Footer*/
        .footer-left, .footer-center, .footer-right{
            width: 33.333%;
            float: left;
        }

        .footer-center ul{
            padding-right: 30px;
            list-style: none;
        }
        .footer-center a{
            text-decoration: none;
        }

        .footer-catalog,  .footer-menu{
            float: left;
            width: 50%;
        }

        .social li{
            display: inline-block;
            padding-right: 10px;
        }

        .footer-right ul{
            list-style: none;
            padding-right: 30px;
        }

        .footer-right a{
            text-decoration: none;
        }

        .form-control{
            width: 40%;
        }
    </style>
</head>
<body>
<div class="page-header" style="margin: auto;">
    <div  style="display: inline-block; width: 33%; padding-left:80px;">
        <h1><a href="/" style="text-decoration: none">Logo</a></h1>
    </div>
    <div style="display: inline-block; width: 33%;">
        <form  action="/search" method="post" class="navbar-form navbar-left" style="position: relative; top: 15px;" role="search">
            <div class="form-group">
                <input name="string" type="text" class="form-control" placeholder="Search in catalog">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            </div>
            <button type="submit" class="btn btn-default">Submit</button>
        </form>
    </div>
    <div style="display: inline-block; width: 33%; padding-left: 150px; position: relative; top: 15px;">
        <%--Curt icon--%>
        <div class="curt">
            <sec:authorize access="isAnonymous()">
                <a type="button" data-target="#myModalLogin" data-toggle="modal" class="add-curt-a"
                   style="position: relative; top: 7px; left: 13px;">
            </sec:authorize>
            <sec:authorize access="hasRole('ROLE_USER')">
            <a href="/toCurt" class="btn">
            </sec:authorize><sec:authorize access="hasRole('ROLE_ADMIN')">
                <a href="#" class="btn">
                </sec:authorize>
                <i class="fa fa-shopping-cart fa-3x" aria-hidden="true"></i>
            </a>
        </div>
            <%----%>
        <div class="user dropdown">
            <a class="btn dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true"><i class="fa fa-user-circle fa-3x" aria-hidden="true"></i></a>
            <ul class="dropdown-menu">
                <sec:authorize access="isAnonymous()">
                <li><a  type="button" class="btn" data-toggle="modal" data-target="#myModalLogin">Login</a></li>
                <li><a  type="button" class="btn" data-toggle="modal" data-target="#myModalReg">Sign up</a></li>
                </sec:authorize>
                <sec:authorize access="isAuthenticated()">
                <li><a href="/logout" type="button" class="btn">Logout</a></li>
                </sec:authorize>
            </ul>
        </div>
    </div>
</div>

<!-- Modal -->
<div class="modal fade" id="myModalLogin" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Закрити</span></button>
                <h4 class="modal-title" id="myModalLabel">Log in</h4>
            </div>
            <div class="modal-body">
                <form action="/login" method="post">
                    <div class="alert alert-danger login" role="alert">
                        <span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
                        <span class="sr-only">Error:</span>
                        Enter a valid parameters
                    </div>
                    <div><label for="username">Username:</label></div>
                    <input id="logname" class="form-control" type="text" name="username">
                    <div><label for="password">Password:</label></div>
                    <input id="logpass" class="form-control" type="password" name="password">
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                        <input type="submit" class="btn btn-primary" value="Login">
                        <h3>Haven't account?</h3>
                        <a type="button" data-dismiss="modal" data-toggle="modal" data-target="#myModalReg" class="btn btn-primary">Sign Up</a>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>


<!-- Modal -->
<div class="modal fade" id="myModalReg" tabindex="-1" role="dialog" aria-labelledby="myModalLabelReg" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Закрити</span></button>
                <h4 class="modal-title" id="myModalLabelReg">Registration</h4>
            </div>

            <div class="modal-body">
                <div  class="alert alert-danger inval" role="alert">
                    <span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
                    <span class="sr-only">Error:</span>
                    Enter a valid parameters
                </div>

                <div class="alert alert-success logsucc" role="alert">
                    <a class="alert-link">Registration succecful!You can log in now. Check your email for complete registration.</a>
                </div>

                <div><label for="username">Username:</label></div>
                <input id="username" class="form-control" type="text" name="username">

                <div><label for="email">Email:</label></div>
                <input id="email" class="form-control" type="text" name="email">

                <div><label for="phone">Phone:</label></div>
                <input id="phone" class="form-control" type="text" name="phone"><p style="color: gainsboro;">0XX-XXX-XX-XX</p>

                <div><label for="password">Password:</label></div>
                <input id="password" class="form-control" type="password" name="password">

                <div><label for="confirmationpass">Confirm pass:</label></div>
                <input id="passwordconfirm" class="form-control" type="password" name="confirmationpass">
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                <button id="registrbut"type="button" class="btn btn-primary">Sign up</button>
            </div>
        </div>
    </div>
</div>




<nav style="border: 1px solid black;">
    <ul class="nav nav-pills nav-justified">
        <li><a href="/toNewArrivals">New Arrivals</a></li>
        <li><a href="/sex/Male">Male</a>
            <ul class="dropdown-menu dropmen">
                <li><a href= "/category/Male/Running">Running</a></li>
                <li><a href= "/category/Male/Training">Training</a></li>
                <li><a href= "/category/Male/Street">Street</a></li>
                <li><a href= "/category/Male/Skateboarding">Skateboarding</a></li>
                <li><a href= "/category/Male/Basketball">Basketball</a></li>
            </ul>
        </li>
        <li><a href="/sex/Female">Female</a>
            <ul class="dropdown-menu dropwomen">
                <li><a href= "/category/Female/Running">Running</a></li>
                <li><a href= "/category/Female/Training">Training</a></li>
                <li><a href= "/category/Female/Street">Street</a></li>
            </ul>
        </li>
        <li><a href="/toSaleSneaker">Sale</a></li>
    </ul>
</nav>
