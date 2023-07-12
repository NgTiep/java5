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
        Ngày Bắt Đầu: <input type="text" name="ngayBatDau">
        Ngày Kết Thúc: <input type="text" name="ngayKetThuc">
        Khách Hàng:
        <select name="khachhang">
            <c:forEach items="${listKH}" var="kh">
                <option value="${kh.makhachhang}">${kh.makhachhang}</option>
            </c:forEach>
        </select>
        <button>Search</button>
    </form>

    <form:form action="/phieu-giam-gia/add" modelAttribute="phieuGiamGia" method="post">
        Mã Phiếu: <form:input path="maphieu"/> <form:errors path="maphieu"/> <br>
        Tên Phiếu: <form:input path="tenphieu"/> <form:errors path="tenphieu"/> <br>
        Ngày Bắt Đầu: <form:input path="ngaybatdau"/> <form:errors path="ngaybatdau"/> <br>
        Ngày Kết Thúc: <form:input path="ngayketthuc"/> <form:errors path="ngayketthuc"/> <br>
        Giá Trị Giảm: <form:input path="giatrigiam"/> <form:errors path="giatrigiam"/> <br>
        Giá Trị Giảm Tối Đa: <form:input path="giatrigiamtoida"/> <form:errors path="giatrigiamtoida"/> <br>
        Khách Hàng:
        <form:select path="khachhang">
            <c:forEach items="${listKH}" var="kh">
                <option value="${kh.makhachhang}" ${kh.makhachhang==phieuGiamGia.khachhang.makhachhang?"selected":""}>${kh.makhachhang}</option>
            </c:forEach>
        </form:select>
        <br>
        <button onclick="them()">Thêm</button>
    </form:form>


    <table class="table">
        <thead>
        <tr>
            <th>Mã Phiếu</th>
            <th>Tên Phiếu</th>
            <th>Ngày Bắt Đầu</th>
            <th>Ngày Kết Thúc</th>
            <th>Giá Trị Giảm</th>
            <th>Trạng Thái</th>
            <th>Khách Hàng</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${listPGG.content}" var="pgg">
            <tr>
                <td>${pgg.maphieu}</td>
                <td>${pgg.tenphieu}</td>
                <td>${pgg.ngaybatdau}</td>
                <td>${pgg.ngayketthuc}</td>
                <td>${pgg.giatrigiam}</td>
                <td>
                    <c:if test="${pgg.trangthai==0}">Hoạt Động</c:if>
                    <c:if test="${pgg.trangthai==1}">Ngừng Hoạt Động</c:if>
                </td>
                <td>${pgg.khachhang.makhachhang}-${pgg.khachhang.tenkhachhang}</td>
                <td>
                    <button><a href="/phieu-giam-gia/delete/${pgg.maphieu}" onclick="xoa()">Delete</a></button>
                    <button><a href="/phieu-giam-gia/detail/${pgg.maphieu}">Detail</a></button>
                    <button><a href="/phieu-giam-gia/view-update/${pgg.maphieu}">Update</a></button>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <a href="/phieu-giam-gia/hien-thi?page=0">Frist</a>
    <a href="/phieu-giam-gia/hien-thi?page=${listPGG.number-1}">Preson</a>
    <a href="/phieu-giam-gia/hien-thi?page=${listPGG.number+1}">Next</a>
    <a href="/phieu-giam-gia/hien-thi?page=${listPGG.totalPages-1}">Last</a>

    <br>
    <label style="color: red">${mess}</label>
    <br>
    <ul>
        <li>Trang Số: ${listPGG.number}</li>
        <li>Tổng Số Trang: ${listPGG.totalPages}</li>
        <li>Tổng Số Phần Tử: ${listPGG.totalElements}</li>
    </ul>

    <script>
        function them() {
            if (confirm("Bạn muốn thêm thông tin ?")){
                return true;
            }else return false;
        }

        function xoa() {
            if (confirm("Bạn muốn xóa thông tin ?")){
                return true;
            }else return false;
        }
    </script>
</section>

</body>
</html>