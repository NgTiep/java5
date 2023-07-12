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

    <form action="/gio-hang/search" method="get">
        Ngày Tạo: <input name="ngayTao">
        Ngày Cập Nhập: <input name="ngayCapNhap">
        Khách Hàng:
        <select name="khachHang">
            <c:forEach items="${listKH}" var="kh">
                <option value="${kh.maKhachHang}">${kh.maKhachHang}-${kh.tenKhachHang}</option>
            </c:forEach>
        </select>
        <button>Search</button>
    </form>

    <form:form action="/gio-hang/add" modelAttribute="gioHang" method="post">
        Ngày Tạo: <form:input path="ngayTao" type="date"/> <form:errors path="ngayTao"/> <br>
        Ngày Cập Nhập: <form:input path="ngayCapNhap" type="date"/> <form:errors path="ngayCapNhap"/> <br>
        Khách Hàng:
        <form:select path="khachHang">
            <c:forEach items="${listKH}" var="kh">
                <option value="${kh.maKhachHang}" ${kh.maKhachHang==gioHang.khachHang.maKhachHang?"selected":""} >${kh.maKhachHang}-${kh.tenKhachHang}</option>
            </c:forEach>
        </form:select>
        <br>
        Ghi Chú: <form:input path="ghiChu"/> <form:errors path="ghiChu"/> <br>
        Trạng Thái:<form:radiobutton value="0" path="trangThai"/> Đã Thanh Toán
        <form:radiobutton value="1" path="trangThai"/> Chưa Thanh Toán
        <br>
        <button onclick="them()">Thêm</button>
    </form:form>


    <table class="table">
        <thead>
        <tr>
            <th style="width: 10%">Mã Giỏ Hàng</th>
            <th style="width: 10%">Ngày Tạo</th>
            <th style="width: 10%">Ngày Cập Nhập</th>
            <th style="width: 10%">Khách Hàng</th>
            <th style="width: 10%">Ghi Chú</th>
            <th style="width: 10%">Trạng Thái</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${listGH.content}" var="gh">
            <tr>
                <td>${gh.maGioHang}</td>
                <td>${gh.ngayTao}</td>
                <td>${gh.ngayCapNhap}</td>
                <td>${gh.khachHang.maKhachHang}-${gh.khachHang.tenKhachHang}</td>
                <td>${gh.ghiChu}</td>
                <td>
                    <c:if test="${gh.trangThai==0}">Đã Thanh Toán</c:if>
                    <c:if test="${gh.trangThai==1}">Chưa Thanh Toán</c:if>
                </td>
                <td>
                    <button><a href="/gio-hang/delete/${gh.maGioHang}" onclick="xoa()">Delete</a></button>
                    <button><a href="/gio-hang/detail/${gh.maGioHang}">Detail</a></button>
                    <button><a href="/gio-hang/view-update/${gh.maGioHang}">Update</a></button>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <a href="/gio-hang/hien-thi?page=0">Frist</a>
    <a href="/gio-hang/hien-thi?page=${listGH.number-1}">Person</a>
    <a href="/gio-hang/hien-thi?page=${listGH.number+1}">Next</a>
    <a href="/gio-hang/hien-thi?page=${listGH.totalPages-1}">Last</a>

    <br>
    <label style="color: red">${mess}</label>
    <br>
    <ul>
        <li>Số Trang: ${listGH.number}</li>
        <li>Tổng Số Trang: ${listGH.totalPages}</li>
        <li>Tổng Số Phần Tử: ${listGH.totalElements}</li>
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