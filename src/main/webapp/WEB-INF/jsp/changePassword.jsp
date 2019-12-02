<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ui" tagdir="/WEB-INF/tags" %>


<ui:html title="Library - Сменить пароль">
    <ui:header/>
    <div class="container" style="margin-top: 5%;">
        <div class="d-flex justify-content-center h-100">
            <div class="card card-authorization">
                <div class="card-header">
                    <h3>Сменить пароль</h3>
                </div>
                <div class="card-body">
                    <form:form action="/changePassword" modelAttribute="newPassword" method="post">
                        <c:if test="${param.error ne null}">
                            <div class="alert-danger">Ошибка в системе. Попробуйте пожалуйста позже</div>
                        </c:if>
                        <div class="input-group form-group">
                            <form:input type="password" path="password" class="form-control" placeholder="Новый пароль"
                                        autofocus="true"></form:input>
                        </div>
                        <div>
                            <input type="submit" value="Сменить пароль" style="width: 255px"
                                   class="btn float-right login_btn"/>
                        </div>
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                    </form:form>
                </div>
            </div>
        </div>
    </div>
</ui:html>
