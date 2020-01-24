<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <jsp:include page="partials/head.jsp">
        <jsp:param name="title" value="${user.getUsername()}'s Profile"/>
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
        <button class="button" id="update">Update Profile</button>
    </div>
</div>



<div id="createPlanet">
    <form class='info' method="post" action="/galaxy/planet/create">
        <label for="pname"><b>Planet Name:</b></label>
        <input type="text" placeholder="Enter name of planet" id="pname" name="pname" required>

    <br>
    <label for="description"><b>Description:</b></label>
    <textarea style='width: 50%; height: 150px;' placeholder="Enter Description" name="description" id="description" required></textarea>
    <br>
        <c:forEach items="${categories}" var="category">
            <input type="checkbox" name="allCategories" value="<c:out value="${category.getId()}"></c:out>"><c:out value="${category.getName()}"></c:out>
        </c:forEach>

        <button type="submit" class='button'>Create</button>
    </form>
</div>

<div id="updateUserForm">
    <form class="info" method="POST" action="/profile">
        <input type="hidden" name="updateId" value="${user.getId()}" />
        <label for="uname"><b>Username:</b></label>
        <input type="text" id="uname" name="uname" value="${user.getUsername()}" required>
        <p><c:out value="${usernameError}"></c:out></p>
        <br>

        <label for="uemail"><b>E-mail:</b></label>
        <input type="text" id="uemail" name="uemail" value="${user.getEmail()}" required>
        <p><c:out value="${emailError}"></c:out></p>
        <br>
        <p><c:out value="${generalError}"></c:out></p>
        <button type="submit" class="button" id="#submitUpdateForm" name="profileUpdateSend" value="${user.getId()}">Update Profile</button>
    </form>
</div>

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
                <button id="delete" class="button" style="background-color: firebrick" name="deleteSend" value="${planet.getId()}" onclick="return deleteClick()">Delete</button>
            </form>
        </div>
    </c:forEach>
</div>
<script>
    function deleteClick() {
        var userConfirm = confirm("Are you sure you want to delete the planet?");

        if (!userConfirm) {
            return false
        } else {
            this.$('.deleteBtn').submit();
        }
    }

</script>

<script src="https://code.jquery.com/jquery-3.4.1.js" integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="
        crossorigin="anonymous"></script>
<script src="../index.js"></script>
</body>
</html>
