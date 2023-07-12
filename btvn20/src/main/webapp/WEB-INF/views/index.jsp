<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 12/06/2023
  Time: 21:50
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<section class="container">

    <form:form action="/phieu-giam-gia/search" method="get">
        Từ Ngày: <input name="tuNgay">
        Đến Ngày: <input  name="denNgay">
        Mã Khách Hàng:
        <select name="khachHang">
            <c:forEach items="${listKhachHang}" var="kh">
                <option value="${kh.ma}">${kh.ma}</option>
            </c:forEach>
        </select>
        <button>Search</button>
    </form:form>

    <form:form action="/phieu-giam-gia/add" method="post" modelAttribute="phieuGiamGia">
        Mã Giảm Giá: <form:input path="maPhieu"/> <form:errors path="maPhieu"/> <br>
        Tên Phiếu: <form:input path="tenPhieu"/> <form:errors path="tenPhieu"/> <br>
        Giá Trị Giảm : <form:input path="giaTriGiam"/> <form:errors path="giaTriGiam"/> <br>
        Giá Trị Giảm Tối Đa : <form:input path="giaTriGiamToiDa"/> <form:errors path="giaTriGiamToiDa"/> <br>
        Ngày Bắt Đầu: <form:input path="ngayBatDau" type="date"/> <form:errors path="ngayBatDau"/> <br>
        Ngày Kết Thúc: <form:input path="ngayKetThuc" type="date"/> <form:errors path="ngayKetThuc"/> <br>
        Mã Khách Hàng:
        <form:select path="khachHang">
            <c:forEach var="kh" items="${listKhachHang}">
                <option value="${kh.ma}" ${kh.ma==phieuGiamGia.khachHang.ma?"selected":""}>${kh.ma}</option>
            </c:forEach>
        </form:select>
        <br>
        <button>ADD</button>
    </form:form>

    <table>
        <thead>
        <tr>
            <th>Mã Giảm Giá</th>
            <th>Tên Phiếu</th>
            <th>Giá Trị Giảm </th>
            <th>Giá Trị Giảm Tối Đa</th>
            <th>Ngày Bắt Đầu</th>
            <th>Ngày Kết Thúc</th>
            <th>Trạng Thái</th>
            <th>Tên Khách Hàng</th>
            <th> </th>
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
                <td>${pgg.khachHang.ten}</td>
                <td>
                    <button><a href="/phieu-giam-gia/delete/${pgg.maPhieu}">Delete</a></button>
                    <button><a href="/phieu-giam-gia/detail/${pgg.maPhieu}">Detail</a></button>
                    <button><a href="/phieu-giam-gia/view-update/${pgg.maPhieu}">Update</a></button>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <a href="/phieu-giam-gia/hien-thi?page=0">Fr</a>
    <a href="/phieu-giam-gia/hien-thi?page=${listPGG.number-1}">Ps</a>
    <a href="/phieu-giam-gia/hien-thi?page=${listPGG.number+1}">Nx</a>
    <a href="/phieu-giam-gia/hien-thi?page=${listPGG.totalPages-1}">Ls</a>

    <br>
    <label>${mess}</label>
</section>

</body>
</html>
