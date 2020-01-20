<%--
  Created by IntelliJ IDEA.
  User: Aubriana
  Date: 1/20/20
  Time: 17:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
    <title>show me a planet</title>
</head>
<body>
<div><h1>individual planet display</h1>

<h2><strong>you looked for this id buddy:</strong> <c:out value="${planet.getId()}"/> </h2>

    <h3>cool ! here's that planet's name ~~~ <c:out value="${planet.getName()}"/></h3>
    <p><small>how about a description?</small><br>
    <c:out value="${planet.getDescription()}"/></p>

</div>

</body>
</html>
