<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 14/05/2023
  Time: 23:06
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
    <label>Ten</label>
    <input type="text" name="ten">
    <button type="submit">Search</button>
</form>
<button><a href="/sinh-vien/sinh-vien-nu">Sinh Vien Nu</a></button>
<button><a href="/sinh-vien/sap-xep">Sap Xep</a></button>
<table>
    <tr>
        <th>ID</th>
        <th>MaSV</th>
        <th>Ten</th>
        <th>Tuoi</th>
        <th>Gioi Tinh</th>
        <th>Dia Chi</th>
        <th>Action</th>
    </tr>
    <tbody>
    <c:forEach items="${listSinhVien}" var="sv" varStatus="i">
        <tr>
            <td>${i.index+1}</td>
            <td>${sv.ma}</td>
            <td>${sv.ten}</td>
            <td>${sv.tuoi}</td>
            <td>
                <c:if test="${sv.gioiTinh==true}">Nam</c:if>
                <c:if test="${sv.gioiTinh==false}">Nữ</c:if>
            </td>
            <td>${sv.diaChi}</td>
            <td>
                <button><a>Delete</a></button>
                <button><a>Update</a></button>
                <button><a>Detail</a></button>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>
