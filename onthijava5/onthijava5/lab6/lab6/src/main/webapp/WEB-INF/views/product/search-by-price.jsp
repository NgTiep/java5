<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 03/06/2023
  Time: 07:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="utf-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="/product/search-by-price" method="post">
    <input name="min" value="${param.min}" placeholder="Min Price?">
    <input name="max" value="${param.max}" placeholder="Max Price?">
    <button>Search</button>
</form>
<table border="1" style="width:100%">
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Price</th>
        <th>Date</th>
    </tr>

    <c:forEach var="item" items="${items}">
        <tr>
            <td>${item.id}</td>
            <td>${item.name}</td>
            <td>${item.price}</td>
            <td>${item.createDate}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
