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
            <li class="menu_li">
                <form id="content" method="POST">
                    <input type="text" name="input" class="input" id="search-input" value="<c:out value="${userInput}"></c:out>">
                    <button type="reset" class="search" id="search-btn"></button>
                </form>
            </li>
            <li class="menu_li2">
                <a class="menu_a" href="/profile"><img src="../../img/profile.png" alt=""></a>
                <a class="logout" href="/logout">Log Out</a>
            </li>
        </c:if>

    </ul>
</nav>