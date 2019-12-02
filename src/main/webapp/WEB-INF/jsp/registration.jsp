<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ui" tagdir="/WEB-INF/tags" %>

<ui:html title="Library - восстановление пароля">

    <link href="<c:url value="css/test.css" />" rel="stylesheet"
          type="text/css">

    <ui:header/>
    <form action="/registration" method="post">
        <div class="container" style="margin-top: 5%;">
            <div class="d-flex justify-content-center h-100">
                <div class="card card-authorization">
                    <div class="card-header">
                        <h3>Восстановление пароля</h3>
                    </div>
                    <div class="card-body">

                        <c:if test="${param.error ne null}">
                            <div class="alert-danger">Ошибка в системе. Попробуйте пожалуйста позже</div>
                        </c:if>

                        <form:form action="/registration" modelAttribute="user" method="post">
                            <div class="input-group form-group">
                                <form:input type="text" path="email" class="form-control" placeholder="Email"
                                            autofocus="true"></form:input>
                            </div>
                            <div class="form-group">
                                <input type="submit" value="Восстановить пароль"
                                       class="btn float-right login_btn" style="width: 255px">
                            </div>
                            <input type="hidden" name="${_csrf.parameterName}"
                                   value="${_csrf.token}"/>
                        </form:form>
                    </div>

                    <div class="card-footer">
                        <div>
                            <input type="button" value="Назад" class="btn float-right login_btn"
                                   onClick='location.href="/"'>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <input type="hidden" name="${_csrf.parameterName}"
               value="${_csrf.token}"/>
    </form>
</ui:html>
