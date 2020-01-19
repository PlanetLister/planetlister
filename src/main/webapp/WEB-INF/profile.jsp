<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Your Profile" />
    </jsp:include>
</head>
<body style="background-image: none; background-color: black">
    <jsp:include page="/WEB-INF/partials/navbar.jsp" />

    <div class="profile">
        <img src="img/astronaut_bob.jpg" alt="" style="width: 400px">
        <div class="info">
            <h1><span>Astronaut Bob</span></h1>
            <h3>Email: <span>bananas@monkeybusiness.com</span></h3>
            <button class="button" id="create">Create Planet</button>
        </div>
    </div>
    <div id="createPlanet"></div>
    <div class="planets">
        <div class="info">
            <h1>Planets:</h1>
            <h2><span>Earth</span></h2>
            <p>Created planet on: <span>01/16/2020</span></p>
        </div>
    </div>

    <script src="https://code.jquery.com/jquery-3.4.1.js" integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU=" crossorigin="anonymous"></script>
    <script src="index.js"></script>
</body>
</html>
