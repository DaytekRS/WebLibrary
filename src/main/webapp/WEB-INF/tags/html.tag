<%@ tag language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ attribute name="title" required="false" %>
<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="/css/bootstrap.min.css">
    <link rel="stylesheet" href="<c:url value="css/test.css" />" type="text/css">

    <c:if test="${not empty title}">
        <title>${title}</title>
    </c:if>
</head>
<body>
<script src="/js/jquery-3.4.1.js"></script>
<script src="/js/bootstrap.bundle.min.js"></script>
<jsp:doBody/>

</body>
</html>