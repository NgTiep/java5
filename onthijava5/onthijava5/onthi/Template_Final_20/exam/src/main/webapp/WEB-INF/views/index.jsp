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

    <form action="/phieugiaohang/search" method="get">
        Từ Ngày: <input name="tuNgay">
        Đến Ngày: <input name="denNgay">
        Địa Chỉ:
        <select name="diaChi">
            <c:forEach items="${listDC}" var="dc">
                <option value="${dc.maDiaChi}">${dc.maDiaChi}</option>
            </c:forEach>
        </select>
        <button>Tìm Kiếm</button>
    </form>

    <table class="table">
        <thead>
        <tr>
            <th>Mã Phiếu Giao</th>
            <th>Số Điện Thoại</th>
            <th>Ngày Giao</th>
            <th>Trạng Thái</th>
            <th>Địa Chỉ</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${listPGH.content}" var="pgh">
            <tr>
                <td>${pgh.maPhieuGiao}</td>
                <td>${pgh.soDienThoai}</td>
                <td>${pgh.ngayGiao}</td>
                <td>
                    <c:if test="${pgh.trangThai==0}">Kết Thúc</c:if>
                    <c:if test="${pgh.trangThai==1}">Bắt Đầu</c:if>
                </td>
                <td>${pgh.diaChi.maDiaChi}</td>
                <td>
                    <button><a href="/phieugiaohang/delete/${pgh.maPhieuGiao}" onclick="xoa()">Delete</a></button>
                    <button><a href="/phieugiaohang/detail/${pgh.maPhieuGiao}">Detail</a></button>
                    <button><a href="/phieugiaohang/view-update/${pgh.maPhieuGiao}">Edit</a></button>
                    <button><a href="/phieugiaohang/view-add">Add</a></button>
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
        function xoa() {
            if (confirm("Bạn muốn xóa thông tin ?")) {
                return true;
            } else return false;
        }
    </script>

</section>

</body>
</html>