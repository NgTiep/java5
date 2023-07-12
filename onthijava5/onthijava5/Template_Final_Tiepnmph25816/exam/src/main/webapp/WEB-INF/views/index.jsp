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

    <form:form action="/gio-hang/add" method="post" modelAttribute="gioHang">
        Ghi Chú: <form:input path="ghiChu"/>
        <form:errors path="ghiChu"/> <br>
        Mã Khách Hàng:
        <form:select path="khachHang">
            <option value="">-------</option>
            <c:forEach items="${listKH}" var="kh">
                <option value="${kh.maKhachHang}" ${kh.maKhachHang==gioHang.khachHang.maKhachHang?"selected":""}>${kh.maKhachHang}</option>
            </c:forEach>
        </form:select>
        <label>${error}</label>
        <br>
        Trạng Thái:<form:radiobutton path="trangThai" value="0"/> Ngừng Hoạt Động
        <form:radiobutton path="trangThai" value="1"/> Hoạt Động
        <br>
        <button onclick="them()">Thêm</button>
    </form:form>

    <button onclick="sapXep()"><a href="/gio-hang/sort">Sort</a></button>


    <table class="table">
        <thead>
        <tr>
            <th>Mã Giỏ Hàng</th>
            <th>Mã Khách Hàng</th>
            <th>SĐT Khách Hàng</th>
            <th>Ghi Chú</th>
            <th>Trạng Thái</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${listGH.content}" var="gh">
            <tr>
                <td>${gh.maGioHang}</td>
                <td>${gh.khachHang.maKhachHang}</td>
                <td>${gh.khachHang.soDienThoai}</td>
                <td>${gh.ghiChu}</td>
                <td>
                    <c:if test="${gh.trangThai==0}">Ngừng Hoạt Động</c:if>
                    <c:if test="${gh.trangThai==1}"> Hoạt Động</c:if>
                </td>
                <td>
                    <button><a href="/gio-hang/view-update/${gh.maGioHang}">Edit</a></button>
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
        function them() {
            if (confirm("Bạn muốn thêm dữ liệu ?")) {
                return true;
            } else return false;
        }

        function sapXep() {
            if (confirm("Bạn muốn sắp xếp dữ liệu ?")) {
                return true;
            } else return false;
        }
    </script>

</section>
</body>
</html>