<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 26/05/2023
  Time: 23:02
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form:form action="/category/add" method="post" modelAttribute="cate">
    Ma: <form:input path="ma"/><br>
    Name: <form:input path="name"/><br>
    <button>ADD</button>
</form:form>

<table>
    <tr>
        <th>ID</th>
        <th>Ma</th>
        <th>Name</th>
        <th colspan="2">Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${listCategory}" var="cate" varStatus="stt">
        <tr>
            <td>${cate.id}</td>
            <td>${cate.ma}</td>
            <td>${cate.name}</td>
            <td>
                <button><a href="/category/delete/${cate.id}">Delete</a></button>
                <button><a href="/category/detail/${cate.id}">Detail</a></button>
                <button><a href="/category/view-update/${cate.id}">Update</a></button>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
