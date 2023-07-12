<%@ page pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

    <form action="/phieugiamgia/search" method="get">
        Từ Ngày : <input name="tuNgay">
        Đến Ngày : <input name="denNgay">
        Khách Hàng:
        <select name="khachHang">
            <c:forEach items="${listKH}" var="kh">
                <option value="${kh.maKhachHang}" >${kh.maKhachHang}-${kh.tenKhachHang}</option>
            </c:forEach>
        </select>
        <button>Tìm Kiếm</button>
    </form>

    <form:form action="/phieugiamgia/add" modelAttribute="phieuGiamGia" method="post">
        Mã Phiếu: <form:input path="maPhieu"/> <form:errors path="maPhieu"/> <br>
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
        <button onclick="them()"> Thêm</button>
    </form:form>


    <table class="table">
        <thead>
        <tr>
            <th>Mã Phiếu</th>
            <th>Tên Phiếu</th>
            <th>Ngày Bắt Đầu</th>
            <th>Ngày Kết Thúc</th>
            <th>Giá Trị Giảm</th>
            <th>Trạng Thái</th>
            <th>Tên Khách Hàng</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${listPGG.content}" var="pgg">
            <tr>
                <td>${pgg.maPhieu}</td>
                <td>${pgg.tenPhieu}</td>
                <td>${pgg.ngayBatDau}</td>
                <td>${pgg.ngayKetThuc}</td>
                <td>${pgg.giaTriGiam}</td>
                <td>
                    <c:if test="${pgg.trangThai==0}">Kết Thúc</c:if>
                    <c:if test="${pgg.trangThai==1}">Bắt Đầu</c:if>
                </td>
                <td>${pgg.khachHang.maKhachHang}-${pgg.khachHang.tenKhachHang}</td>
                <td>
                    <button><a href="/phieugiamgia/delete/${pgg.maPhieu}" onclick="xoa()">Delete</a></button>
                    <button><a href="/phieugiamgia/detail/${pgg.maPhieu}">Detail</a></button>
                    <button><a href="/phieugiamgia/view-update/${pgg.maPhieu}">Edit</a></button>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <a href="/phieugiamgia/hien-thi?page=0">Frist</a>
    <a href="/phieugiamgia/hien-thi?page=${listPGG.number-1}">Person</a>
    <a href="/phieugiamgia/hien-thi?page=${listPGG.number+1}">Next</a>
    <a href="/phieugiamgia/hien-thi?page=${listPGG.totalPages-1}">Last</a>

    <br>
    <label style="color: red">${mess}</label>
    <br>
    <ul>
        <li>Số Trang Hiện Tại: ${listPGG.number}</li>
        <li>Tổng Số Trang: ${listPGG.totalPages}</li>
        <li>Tổng Số Phần Tử: ${listPGG.totalElements}</li>
    </ul>

    <script>
        function them() {
            if (confirm("Bạn muốn thêm thông tin ?")) {
                return true;
            } else return false;
        }

        function xoa() {
            if (confirm("Bạn muốn xóa thông tin ?")) {
                return true;
            } else return false;
        }
    </script>
</section>

</body>
</html>