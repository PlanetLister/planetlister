<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Update Planet" />
    </jsp:include>
</head>
<body>
<html>

<jsp:include page="/WEB-INF/partials/navbar.jsp" />

<form method="POST" action="/update" style="color:white;">
    <input type="hidden" name="updateId" value="${planetId}" />
    <label>Name: </label>
    <input type="text" name="planetName" value="<c:out value="${pName}"></c:out>"/>
    <span><c:out value="${nameError}"></c:out></span>
    <br>
    <label>Description:</label>
    <input type="text" name="planetDescription" value="<c:out value="${pDescription}"></c:out>"/>
    <span><c:out value="${descriptionError}"></c:out></span>
    <br>

    <c:forEach items="${categories}" var="category">
            <c:choose>
                <c:when test="${planetCategories.contains(category) == true}">
                    <input checked type="checkbox" name="allCategories" value="<c:out value="${category.getId()}"></c:out>"><c:out value="${category.getName()}"></c:out>
                </c:when>
                <c:otherwise>
                    <input type="checkbox" name="allCategories" value="<c:out value="${category.getId()}"></c:out>"><c:out value="${category.getName()}"></c:out>
                </c:otherwise>
            </c:choose>
    </c:forEach>
    <br>
    <button>Update</button>
</form>

</html>