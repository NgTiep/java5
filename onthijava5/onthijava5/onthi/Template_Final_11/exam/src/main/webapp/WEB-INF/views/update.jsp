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
<form:form action="/phieugiaohang/update/${phieuGiaoHang.maPhieuGiao}" modelAttribute="phieuGiaoHang" method="post">
    Người Nhận: <form:input path="nguoiNhan"/> <form:errors path="nguoiNhan"/> <br>
    Số Điện Thoại: <form:input path="soDienThoai"/> <form:errors path="soDienThoai"/> <br>
    Ngày Giao: <form:input path="ngayGiao"/> <form:errors path="ngayGiao"/> <br>
    Ngày Nhận: <form:input path="ngayNhan"/> <form:errors path="ngayNhan"/> <br>
    Hóa Đơn:
    <form:select path="hoaDon">
        <form:option value="">-----</form:option>
        <c:forEach items="${listHD}" var="hd">
            <option value="${hd.maHoaDon}" ${hd.maHoaDon==phieuGiaoHang.hoaDon.maHoaDon?"selected":""}>${hd.maHoaDon}-${hd.nguoiLap}</option>
        </c:forEach>
    </form:select>
    <label>${errorHD}</label>
    <br>
    <button onclick="sua()">Sửa</button>
</form:form>

<script>
    function sua() {
        if (confirm("Bạn muốn sửa dữ liệu ?")){
            return true;
        }
    }
</script>
</body>
</html>