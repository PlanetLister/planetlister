<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Welcome to my site!" />
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />
<ul id="solarSystem">
    <li><img class="sun" src="img/sun.gif" alt=""></li>

    <c:forEach items="${planets}" var="planet">
        <a href="/galaxy/planet?id=<c:out value="${planet.getId()}"></c:out>">
            <li class='planet'><br><br><p>${planet.getName()}</p></li>
        </a>
    </c:forEach>

</ul>
<button id="add-planet">Add New Planet</button>
<script src="https://code.jquery.com/jquery-3.4.1.js" integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU=" crossorigin="anonymous"></script>
<script src="index.js"></script>
</body>
</html>
