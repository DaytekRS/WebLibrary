<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ui" tagdir="/WEB-INF/tags" %>

<ui:html title="Library">

    <ui:header/>
    <form action="/login" method="post">

        <div class="container" style="margin-top: 5%;">
            <div class="d-flex justify-content-center h-100">
                <div class="card card-authorization">
                    <div class="card-header">
                        <h3>Авторизация</h3>
                    </div>
                    <div class="card-body">

                        <c:if test="${param.error ne null}">
                            <div class="alert-danger">Не правильно введен логин или пароль</div>
                        </c:if>
                        <c:if test="${param.logout ne null}">
                            <div class="alert-normal">Вы вышли из системы</div>
                        </c:if>
                        <c:if test="${param.registration ne null}">
                            <div class="alert-normal">На эл. ящик ${param.registration} направлен пароль для входа в
                                систему
                            </div>
                        </c:if>

                        <form action="/login" method="post">
                            <div class="input-group form-group">
                                <input type="text" class="form-control" name="username" placeholder="username">
                            </div>
                            <div class="input-group form-group">

                                <input type="password" class="form-control" name="password" placeholder="password">
                            </div>
                            <div class="form-group">
                                <input type="submit" value="Войти" class="btn float-right login_btn">
                            </div>
                            <input type="hidden" name="${_csrf.parameterName}"
                                   value="${_csrf.token}"/>
                        </form>
                    </div>
                    <div class="card-footer">
                        <div class="d-flex justify-content-center text-center links">
                            Нажмите на эту кнопку если вы забыли пароль
                        </div>
                        <div class="form-group text-center">
                            <input type="button" value="Восстановить пароль"
                                   class="btn registration_btn" onClick='location.href="/registration"'>
                        </div>


                    </div>
                </div>
            </div>
        </div>


    </form>
</ui:html>
