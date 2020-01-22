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
    <button>Update</button>
</form>

</html>