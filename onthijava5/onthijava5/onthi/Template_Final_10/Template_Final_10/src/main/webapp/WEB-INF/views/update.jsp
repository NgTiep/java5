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

<form:form action="/phieugiaohang/update/${phieuGiaoHang.maPhieuGiao}" method="post" modelAttribute="phieuGiaoHang">
    Người Nhận: <form:input path="nguoiNhan"/> <form:errors path="nguoiNhan"/> <br>
    Số Điện Thoại: <form:input path="soDienThoai"/> <form:errors path="soDienThoai"/> <br>
    Ngày Giao: <form:input path="ngayGiao"/> <form:errors path="ngayGiao"/> <br>
    Ngày Nhận: <form:input path="ngayNhan"/> <form:errors path="ngayNhan"/> <br>
    Trạng Thái: <form:radiobutton value="0" path="trangThai"/> Đã Nhận
    <form:radiobutton value="1" path="trangThai"/> Chưa Nhận
    <form:errors path="trangThai"/> <br>
    Hóa Đơn:
    <form:select path="hoaDon">
        <c:forEach items="${listHD}" var="hd">
            <option value="${hd.maHoaDon}" ${hd.maHoaDon==phieuGiaoHang.hoaDon.maHoaDon?"selected":""}>${hd.maHoaDon}-${hd.nguoiLap}</option>
        </c:forEach>
    </form:select>
    <br>
    <button onclick="sua()">Sửa</button>
</form:form>

<script>
    function sua() {
        if (confirm("Bạn muốn sửa phần tử ?")) {
            return true;
        }
    }
</script>
</body>
</html>