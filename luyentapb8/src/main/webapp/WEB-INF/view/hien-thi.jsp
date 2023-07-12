<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 23/05/2023
  Time: 22:44
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

<form action="" method="">
    Tên: <input type="text" name="ten">
    <button>Search</button>
</form>

<form:form action="/san-pham/add" method="post" modelAttribute="sp">
    ID: <form:input path="id"/> <br>
    Ma: <form:input path="ma"/> <br>
    Ten: <form:input path="ten"/> <br>
    Gioi Tinh: <form:radiobutton value="true" path="gioiTinh"/> Nam
    <form:radiobutton value="false" path="gioiTinh"/> Nữ
    <br>
    Loai:<form:select path="loai">
    <form:option value="loai 1">Loại 1</form:option>
    <form:option value="loai 2">Loại 2</form:option>
    <form:option value="loai 3">Loại 3</form:option>
    <form:option value="loai 4">Loại 4</form:option>
</form:select>
    <br>
    <button>ADD</button>
</form:form>

<table>
    <tr>
        <th>ID</th>
        <th>Ma</th>
        <th>Ten</th>
        <th>Gioi Tinh</th>
        <th>Loai</th>
        <th>ACtion</th>
    </tr>
    <tbody>
    <c:forEach items="${listSanPham}" var="sp">
        <tr>
            <td>${sp.id}</td>
            <td>${sp.ma}</td>
            <td>${sp.ten}</td>
            <td>
                <c:if test="${sp.gioiTinh==true}">Nam</c:if>
                <c:if test="${sp.gioiTinh==false}">Nữ</c:if>
            </td>
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
