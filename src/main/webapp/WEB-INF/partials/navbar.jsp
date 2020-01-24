<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="navbar">
    <ul class="nav_menu">
        <li class="menu_li">
            <a class="menu_a" href="/galaxy">
                <img id="logoTitle" src="../../img/title.png" alt="">
                <img id="logoPic" src="../../img/sun.gif" alt="">
            </a>
        </li>

        <c:if test="${user != null}">
            <li class="menu_li2">
                <div class="red">
                    <a class="menu_a" href="/profile"><img id="ex1" src="../../img/profile.png" alt=""></a>
                </div>
                <a class="logout" href="/logout">Log Out</a>
            </li>
        </c:if>

    </ul>
</nav>
