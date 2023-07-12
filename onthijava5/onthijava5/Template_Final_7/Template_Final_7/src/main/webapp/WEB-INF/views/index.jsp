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
    <form action="/danh-sach/search" method="get">
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

    <form:form action="/danh-sach/add" modelAttribute="danhSach" method="post">
        Ngày Tạo: <form:input path="ngayTao" type="date"/> <form:errors path="ngayTao"/> <br>
        Ngày Cập Nhập: <form:input path="ngayCapNhap" type="date"/> <form:errors path="ngayCapNhap"/> <br>
        Ghi Chú:<form:input path="ghiChu" /> <form:errors path="ghiChu"/> <br>
        Trạng Thái:<form:radiobutton value="0" path="trangThai"/> Đã Có
        <form:radiobutton value="1" path="trangThai"/> Chưa Có
        <form:errors path="trangThai"/> <br>
        Khách Hàng:
        <form:select path="khachHang">
            <c:forEach items="${listKH}" var="kh">
                <option value="${kh.maKhachHang}" ${kh.maKhachHang==danhSach.khachHang.maKhachHang?"selected":""}>${kh.maKhachHang}-${kh.tenKhachHang}</option>
            </c:forEach>
        </form:select>
        <br>
        <button>Thêm</button>
    </form:form>

    <table class="table">
        <thead>
        <tr>
            <th style="width: 10%">Mã Danh Sách</th>
            <th style="width: 10%">Ngày Tạo</th>
            <th style="width: 10%">Ngày Cập Nhập</th>
            <th style="width: 10%">Ghi Chú</th>
            <th style="width: 10%">Trạng Thái</th>
            <th style="width: 10%">Khách Hàng</th>
            <th style="width: 10%"></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${listDSYT.content}" var="ds">
            <tr>
                <td>${ds.maDanhSach}</td>
                <td>${ds.ngayTao}</td>
                <td>${ds.ngayCapNhap}</td>
                <td>${ds.ghiChu}</td>
                <td>
                    <c:if test="${ds.trangThai==0}">Đã Có</c:if>
                    <c:if test="${ds.trangThai==1}">Chưa Có</c:if>
                </td>
                <td>${ds.khachHang.maKhachHang}-${ds.khachHang.tenKhachHang}</td>
                <td>
                    <button><a href="/danh-sach/delete/${ds.maDanhSach}">Delete</a></button>
                    <button><a href="/danh-sach/detail/${ds.maDanhSach}">Detail</a></button>
                    <button><a href="/danh-sach/view-update/${ds.maDanhSach}">Update</a></button>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <br>
    <label style="color: red">${mess}</label>
</section>
</body>
</html>