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
        <li id="planet${planet.getId()}" class='planet'><br><span class="tooltiptext">${planet.getName()}</span></li>
    </c:forEach>
</ul>
<script src="https://code.jquery.com/jquery-3.4.1.js" integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU=" crossorigin="anonymous"></script>
<script src="index.js"></script>
</body>
</html>
