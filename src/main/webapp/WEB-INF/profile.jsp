<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <jsp:include page="partials/head.jsp">
        <jsp:param name="title" value="Your Profile"/>
    </jsp:include>
</head>
<body style="background-image: none; background-color: black">
<jsp:include page="partials/navbar.jsp"/>

<div class="profile">
    <img src="../img/astronaut_bob.jpg" alt="" style="width: 400px">
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
            <form class="edit" method="POST" action="/profile">
            <input type="hidden" name="editSend" value="${planet.getId()}" />
            <button id="edit" class="button" style="background-color: dodgerblue">Edit</button>
        </form>
            <form class="delete deleteBtn" name="deleteSend" method="POST" action="/profile" id="deleteBtn">
                <input type="hidden" name="deleteSend" value="${planet.getId()}" />
                <button id="delete" class="button" style="background-color: firebrick" name="deleteSend" value="${planet.getId()}" onclick="deleteClick()">Delete</button>
            </form>
        </div>
    </c:forEach>
</div>
<script>
    function deleteClick(){
        var userConfirm = confirm("Are you sure you want to delete the planet?");

        if(userConfirm){
            this.$('.deleteBtn').submit();
        }
    }

</script>

<script src="https://code.jquery.com/jquery-3.4.1.js" integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="
        crossorigin="anonymous"></script>
<script src="../index.js"></script>
</body>
</html>
