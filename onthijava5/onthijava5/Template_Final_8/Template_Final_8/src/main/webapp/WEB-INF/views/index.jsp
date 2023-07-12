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

    <form action="/phieu-giam-gia/search" method="get">
        Ngày Bắt Đầu: <input name="ngayBatDau">
        Ngày Kết Thúc: <input name="ngayKetThuc">
        Khách Hàng:
        <select name="khachHang">
            <c:forEach items="${listKH}" var="kh">
                <option value="${kh.maKhachHang}">${kh.maKhachHang}-${kh.tenKhachHang}</option>
            </c:forEach>
        </select>
        <button>Tìm Kiếm</button>
    </form>

    <form:form action="/phieu-giam-gia/add" method="post" modelAttribute="phieuGiamGia">
        Mã Phiếu: <form:input path="maPhieu"/> <form:errors path="maPhieu"/> <br>
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
        <button onclick="them()">Thêm</button>
    </form:form>

    <table class="table">
        <thead>
        <tr>
            <th style="width: 2%">#</th>
            <th style="width: 2%">Mã Phiếu</th>
            <th style="width: 2%">Tên Phiếu</th>
            <th style="width: 2%">Ngày Bắt Đầu</th>
            <th style="width: 2%">Ngày Kết Thúc</th>
            <th style="width: 2%">Giá Trị Giảm</th>
            <th style="width: 2%">Trạng Thái</th>
            <th style="width: 2%">Tên Khách Hàng</th>
            <th style="width: 2%"></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${listPGG.content}" var="pgg" varStatus="i">
            <tr>
                <td>${i.index+1}</td>
                <td>${pgg.maPhieu}</td>
                <td>${pgg.tenPhieu}</td>
                <td>${pgg.ngayBatDau}</td>
                <td>${pgg.ngayKetThuc}</td>
                <td>${pgg.giaTriGiam}</td>
                <td>
                    <c:if test="${pgg.trangThai==0}">Kết Thúc</c:if>
                    <c:if test="${pgg.trangThai==1}">Chưa Kết Thúc</c:if>
                </td>
                <td>${pgg.khachHang.maKhachHang}-${pgg.khachHang.tenKhachHang}</td>
                <td>
                    <button><a href="/phieu-giam-gia/delete/${pgg.maPhieu}" onclick="xoa()">Delete</a></button>
                    <button><a href="/phieu-giam-gia/detail/${pgg.maPhieu}">Detail</a></button>
                    <button><a href="/phieu-giam-gia/view-update/${pgg.maPhieu}">Update</a></button>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <a href="/phieu-giam-gia/hien-thi?page=0">Frist</a>
    <a href="/phieu-giam-gia/hien-thi?page=${listPGG.number-1}">Person</a>
    <a href="/phieu-giam-gia/hien-thi?page=${listPGG.number+1}">Next</a>
    <a href="/phieu-giam-gia/hien-thi?page=${listPGG.totalPages-1}">Last</a>
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
            if (confirm("Bạn muốn thêm phần tử?")) {
                return true;
            } else return false;
        }

        function xoa() {
            if (confirm("Bạn muốn xóa phần tử?")) {
                return true;
            } else return false;
        }
    </script>
</section>

</body>
</html>