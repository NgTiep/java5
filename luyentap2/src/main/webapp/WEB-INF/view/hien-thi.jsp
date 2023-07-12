<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 18/05/2023
  Time: 00:20
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="/sinh-vien/search" method="get">
    Tên: <input type="text" name="ten"><br>
    <button>Search</button>
</form>
<button><a href="/sinh-vien/view-add">Add</a></button>
<button><a href="/sinh-vien/sap-xep">Sap Xep</a></button>
<button><a href="/sinh-vien/sinh-vien-nam">Sinh Vien Nam</a></button>

<table>
    <tr>
        <th>Id</th>
        <th>Ten</th>
        <th>Tuoi</th>
        <th>Dia Chi</th>
        <th>Gioi Tinh</th>
    </tr>
    <tbody>
    <c:forEach items="${listSinhVien}" var="sv">
        <tr>
            <td>${sv.id}</td>
            <td>${sv.ten}</td>
            <td>${sv.tuoi}</td>
            <td>${sv.diaChi}</td>
            <td>
                <c:if test="${sv.gioiTinh==true}">Nam</c:if>
                <c:if test="${sv.gioiTinh==false}">Nữ</c:if>
            </td>

            <td>
                <button><a href="/sinh-vien/delete/${sv.id}">Delete</a></button>
                <button><a href="/sinh-vien/detail/${sv.id}">Detail</a></button>
                <button><a href="/sinh-vien/view-update/${sv.id}">Update</a></button>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>
