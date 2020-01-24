<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Welcome to Panet Lister!" />
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbarIndex.jsp"/>
<p style="color:white;"><c:out value="${errorMessage}"></c:out></p>
<ul id="solarSystem">
    <li><img class="sun" src="img/sun.gif" alt=""></li>

    <c:forEach items="${planets}" var="planet">
        <a href="/galaxy/planet?id=<c:out value="${planet.getId()}"></c:out>">
            <li id="planet${planet.getId()}" class='planet'>
                <br><br><span class="name">${planet.getName()}</span>
            </li>
        </a>
    </c:forEach>
</ul>

<script>
    var search  = document.getElementById("search-input");

    search.addEventListener("input", function () {
        //submit the form every time a user insert an input
        document.getElementById("content").submit();
    });

    window.onload = function () {

        if(search.value != ""){
            search.setAttribute("class", "input square");
            document.getElementById('search-btn').setAttribute("class", 'search');
        }
        //on load, the search input would get cursor at the end of the input
        search.focus();

        if (typeof search.selectionStart == "number") {
            search.selectionStart = search.selectionEnd = search.value.length;
        } else if (typeof search.createTextRange != "undefined") {
            var range = search.createTextRange();
            range.collapse(false);
            range.select();
        }
    }
</script>

<script src="https://code.jquery.com/jquery-3.4.1.js" integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU=" crossorigin="anonymous"></script>
<script src="index.js"></script>
</body>
</html>

