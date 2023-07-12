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

        <form action="/phieugiamgia/search" method="get" >
            Từ Ngày <input name="ngayBatDau"> <br>
            Đến Ngày <input name="ngayKetThuc"> <br>
            Khách Hàng:
            <select name="khachHang">
                <c:forEach items="${listKH}" var="kh">
                    <option value="${kh.maKhachHang}" >${kh.maKhachHang}</option>
                </c:forEach>
            </select>
            <br>
            <button>Search</button>
        </form>

    <form:form action="/phieugiamgia/add" method="post" modelAttribute="phieuGiamGia">
        Mã Phiếu: <form:input path="maPhieu"/> <form:errors path="maPhieu"/> <br>
        Tên Phiếu: <form:input path="tenPhieu"/> <form:errors path="tenPhieu"/> <br>
        Giá Trị Giảm: <form:input path="giaTriGiam"/> <form:errors path="giaTriGiam"/> <br>
        Giá Trị Giảm Tối Đa: <form:input path="giaTriGiamToiDa"/> <form:errors path="giaTriGiamToiDa"/> <br>
        Ngày Bắt Đầu: <form:input path="ngayBatDau"/> <form:errors path="ngayBatDau"/> <br>
        Ngày Kết Thúc: <form:input path="ngayKetThuc" /> <form:errors path="ngayKetThuc"/> <br>
        Khách Hàng:
        <form:select path="khachHang">
            <c:forEach items="${listKH}" var="kh">
                <option value="${kh.maKhachHang}" ${kh.maKhachHang==phieuGiamGia.khachHang.maKhachHang?"selected":""}>${kh.tenKhachHang}</option>
            </c:forEach>
        </form:select>
        <br>
        <button onclick="add()">ADD</button>
    </form:form>

    <table>
        <thead>
        <tr>
            <th>Mã Phiếu</th>
            <th>Tên Phiếu</th>
            <th>Giá Trị Giảm</th>
            <th>Giá Trị Giảm Tối Đa</th>
            <th>Ngày Bắt Đầu</th>
            <th>Ngày Kết Thúc</th>
            <th>Khách Hàng</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="pgg" items="${listPGG.content}">
            <tr>
                <td>${pgg.maPhieu}</td>
                <td>${pgg.tenPhieu}</td>
                <td>${pgg.giaTriGiam}</td>
                <td>${pgg.giaTriGiamToiDa}</td>
                <td>${pgg.ngayBatDau}</td>
                <td>${pgg.ngayKetThuc}</td>
                <td>${pgg.khachHang.tenKhachHang}</td>
                <td>
                    <button><a href="/phieugiamgia/delete/${pgg.maPhieu}" onclick="xoa()">Delete</a></button>
                    <button><a href="/phieugiamgia/detail/${pgg.maPhieu}">Detail</a></button>
                    <button><a href="/phieugiamgia/view-update/${pgg.maPhieu}">Update</a></button>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
        <br>
    <a href="/phieugiamgia/hien-thi?page=0">Fr</a>
    <a href="/phieugiamgia/hien-thi?page=${listPGG.number-1}">Ps</a>
    <a href="/phieugiamgia/hien-thi?page=${listPGG.number+1}">Nx</a>
    <a href="/phieugiamgia/hien-thi?page=${listPGG.totalPages-1}">Ls</a>
        <br>
        <label style="color: red">${mess}</label>

    <script>
        function add() {
            if (confirm("Ban muon them thong tin ?")){
                return true;
            }else return false;
        }

        function xoa() {
            if (confirm("Ban muon xoa thong tin ?")){
                return true;
            }else return false;
        }
    </script>
</section>

</body>
</html>