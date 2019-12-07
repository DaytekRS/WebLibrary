<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ui" tagdir="/WEB-INF/tags" %>

<ui:html title="Library - Заказы">
    <ui:header/>
    <div class="container" style="margin-top: 1%;">
        <div class="d-flex justify-content-start h-100">
            <table width="100%" style="background:#EDEEF0;" cellspacing="0" cellpadding="10" border="1">
                <tr>
                    <th width="50px" style="text-align:center">Номер заказа</th>
                    <th width="50%" style="text-align:center">Издание</th>
                    <th style="text-align:center">Читальный зал</th>
                    <th style="text-align:center">Статус</th>
                </tr>
                <c:forEach items="${orders}" var="order">
                    <tr>
                        <th>${order.id}</th>
                        <th>${order.edition}</th>
                        <th>${order.readingRoom}</th>
                        <th>
                            <c:if test="${order.employe eq null}">
                                Ожидает сборки
                            </c:if>
                        </th>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</ui:html>
