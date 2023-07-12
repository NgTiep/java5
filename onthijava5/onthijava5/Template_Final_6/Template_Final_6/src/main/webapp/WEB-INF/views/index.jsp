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
    <form action="/the-thanh-vien/search" method="get">
        Ngày Phát Hành: <input name="ngayPhatHanh">
        Ngày Hủy: <input name="ngayHuy">
        Khách Hàng:
        <select name="khachHang">
            <c:forEach items="${listKH}" var="kh">
                <option value="${kh.maKhachHang}">${kh.maKhachHang}-${kh.tenKhachHang}</option>
            </c:forEach>
        </select>
        <button>Search</button>
    </form>


    <form:form action="/the-thanh-vien/add" method="post" modelAttribute="theThanhVien">
        Mã Thẻ: <form:input path="maThe"/> <form:errors path="maThe"/> <br>
        Màu Thẻ: <form:input path="mauThe"/> <form:errors path="mauThe"/> <br>
        Loại Thẻ:
        <form:select path="loaiThe">
            <form:option value="Loại 1">Loại 1</form:option>
            <form:option value="Loại 2">Loại 2</form:option>
            <form:option value="Loại 3">Loại 3</form:option>
            <form:option value="Loại 4">Loại 4</form:option>
        </form:select>
        <br>
        Ngày Phát Hành: <form:input path="ngayPhatHanh" type="date"/> <form:errors path="ngayPhatHanh"/> <br>
        Ngày Hủy: <form:input path="ngayHuy" type="date"/> <form:errors path="ngayHuy"/> <br>
        Khách Hàng:
        <form:select path="khachHang">
            <c:forEach items="${listKH}" var="kh">
                <option value="${kh.maKhachHang}" ${kh.maKhachHang==theThanhVien.khachHang.maKhachHang?"selected":""}>${kh.maKhachHang}-${kh.tenKhachHang}</option>
            </c:forEach>
        </form:select>
        <br>
        <button>Thêm</button>
    </form:form>

    <table class="table">
        <thead>
        <tr>
            <th style="width: 10%">Mã Thẻ</th>
            <th style="width: 10%">Màu Thẻ</th>
            <th style="width: 10%">Loại Thẻ</th>
            <th style="width: 10%">Ngày Phát Hành</th>
            <th style="width: 10%">Ngày Hủy</th>
            <th style="width: 10%">Trạng Thái</th>
            <th style="width: 10%">Khách Hàng</th>
            <th> </th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${listTTV.content}" var="ttv">
            <tr>
                <td>${ttv.maThe}</td>
                <td>${ttv.mauThe}</td>
                <td>${ttv.loaiThe}</td>
                <td>${ttv.ngayPhatHanh}</td>
                <td>${ttv.ngayHuy}</td>
                <td>
                    <c:if test="${ttv.trangThai==0}">Đã Có</c:if>
                    <c:if test="${ttv.trangThai==1}">Chưa Có</c:if>
                </td>
                <td>${ttv.khachHang.maKhachHang}-${ttv.khachHang.tenKhachHang}</td>
                <td>
                    <button><a href="/the-thanh-vien/delete/${ttv.maThe}">Delete</a></button>
                    <button><a href="/the-thanh-vien/detail/${ttv.maThe}">Detail</a></button>
                    <button><a href="/the-thanh-vien/view-update/${ttv.maThe}">Update</a></button>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <a href="/the-thanh-vien/hien-thi?page=0">Frist</a>
    <a href="/the-thanh-vien/hien-thi?page=${listTTV.number-1}">Person</a>
    <a href="/the-thanh-vien/hien-thi?page=${listTTV.number+1}">Next</a>
    <a href="/the-thanh-vien/hien-thi?page=${listTTV.totalPages-1}">Last</a>
    <br>
    <label style="color: red">${mess}</label>
    <br>
    <ul>
        <li>Số Trang: ${listTTV.number}</li>
        <li>Tổng Số Trang: ${listTTV.totalPages}</li>
        <li>Tổng Số Thực Thể: ${listTTV.totalElements}</li>
    </ul>
</section>

</body>
</html>