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

    <form action="/khach-hang/search" method="get">
        Nhập giá trị: <input name="nhapGiaTri">
        Hạng Khách Hàng:
        <select name="hangKhachHang">
            <c:forEach items="${listHKH}" var="hkh">
                <option value="${hkh.maHang}">${hkh.maHang}-${hkh.tenHang}</option>
            </c:forEach>
        </select>
        <button>Tìm Kiếm</button>
    </form>

    <form:form action="/khach-hang/add" modelAttribute="khachHang" method="post">
        Tên Khách Hàng: <form:input path="tenKhachHang"/> <form:errors path="tenKhachHang"/> <br>
        Số Điện Thoại: <form:input path="soDienThoai"/> <form:errors path="soDienThoai"/> <br>
        Giới Tính: <form:radiobutton path="gioiTinh" value="true"/> Nam
        <form:radiobutton path="gioiTinh" value="false"/> Nữ
        <form:errors path="gioiTinh"/> <br>
        Hạng Khách Hàng:
        <form:select path="hangKhachHang">
            <c:forEach items="${listHKH}" var="hkh">
                <option value="${hkh.maHang}" ${hkh.maHang==khachHang.hangKhachHang.maHang?"selected":""} >${hkh.maHang}-${hkh.tenHang}</option>
            </c:forEach>
        </form:select>
        <br>
        <button onclick="them()">Thêm</button>
    </form:form>


    <table class="table">
        <thead>
        <tr>
            <th style="width: 2%;">#</th>
            <th style="width: 2%;">Mã Khách Hàng</th>
            <th style="width: 2%;">Tên Khách Hàng</th>
            <th style="width: 2%;">Số Điện Thoại</th>
            <th style="width: 2%;">Giới Tính</th>
            <th style="width: 2%;">Hạng Khách Hàng</th>
            <th style="width: 2%;"></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${listKH.content}" var="kh" varStatus="i">
            <tr>
                <td>${i.index+1}</td>
                <td>${kh.maKhachHang}</td>
                <td>${kh.tenKhachHang}</td>
                <td>${kh.soDienThoai}</td>
                <td>
                    <c:if test="${kh.gioiTinh==true}">Nam</c:if>
                    <c:if test="${kh.gioiTinh==false}">Nữ</c:if>
                </td>
                <td>${kh.hangKhachHang.maHang}-${kh.hangKhachHang.tenHang}</td>
                <td>
                    <button><a href="/khach-hang/delete/${kh.maKhachHang}" onclick="xoa()">Delete</a></button>
                    <button><a href="/khach-hang/detail/${kh.maKhachHang}">Detail</a></button>
                    <button><a href="/khach-hang/view-update/${kh.maKhachHang}">Update</a></button>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <a href="/khach-hang/hien-thi?page=0">Frist</a>
    <a href="/khach-hang/hien-thi?page=${listKH.number-1}">Person</a>
    <a href="/khach-hang/hien-thi?page=${listKH.number+1}">Next</a>
    <a href="/khach-hang/hien-thi?page=${listKH.totalPages-1}">Last</a>

    <br>
    <label style="color:red;">${mess}</label>
    <br>
    <ul>
        <li>Số Trang Hiện Tại: ${listKH.number}</li>
        <li>Tổng Số Trang: ${listKH.totalPages}</li>
        <li>Tổng Số Phần Tử: ${listKH.totalElements}</li>
    </ul>

    <script>
        function them() {
            if (confirm("Bạn muốn thêm  dữ liệu ?")) {
                return true
            }
        }

        function xoa() {
            if (confirm("Bạn muốn xóa  dữ liệu ?")) {
                return true
            }
        }
    </script>

</section>
</body>
</html>