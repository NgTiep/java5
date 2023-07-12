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

<form:form action="/phieugiamgia/update/${phieuGiamGia.maPhieu}" modelAttribute="phieuGiamGia" method="post">
    Tên Phiếu: <form:input path="tenPhieu"/> <form:errors path="tenPhieu"/> <br>
    Ngày Bắt Đầu: <form:input path="ngayBatDau"/> <form:errors path="ngayBatDau"/> <br>
    Ngày Kết Thúc: <form:input path="ngayKetThuc"/> <form:errors path="ngayKetThuc"/> <br>
    Giá Trị Giảm: <form:input path="giaTriGiam"/> <form:errors path="giaTriGiam"/> <br>
    Giá Trị Giảm Tối Đa: <form:input path="giaTriGiamToiDa"/> <form:errors path="giaTriGiamToiDa"/> <br>
    Khách Hàng:
    <form:select path="khachHang">
        <option value="">------</option>
        <c:forEach items="${listKH}" var="kh">
            <option value="${kh.maKhachHang}" ${kh.maKhachHang==phieuGiamGia.khachHang.maKhachHang?"selected":""}>${kh.maKhachHang}-${kh.tenKhachHang}</option>
        </c:forEach>
    </form:select>
    <label>${error}</label>
    <br>
    <button onclick="sua()"> Sửa</button>
</form:form>
<script>
    function sua() {
        if (confirm("Bạn muốn sửa thông tin ?")) {
            return true;
        } else return false;
    }
</script>

</body>
</html>
