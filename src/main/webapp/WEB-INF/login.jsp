<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="partials/head.jsp">
        <jsp:param name="title" value="Please Log In"/>
    </jsp:include>
</head>
<body>
<jsp:include page="partials/navbar.jsp"/>
<div id="galaxy">
    <img class="title" src="../img/title.png" alt="">
    <img class="splashSun" src="../img/sun.gif" alt="">
    <div id="ex1" class="modal">
        <form action="POST">
            <label for="uname"><b>Username</b></label>
            <input type="text" placeholder="Enter Username" id="uname" name="uname" required>
            <br>
            <label for="psw"><b>Password</b></label>
            <input type="password" placeholder="Enter Password" name="psw" id="psw" required>
            <br>
            <button type="submit">Login</button>
        </form>
        <a href="#" rel="modal:close">Close</a>
    </div>
    <div id="ex2" class="modal">
        <form action="POST">
            <label for="uname"><b>Create Username</b></label>
            <input type="text" placeholder="Enter Username" name="uname" required>
            <br>
            <label for="psw"><b>Create Password</b></label>
            <input type="password" placeholder="Enter Password" name="psw" required>
            <br>
            <button type="submit">Create Account</button>
        </form>
        <a href="#" rel="modal:close">Close</a>
    </div>
    <div id="loginButtons">
        <a href="#ex1" rel="modal:open">
            <button class="button">Login</button>
        </a>
        <a href="#ex2" rel="modal:open">
            <button class="button">Sign Up</button>
        </a>
    </div>
</div>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.0.0/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-modal/0.9.1/jquery.modal.min.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery-modal/0.9.1/jquery.modal.min.css"/>


</body>
</html>
