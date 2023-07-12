<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 21/05/2023
  Time: 14:58
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="/san-pham/search" method="get">
    Tên:<input type="text" name="ten"><br>
    <button>Search</button>
</form>

<button><a href="/san-pham/sap-xep">Sort</a></button>
<button><a href="/san-pham/loai1">Loai 1</a></button>

<form:form action="/san-pham/add" method="post" modelAttribute="sp">
    ID: <form:input path="id"/> <form:errors path="id"/> <br>
    Mã: <form:input path="ma"/> <form:errors path="ma"/> <br>
    Tên: <form:input path="ten"/> <form:errors path="ten"/> <br>
    Giá: <form:input path="gia"/> <form:errors path="gia"/> <br>
    Loại:
    <form:select path="loai">
        <form:option value="loai 1">Loại 1</form:option>
        <form:option value="loai 2">Loại 2</form:option>
        <form:option value="loai 3">Loại 3</form:option>
        <form:option value="loai 4">Loại 4</form:option>
    </form:select>
    <button>Add</button>
</form:form>

<table>
    <tr>
        <th>ID</th>
        <th>Ma</th>
        <th>Ten</th>
        <th>Gia</th>
        <th>Loai</th>
        <th>Action</th>
    </tr>
    <tbody>

    <c:forEach items="${listSanPham}" var="sp">
        <tr>
            <td>${sp.id}</td>
            <td>${sp.ma}</td>
            <td>${sp.ten}</td>
            <td>${sp.gia}</td>
            <td>${sp.loai}</td>
            <td>
                <button><a href="/san-pham/delete/${sp.id}">Delete</a></button>
                <button><a href="/san-pham/detail/${sp.id}">Detail</a></button>
                <button><a href="/san-pham/view-update/${sp.id}">Update</a></button>
            </td>
        </tr>
    </c:forEach>
    </tbody>

</table>

</body>
</html>
