<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 14/06/2023
  Time: 15:34
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<section class="container">
    <form action="/phieugiamgia/search" method="get" >
        Từ Ngày <input name="tuNgay"> <br>
        Đến Ngày <input name="denNgay"> <br>
        Khách Hàng:
        <select name="khachHang">
            <c:forEach items="${listKH}" var="kh">
                <option value="${kh.maKhachHang}" >${kh.maKhachHang}</option>
            </c:forEach>
        </select>
        <br>
        <button>Search</button>
    </form>
<%--    <form:form action="/phieu-giam-gia/add" modelAttribute="phieuGiamGia" method="post">--%>
<%--        Mã Phiếu: <form:input path="maPhieu"/> <form:errors path="maPhieu"/> <br>--%>
<%--        Tên Phiếu: <form:input path="tenPhieu"/> <form:errors path="tenPhieu"/> <br>--%>
<%--        Giá Trị Giảm: <form:input path="giaTriGiam"/> <form:errors path="giaTriGiam"/> <br>--%>
<%--        Giá Trị Giảm Tối Đa: <form:input path="giaTriGiamToiDa"/> <form:errors path="giaTriGiamToiDa"/> <br>--%>
<%--        Ngày Bắt Đầu: <form:input path="ngayBatDau"/> <form:errors path="ngayBatDau"/> <br>--%>
<%--        Ngày Kết Thúc: <form:input path="ngayKetThuc"/> <form:errors path="ngayKetThuc"/> <br>--%>
<%--        Khách Hàng:--%>
<%--        <form:select path="khachHang">--%>
<%--            <c:forEach items="${listKH}" var="kh">--%>
<%--                <option value="${kh.maKhachHang}" ${kh.maKhachHang==phieuGiamGia.khachHang.maKhachHang?"selected":""}>${kh.maKhachHang}</option>--%>
<%--            </c:forEach>--%>
<%--        </form:select>--%>
<%--        <br>--%>
<%--        <button onclick="add()">ADD</button>--%>
<%--    </form:form>--%>

    <table>
        <thead>
        <tr>
            <th>Mã Phiếu</th>
            <th>Tên Phiếu</th>
            <th>Giá Trị Giảm</th>
            <th>Giá Trị Giảm Tối Đa</th>
            <th>Ngày Bắt Đầu</th>
            <th>Ngày Kết Thúc</th>
            <th>Trạng Thái</th>
            <th>Khách Hàng</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${listPGG.content}" var="pgg">
            <tr>
                <td>${pgg.maPhieu}</td>
                <td>${pgg.tenPhieu}</td>
                <td>${pgg.giaTriGiam}</td>
                <td>${pgg.giaTriGiamToiDa}</td>
                <td>${pgg.ngayBatDau}</td>
                <td>${pgg.ngayKetThuc}</td>
                <td>
                    <c:if test="${pgg.trangThai==0}">Kết Thúc</c:if>
                    <c:if test="${pgg.trangThai==1}">Chưa Kết Thúc</c:if>
                </td>
                <td>${pgg.khachHang.tenKhachHang}</td>
<%--                <td>--%>
<%--                    <button><a href="/phieu-giam-gia/delete/${pgg.maPhieu}" onclick="xoa()">Delete</a></button>--%>
<%--                    <button><a href="/phieu-giam-gia/detail/${pgg.maPhieu}">Detail</a></button>--%>
<%--                    <button><a href="/phieu-giam-gia/view-update/${pgg.maPhieu}">Update</a></button>--%>
<%--                </td>--%>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <a href="/phieu-giam-gia/hien-thi?page=0">Frist</a>
    <a href="/phieu-giam-gia/hien-thi?page=${listPGG.number-1}">Pesion</a>
    <a href="/phieu-giam-gia/hien-thi?page=${listPGG.number+1}">Next</a>
    <a href="/phieu-giam-gia/hien-thi?page=${listPGG.totalPages-1}">Last</a>

    <script>
        function xoa() {
            if (confirm("Bạn muốn xóa thông tin")) {
                return true;
            } else return false;
        }

        function add() {
            if (confirm("Bạn muốn thêm thông tin")) {
                return true;
            } else return false;
        }
    </script>

    <br>
    <label style="color: red">${mess}</label>
</section>

</body>
</html>
