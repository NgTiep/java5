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

<section class="container">
    <form:form action="/gio-hang/add" method="post" modelAttribute="gioHang">
        Ngày Tạo: <form:input path="ngayTao"/> <form:errors path="ngayTao"/> <br>
        Ngày Cập Nhập: <form:input path="ngayCapNhap"/> <form:errors path="ngayCapNhap"/> <br>
        Trạng Thái: <form:radiobutton value="0" path="trangThai"/> Kết Thúc
        <form:radiobutton value="1" path="trangThai"/> Bắt Đầu
        <br>
        Khách Hàng:
        <form:select path="khachHang">
            <option value="">------</option>
            <c:forEach items="${listKH}" var="kh">
                <option value="${kh.maKhachHang}" ${kh.maKhachHang==gioHang.khachHang.maKhachHang?"selected":""}>${kh.maKhachHang}-${kh.tenKhachHang}</option>
            </c:forEach>
        </form:select>
        <label>${error}</label>
        <br>
        <button onclick="them()">Thêm</button>
    </form:form>

    <script>
        function them() {
            if (confirm("Bạn muốn thêm thông tin?")){
                return true;
            }
        }

    </script>
</section>


</body>
</html>
