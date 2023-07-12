<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 28/05/2023
  Time: 23:27
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/product/search" method="get">
    Name: <input type="text" name="ten"> <br>
    <button>Search</button>
</form>



<form:form action="/product/add" method="post" modelAttribute="product">
    Ma: <form:input path="ma"/> <br>
    Ten: <form:input path="ten"/> <br>
    Gia: <form:input path="gia"/> <br>
    Mo Ta: <form:input path="moTa"/> <br>
    <button>ADD</button>
</form:form>

<table>
    <tr>
        <th>ID</th>
        <th>Ma</th>
        <th>Ten</th>
        <th>Gia</th>
        <th>Mo Ta</th>
        <th>ACtion</th>
    </tr>
    <tbody>
    <c:forEach items="${listProduct}" var="product">
        <tr>
            <td>${product.id}</td>
            <td>${product.ma}</td>
            <td>${product.ten}</td>
            <td>${product.gia}</td>
            <td>${product.moTa}</td>
            <td>
                <button><a href="/product/delete/${product.id}">Delete</a></button>
                <button><a href="/product/detail/${product.id}">Detail</a></button>
                <button><a href="/product/view-update/${product.id}">Update</a></button>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>


</body>
</html>
