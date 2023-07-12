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

    <table class="table">
        <thead>
        <tr>
            <th>Mã Giỏ Hàng</th>
            <th>Ngày Tạo</th>
            <th>Ngày Cập Nhập</th>
            <th>Ghi Chú</th>
            <th>Trạng Thái</th>
            <th>Khách Hàng</th>
            <th> </th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${listGH.content}" var="gh">
            <tr>
                <td>${gh.maGioHang}</td>
                <td>${gh.ngayTao}</td>
                <td>${gh.ngayCapNhap}</td>
                <td>${gh.ghiChu}</td>
                <td>
                    <c:if test="${gh.trangThai==0}">Kết Thúc</c:if>
                    <c:if test="${gh.trangThai==1}">Bắt Đầu</c:if>
                </td>
                <td>${gh.khachHang.maKhachHang}-${gh.khachHang.tenKhachHang}</td>
                <td>
                    <button><a href="">Delete</a></button>
                    <button><a href="">Detail</a></button>
                    <button><a href="">Update</a></button>
                </td>
            </tr>
        </c:forEach>

        </tbody>
    </table>
</section>

</body>
</html>