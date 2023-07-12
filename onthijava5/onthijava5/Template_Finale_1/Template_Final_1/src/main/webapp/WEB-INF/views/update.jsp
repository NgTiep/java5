<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 17/06/2023
  Time: 01:07
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form:form action="/phieu-giam-gia/update/${phieuGiamGia.maphieu}" modelAttribute="phieuGiamGia" method="post">
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
