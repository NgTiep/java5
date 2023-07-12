<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 16/05/2023
  Time: 08:46
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="/bai4/product/save" method="post">
    <input name="name">
    <input name="number">
    <button>Save</button>
</form>
<ul>
    <li>${name1}</li>
    <li>${number1}</li>
</ul>
<ul>
    <li>${name}</li>
    <li>${number}</li>
</ul>

<ul>
    <c:forEach var="item" items="${items}">
        <li>${item.name}</li>
        <li>${item.number}</li>
    </c:forEach>
</ul>

</body>
</html>
