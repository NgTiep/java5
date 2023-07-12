<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 19/06/2023
  Time: 13:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="utf-8"%>
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
<form:form action="/phieu-giam-gia/update/${phieuGiamGia.maPhieu}" method="post" modelAttribute="phieuGiamGia">
    Tên Phiếu: <form:input path="tenPhieu"/> <form:errors path="tenPhieu"/> <br>
    Ngày Bắt Đầu: <form:input path="ngayBatDau" type="date"/> <form:errors path="ngayBatDau"/> <br>
    Ngày Kết Thúc: <form:input path="ngayKetThuc" type="date"/> <form:errors path="ngayKetThuc"/> <br>
    Giá Trị Giảm: <form:input path="giaTriGiam"/> <form:errors path="giaTriGiam"/> <br>
    Giá Trị Giảm Tối Đa: <form:input path="giaTriGiamToiDa"/> <form:errors path="giaTriGiamToiDa"/> <br>
    Khách Hàng:
    <form:select path="khachHang">
        <c:forEach items="${listKH}" var="kh">
            <option value="${kh.maKhachHang}" ${kh.maKhachHang==phieuGiamGia.khachHang.maKhachHang?"selected":""}>${kh.maKhachHang}-${kh.tenKhachHang}</option>
        </c:forEach>
    </form:select>
    <br>
    <button onclick="sua()">Sửa</button>
</form:form>

<script>
    function sua() {
        if (confirm("Bạn muốn sửa phần tử ?")) {
            return true;
        } else return false;
    }

</script>
</body>
</html>