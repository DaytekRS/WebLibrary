<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ui" tagdir="/WEB-INF/tags" %>
<ui:html title="Library - ${book.getName()}">
    <ui:header/>
    <c:if test="${param.success eq true}">
    <div class="container" style="margin-top: 1%;">
        <div class="alert-normal" style="text-align:center">
            Спасибо, Ваш заказ принят!
        </div>
   </div>
    </c:if>

    <div class="container" style="margin-top: 1%;">
        <div class="d-flex justify-content-start h-100">

            <table  style="background:#EDEEF0;" cellspacing="0" cellpadding="10" border="1">
                   <tr>
                        <td rowspan="4" style="padding:25px 50px;">
                                <c:if test="${book.image ne null}">
                                    <img class="image-book-container"  src=${book.image} alt =${book.name}>
                                </c:if>
                                <c:if test="${book.image eq null}">
                                    <img class="image-book-container" src="img/noImage.png" alt="noImage">
                                </c:if>
                        </td>
                        <th width="100%" height="50px">
                            <h1>${book.getName()}</h1>
                            <h5>${book.publishingHouse.getName()},${book.getYear()}<h5>
                        </th>
                   </tr>
                   <tr>
                        <th height="50px">
                            <form method="post" action="/book?id=${book.id}" >
                                 <input type="submit" value="Заказать" class="btn float-left login_btn" style="width: 200px;height:45px;background:orange;">
                                 <br><br>
                                 <select name="readingRooms">
                                     <option disabled>Выберите читальный зал</option>
                                     <c:forEach items="${rooms}"  var="room">
                                        <option value="${room.id}">${room.name}</option>
                                     </c:forEach>
                                 </select>
                                 <input type="hidden" name="${_csrf.parameterName}"
                                                                   value="${_csrf.token}"/>
                            </form>
                        </th>
                   </tr>
                   <tr>

                         <th height="50px">
                            <p>Язык: ${book.language.getName()}</p>
                            <c:if test="${periodic eq null}">
                                <p>Авторы:
                                <c:forEach  items="${book.authors}"  var="author">
                                        <c:if test="${author.id eq book.authors.get(book.authors.size()-1).id}">
                                           ${author.name}.
                                        </c:if>
                                        <c:if test="${author.id ne book.authors.get(book.authors.size()-1).id}">
                                            ${author.name},
                                        </c:if>
                                </c:forEach>
                                </p>
                                <p>${book.description}</p>
                            </c:if>

                            <c:if test="${periodic ne null}">
                                <ul>
                                    <c:forEach  items="${periodic.articles}"  var="article">
                                        <li>${article.name}</li>
                                    </c:forEach>
                                </ul>
                            </c:if>
                         </th>

                   </tr>
                   <tr>
                         <th></th>
                    </tr>
            </table>
      </div>
    </div>
</ui:html>