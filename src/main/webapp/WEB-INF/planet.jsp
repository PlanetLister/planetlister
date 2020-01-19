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
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Please Log In"/>
    </jsp:include>
</head>
<body style="background-image: none; background-color: black">
<jsp:include page="/WEB-INF/partials/navbar.jsp"/>
<div id="profilePic"></div>
<div class="forSale">
    <div class="info">
        <h1>Planet: <span>Earth</span></h1>
        <h3>Mass:<span> 5.972 * 10^24 kg</span></h3>
        <h3>Size:<span> 3958.8 mi</span></h3>
        <h3>Description: <span>Mostly harmless.</span></h3>
        <button class="button" id="buy">Buy Now</button>
    </div>
</div>
<div class="astronaut">
    <img src="img/astronaut_bob.jpg" alt="" style="width: 400px">
    <div class="info">
        <h1>Astronaut Bob</h1>
        <p>Created planet on: <span>01/16/2020</span></p>
    </div>
</div>

<script src="https://code.jquery.com/jquery-3.4.1.js" integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU=" crossorigin="anonymous"></script>
<script src="index.js"></script>


</body>
</html>
