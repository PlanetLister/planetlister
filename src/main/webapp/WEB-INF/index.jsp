<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<%--    <jsp:include page="/WEB-INF/partials/head.jsp">--%>
<%--        <jsp:param name="title" value="Viewing all the planets!" />--%>
<%--    </jsp:include>--%>
</head>
<body>
<%--    <jsp:include page="/WEB-INF/partials/navbar.jsp" />--%>
    <div class="container">
        <h1>Here's some planets!</h1>

        <c:forEach items="${planets}" var="planet">
            <div class="col-md-6">
                <h2>${planet.getName()}</h2>
                <p>${planet.getDescription()}</p>
            </div>
        </c:forEach>
    </div>
</body>
</html>
