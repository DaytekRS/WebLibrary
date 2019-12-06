<%@ tag language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<link rel="stylesheet" href="<c:url value="css/test.css" />" type="text/css">

<nav class="navbar navbar-light navbar-expand-lg" style="background-color: #4A76A8;">
    <a href="/main"><img src="<c:url value="img/logo.png"/>" alt="logo" style="margin-right: 50px"></a>
    <sec:authorize access="isAuthenticated()">
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent" style="margin-left: 20px">
            <ul class="navbar-nav mr-auto">
                <form action="/main" class="form-inline my-2 my-lg-0">
                    <input name="search" class="form-control mr-sm-2" type="search" placeholder="Поиск"
                           aria-label="Search">
                    <button class="btn btn-outline-light my-2 my-sm-0" type="submit">Поиск</button>
                </form>

            </ul>

            <ul class="navbar-nav">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button"
                       data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" style="color: white">
                        <sec:authentication property="name"/>
                    </a>
                    <div style="right: 0;left: inherit;" class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <a class="dropdown-item" href="/orders">Заказы</a>
                        <a class="dropdown-item" href="#">План закупок</a>
                        <a class="dropdown-item" href="/changePassword">Сменить пароль</a>
                        <div class="dropdown-divider"></div>
                        <form action="/logout" method="post">
                            <input type="submit" value="Выйти" class=" dropdown-item"/>
                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                        </form>
                    </div>
                </li>
            </ul>
        </div>
    </sec:authorize>
</nav>