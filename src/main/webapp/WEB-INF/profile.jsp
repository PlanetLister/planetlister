<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <jsp:include page="partials/head.jsp">
        <jsp:param name="title" value="Your Profile" />
    </jsp:include>
</head>
<body style="background-image: none; background-color: black">
    <jsp:include page="partials/navbar.jsp" />

    <div class="profile">
        <img src="img/astronaut_bob.jpg" alt="" style="width: 400px">
        <div class="info">
            <h1><span><c:out value="${user.getUsername()}"/></span></h1>
            <h3>Email: <span><c:out value="${user.getEmail()}"/></span></h3>
            <button class="button" id="create">Create Planet</button>
        </div>
    </div>
    <div id="createPlanet"></div>

    <div class="planets">
   <c:forEach items="${planets}" var="planet">
        <div class="info">
            <h1>Planet:</h1>
            <h2><span>${planet.getName()}</span></h2>
            <p>Description: ${planet.getDescription()}</p>
        </div>
   </c:forEach>
    </div>

    <script src="https://code.jquery.com/jquery-3.4.1.js" integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU=" crossorigin="anonymous"></script>
    <script src="../index.js"></script>
</body>
</html>
