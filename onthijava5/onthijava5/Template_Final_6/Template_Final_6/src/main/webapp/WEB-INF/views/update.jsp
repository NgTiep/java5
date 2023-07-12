<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 18/06/2023
  Time: 22:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
<form:form action="/the-thanh-vien/update/${theThanhVien.maThe}" method="post" modelAttribute="theThanhVien">
    Màu Thẻ: <form:input path="mauThe"/> <form:errors path="mauThe"/> <br>
    Loại Thẻ:
    <form:select path="loaiThe">
        <form:option value="Loại 1">Loại 1</form:option>
        <form:option value="Loại 2">Loại 2</form:option>
        <form:option value="Loại 3">Loại 3</form:option>
        <form:option value="Loại 4">Loại 4</form:option>
    </form:select>
    <br>
    Ngày Phát Hành: <form:input path="ngayPhatHanh" type="date"/> <form:errors path="ngayPhatHanh"/> <br>
    Ngày Hủy: <form:input path="ngayHuy" type="date"/> <form:errors path="ngayHuy"/> <br>
    Khách Hàng:
    <form:select path="khachHang">
        <c:forEach items="${listKH}" var="kh">
            <option value="${kh.maKhachHang}" ${kh.maKhachHang==theThanhVien.khachHang.maKhachHang?"selected":""}>${kh.maKhachHang}-${kh.tenKhachHang}</option>
        </c:forEach>
    </form:select>
    <br>
    <button>Sửa</button>
</form:form>
</body>
</html>
