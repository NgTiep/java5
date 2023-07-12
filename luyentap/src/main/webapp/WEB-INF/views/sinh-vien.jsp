<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 17/05/2023
  Time: 22:34
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>SPring MVC</title>
</head>
<body>

<section>
    <%--search--%>
    <form action="/sinh-vien/search" method="get">
        <label>Tên</label><br>
        <input type="text" name="ten"><br>
        <button type="submit">Search</button>
    </form>
    <br>
    <%--Add--%>
    <form action="/sinh-vien/add" method="post">
        ID: <input type="number" name="id" value="${sv.id}"> <br>
        Ten: <input type="text" name="ten" value="${sv.ten}"> <br>
        Tuoi: <input type="number" name="tuoi" value="${sv.tuoi}"> <br>
        Dia Chi: <input type="text" name="diaChi" value="${sv.diaChi}"> <br>
        Gioi Tinh:
        <input type="radio" name="gioiTinh" checked value="true" ${sv.gioiTinh==true?"checked":""}>Nam
        <input type="radio" name="gioiTinh" value="false" ${sv.gioiTinh==false?"checked":""}>Nữ
        <br>
        <button>ADD</button>
    </form>
    <br>
    <button><a href="/sinh-vien/sinh-vien-nu">Sinh Viên Nữ</a></button>
    <br>
    <button><a href="/sinh-vien/sap-xep">Sắp Xếp </a></button>
    <%--   Table--%>
    <table>
        <tr>
            <th>ID</th>
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
                <td>
                <td>
                    <button><a href="/sinh-vien/delete/${sv.id}">Delete</a></button>
                    <button><a href="/sinh-vien/detail/${sv.id}">Detail</a></button>
                    <button><a href="/sinh-vien/view-update/${sv.id}">Update</a></button>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <label>${mess}</label>
</section>
</body>
</html>
