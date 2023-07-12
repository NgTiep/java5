<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 18/06/2023
  Time: 09:50
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

<form:form action="/phieu-giao-hang/update/${phieuGiaoHang.maPhieuGiao}" modelAttribute="phieuGiaoHang" method="post">
    Người Nhận: <form:input path="nguoiNhan"/> <form:errors path="nguoiNhan"/> <br>
    Số Điện Thoại: <form:input path="soDienThoai"/> <form:errors path="soDienThoai"/> <br>
    Ngày Giao: <form:input path="ngayGiao"/> <form:errors path="ngayGiao"/> <br>
    Ngày Nhận: <form:input path="ngayNhan"/> <form:errors path="ngayNhan"/> <br>
    Trạng Thái: <form:radiobutton value="0" path="trangThai"/>Đã Thanh Toán
    <form:radiobutton value="1" path="trangThai"/>Chưa Thanh Toán
    <form:errors path="trangThai"/>
    <br>
    Hóa Đơn:
    <form:select path="hoaDon">
        <c:forEach items="${listHD}" var="hd">
            <option value="${hd.maHoaDon}" ${hd.maHoaDon==phieuGiaoHang.hoaDon.maHoaDon?"selected":""}>${hd.maHoaDon}</option>
        </c:forEach>
    </form:select>
    <br>
    <button onclick="sua()">Sửa</button>
</form:form>


<script>
    function sua() {
        if (confirm("Bạn muốn sửa dữ liệu ?")) {
            return true;
        } else{
            return false;
        }
    }
</script>

</body>
</html>
