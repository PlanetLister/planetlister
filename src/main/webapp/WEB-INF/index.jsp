<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Welcome to Panet Lister!" />
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />
<ul id="solarSystem">
    <li><img class="sun" src="img/sun.gif" alt=""></li>

    <c:forEach items="${planets}" var="planet">
        <a href="/galaxy/planet?id=<c:out value="${planet.getId()}"></c:out>">
            <li id="planet${planet.getId()}" class='planet'>
                <br><br><span class="name">${planet.getName()}</span>
            </li>
        </a>
    </c:forEach>
</ul>
<script src="https://code.jquery.com/jquery-3.4.1.js" integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU=" crossorigin="anonymous"></script>
<script src="index.js"></script>
</body>
</html>

