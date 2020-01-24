<%--
  Created by IntelliJ IDEA.
  User: jwhester
  Date: 1/19/20
  Time: 1:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="partials/head.jsp">
        <jsp:param name="title" value="${planet.getName()}"/>
    </jsp:include>
</head>
<body style="background-image: none; background-color: black">
<jsp:include page="partials/navbar.jsp"/>
<div id="planet${planet.getId()}" class="profilePic"></div>
<div class="forSale">
    <div class="info">
        <h1>Planet: <span><c:out value="${planet.getName()}"/> </span></h1>
        <h3>Description: <span><c:out value="${planet.getDescription()}"/></span></h3>

        <c:if test="${validate != null}">
            <form method="POST" action="/buy">
                <input type="hidden" name="planet" value="${planet.getId()}">
                <button class="button" id="buy">Buy Now</button>
            </form>
        </c:if>

        <ul>
            <c:forEach items="${categories}" var="category">
                <li>${category.getName()}</li>
            </c:forEach>
        </ul>

    </div>
</div>
<div class="astronaut">
    <img src="../img/astronaut_bob.jpg" alt="" style="width: 400px">
    <div class="info">
        <h1>Created by: <c:out value="${planetUser.getUsername()}"/></h1>
        <p>Comments? E-mail <c:out value="${planetUser.getUsername()}"/> at <c:out value="${planetUser.getEmail()}"/></p>
    </div>
</div>

<script src="https://code.jquery.com/jquery-3.4.1.js" integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="
        crossorigin="anonymous"></script>
<script src="../index.js"></script>


</body>
</html>
