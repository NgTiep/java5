<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 13/06/2023
  Time: 21:41
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

<form:form action="/phieugiamgia/update/${phieuGiamGia.maPhieu}" method="post" modelAttribute="phieuGiamGia">
    Tên Phiếu: <form:input path="tenPhieu"/> <form:errors path="tenPhieu"/> <br>
    Giá Trị Giảm: <form:input path="giaTriGiam"/> <form:errors path="giaTriGiam"/> <br>
    Giá Trị Giảm Tối Đa: <form:input path="giaTriGiamToiDa"/> <form:errors path="giaTriGiamToiDa"/> <br>
    Ngày Bắt Đầu: <form:input path="ngayBatDau" type="date"/> <form:errors path="ngayBatDau"/> <br>
    Ngày Kết Thúc: <form:input path="ngayKetThuc" type="date"/> <form:errors path="ngayKetThuc"/> <br>
    Khách Hàng:
    <form:select path="khachHang">
        <c:forEach items="${listKH}" var="kh">
            <option value="${kh.maKhachHang}" ${kh.maKhachHang==phieuGiamGia.khachHang.maKhachHang?"selected":""}>${kh.tenKhachHang}</option>
        </c:forEach>
    </form:select>
    <br>
    <button onclick="update()">Update</button>
</form:form>

<script>
    function update() {
        if (confirm("Ban muon sua thong tin ?")){
            return true;
        }else return false;
    }

</script>

</body>
</html>
