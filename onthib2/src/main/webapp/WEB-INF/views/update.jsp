<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 14/06/2023
  Time: 15:34
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

<form:form action="/phieu-giam-gia/update/${phieuGiamGia.maPhieu}" modelAttribute="phieuGiamGia" method="post">
    Tên Phiếu: <form:input path="tenPhieu"/> <form:errors path="tenPhieu"/> <br>
    Giá Trị Giảm: <form:input path="giaTriGiam"/> <form:errors path="giaTriGiam"/> <br>
    Giá Trị Giảm Tối Đa: <form:input path="giaTriGiamToiDa"/> <form:errors path="giaTriGiamToiDa"/> <br>
    Ngày Bắt Đầu: <form:input path="ngayBatDau"/> <form:errors path="ngayBatDau"/> <br>
    Ngày Kết Thúc: <form:input path="ngayKetThuc"/> <form:errors path="ngayKetThuc"/> <br>
    Khách Hàng:
    <form:select path="khachHang">
        <c:forEach items="${listKH}" var="kh">
            <option value="${kh.maKhachHang}" ${kh.maKhachHang==phieuGiamGia.khachHang.maKhachHang?"selected":""}>${kh.maKhachHang}</option>
        </c:forEach>
    </form:select>
    <br>
    <button onclick="update()">Update</button>
</form:form>

<script>
    function update() {
        if(confirm("Bạn muốn sửa thông tin")){
            return true;
        }else return false;
    }


</script>


</body>
</html>
