<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 18/06/2023
  Time: 21:31
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

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
<form:form action="/gio-hang/update/${gioHang.maGioHang}" modelAttribute="gioHang" method="post">
    Ngày Tạo: <form:input path="ngayTao" type="date"/> <form:errors path="ngayTao"/> <br>
    Ngày Cập Nhập: <form:input path="ngayCapNhap" type="date"/> <form:errors path="ngayCapNhap"/> <br>
    Khách Hàng:
    <form:select path="khachHang">
        <c:forEach items="${listKH}" var="kh">
            <option value="${kh.maKhachHang}" ${kh.maKhachHang==gioHang.khachHang.maKhachHang?"selected":""} >${kh.maKhachHang}-${kh.tenKhachHang}</option>
        </c:forEach>
    </form:select>
    <br>
    Ghi Chú: <form:input path="ghiChu"/> <form:errors path="ghiChu"/> <br>
    Trạng Thái:<form:radiobutton value="0" path="trangThai"/> Đã Thanh Toán
    <form:radiobutton value="1" path="trangThai"/> Chưa Thanh Toán
    <br>
    <button onclick="sua()">Sửa</button>
</form:form>

<script>
    function sua() {
        if (confirm("Bạn muốn sửa thông tin ?")){
            return true;
        }else return false;
    }
</script>
</body>
</html>

