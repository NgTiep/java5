<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 14/06/2023
  Time: 00:07
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

<section class="container">
    <form action="/khach-hang/search" method="get">
        Tìm Kiếm <input name="timKiem"> <br>
        Hạng Khách Hàng:
        <select name="hangKhachHang">
            <c:forEach items="${listHKH}" var="hkh">
                <option value="${hkh.maHang}">${hkh.maHang}</option>
            </c:forEach>
        </select>
        <br>
        <button>Search</button>
    </form>


    <table>
        <thead>
        <tr>
            <th>Mã Khách Hàng</th>
            <th>Hạng Khách Hàng</th>
            <th>Tên Khách Hàng</th>
            <th>Số Điện Thoại</th>
            <th>Giới Tính</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${listKhachHang.content}" var="kh">
            <tr>
                <td>${kh.maKhachHang}</td>
                <td>${kh.hangKhachHang.tenHang}</td>
                <td>${kh.tenKhachHang}</td>
                <td>${kh.soDienThoai}</td>
                <td>
                    <c:if test="${kh.gioiTinh==true}">Nam</c:if>
                    <c:if test="${kh.gioiTinh==false}">Nữ</c:if>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</section>

</body>
</html>
