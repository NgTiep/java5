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

    <form action="/phieugiaohang/search" method="get">
        Ngày Giao: <input name="ngayGiao">
        Ngày Nhận: <input name="ngayNhan">
        Hóa Đơn:
        <select name="hoaDon">
            <c:forEach items="${listHD}" var="hd">
                <option value="${hd.maHoaDon}">${hd.maHoaDon}-${hd.nguoiLap}</option>
            </c:forEach>
        </select>
        <button>Search</button>
    </form>

    <form:form action="/phieugiaohang/add" modelAttribute="phieuGiaoHang" method="post">
        Người Nhận: <form:input path="nguoiNhan"/> <form:errors path="nguoiNhan"/> <br>
        Số Điện Thoại: <form:input path="soDienThoai"/> <form:errors path="soDienThoai"/> <br>
        Ngày Giao: <form:input path="ngayGiao"/> <form:errors path="ngayGiao"/> <br>
        Ngày Nhận: <form:input path="ngayNhan"/> <form:errors path="ngayNhan"/> <br>
        Hóa Đơn:
        <form:select path="hoaDon">
            <form:option value="">-----</form:option>
            <c:forEach items="${listHD}" var="hd">
                <option value="${hd.maHoaDon}" ${hd.maHoaDon==phieuGiaoHang.hoaDon.maHoaDon?"selected":""}>${hd.maHoaDon}-${hd.nguoiLap}</option>
            </c:forEach>
        </form:select>
        <label>${errorHD}</label>
        <br>
        <button onclick="them()">Thêm</button>
    </form:form>

    <table class="table">
        <thead>
        <tr>
            <th style="width: 2%">Người Nhận</th>
            <th style="width: 2%">Số Điện Thoại</th>
            <th style="width: 2%">Ngày Giao</th>
            <th style="width: 2%">Ngày Nhận</th>
            <th style="width: 2%">Trạng Thái</th>
            <th style="width: 2%">Hóa Đơn</th>
            <th style="width: 2%"> </th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${listPGH.content}" var="pgh">
            <tr>
                <td>${pgh.nguoiNhan}</td>
                <td>${pgh.soDienThoai}</td>
                <td>${pgh.ngayGiao}</td>
                <td>${pgh.ngayNhan}</td>
                <td>
                    <c:if test="${pgh.trangThai==0}">Kết Thúc</c:if>
                    <c:if test="${pgh.trangThai==1}">Chưa Kết Thúc</c:if>
                </td>
                <td>${pgh.hoaDon.maHoaDon}-${pgh.hoaDon.nguoiLap}</td>
                <td>
                    <button><a href="/phieugiaohang/delete/${pgh.maPhieuGiao}" onclick="xoa()">Delete</a></button>
                    <button><a href="/phieugiaohang/detail/${pgh.maPhieuGiao}">Detail</a></button>
                    <button><a href="/phieugiaohang/view-update/${pgh.maPhieuGiao}">Update</a></button>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <a href="/phieugiaohang/hien-thi?page=0">Frist</a>
    <a href="/phieugiaohang/hien-thi?page=${listPGH.number-1}">Person</a>
    <a href="/phieugiaohang/hien-thi?page=${listPGH.number+1}">Next</a>
    <a href="/phieugiaohang/hien-thi?page=${listPGH.totalPages-1}">Last</a>
    <br>
    <label style="color: red">${mess}</label>
    <br>
    <ul>
        <li>Số Trang Hiện Tại: ${listPGH.number}</li>
        <li>Tổng Số Trang: ${listPGH.totalPages}</li>
        <li>Tổng Số Phần Tử: ${listPGH.totalElements}</li>
    </ul>
    <script>
        function them() {
            if (confirm("Bạn muốn thêm dữ liệu ?")){
                return true;
            }
        }

        function xoa() {
            if (confirm("Bạn muốn xóa dữ liệu ?")){
                return true;
            }
        }
    </script>
</section>

</body>
</html>