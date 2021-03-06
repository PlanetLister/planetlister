<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Viewing All The Ads" />
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />

<div class="container">
    <h1>Here Are all the ads!</h1>

    <form method="POST" action="/ads" id="searchForm">
        <input type="text" name="search" id="search" placeholder="Search" value="<c:out value="${userInput}"></c:out>">
        <button>Submit</button>
    </form>
    <p><c:out value="${errorMessage}"></c:out></p>

    <script>
        var search  = document.getElementById("search");

        search.addEventListener("input", function () {
            //submit the form every time a user insert an input
            document.getElementById("searchForm").submit();
        })

        window.onload = function () {
            if(search.value !== ""){
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


        }
    </script>

    <c:forEach var="ad" items="${ads}">

            <div class="col-md-6">
                <h2>${ad.title}</h2>
                <p>${ad.description}</p>

                <a href="/ads?id=${ad.id}&button=edit" name="button">Edit</a>
                <a href="/ads?id=${ad.id}&button=delete" name="button">Delete</a>
                <p>${editDelMessage}</p>
            </div>


    </c:forEach>
</div>

</body>
</html>
