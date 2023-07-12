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

    <form action="/gio-hang/search" method="get">
        Ngày Tạo: <input name="ngayTao">
        Ngày Cập Nhập: <input name="ngayCapNhap">
        Khách Hàng:
        <select name="khachHang">
            <c:forEach items="${listKH}" var="kh">
                <option value="${kh.maKhachHang}">${kh.maKhachHang}-${kh.tenKhachHang}</option>
            </c:forEach>
        </select>
        <label>${thongBao}</label>
        <button>Tìm Kiếm</button>
    </form>

    <table class="table">
        <thead>
        <tr>
            <th>Mã Giỏ Hàng</th>
            <th>Ngày Tạo</th>
            <th>Ngày Cập Nhập</th>
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
                <td>
                    <c:if test="${gh.trangThai==0}">Kết Thúc</c:if>
                    <c:if test="${gh.trangThai==1}">Bắt Đầu</c:if>
                </td>
                <td>${gh.khachHang.maKhachHang}-${gh.khachHang.tenKhachHang}</td>
                <td>
                    <button><a href="/gio-hang/delete/${gh.maGioHang}" onclick="xoa()">Delete</a></button>
                    <button><a href="/gio-hang/detail/${gh.maGioHang}">Detail</a></button>
                    <button><a href="/gio-hang/view-update/${gh.maGioHang}">Update</a></button>
                    <button><a href="/gio-hang/view-add">Add</a></button>

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
        <li>Số Trang Hiện Tại: ${listGH.number}</li>
        <li>Tổng Số Trang: ${listGH.totalPages}</li>
        <li>Tổng Số Phần Tử: ${listGH.totalElements}</li>
    </ul>
    <script>
        function xoa() {
            if (confirm("Bạn xóa thêm thông tin?")){
                return true;
            }
        }
    </script>
</section>

</body>
</html>