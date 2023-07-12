<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 19/06/2023
  Time: 00:02
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form:form action="/danh-sach/update/${danhSach.maDanhSach}" modelAttribute="danhSach" method="post">
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
    <button>Sửa</button>
</form:form>

</body>
</html>
