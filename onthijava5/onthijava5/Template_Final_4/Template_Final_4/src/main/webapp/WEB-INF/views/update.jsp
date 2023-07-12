<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 18/06/2023
  Time: 13:37
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


<form:form action="/phieu-giao-hang/update/${phieuGiaoHang.maPhieuGiao}" method="post" modelAttribute="phieuGiaoHang">
    Người nhận: <form:input path="nguoiNhan"/> <form:errors path="nguoiNhan"/> <br>
    Số Điện Thoại: <form:input path="soDienThoai"/> <form:errors path="soDienThoai"/> <br>
    Ngày Giao: <form:input path="ngayGiao" type="date"/> <form:errors path="ngayGiao"/> <br>
    Ngày Nhận: <form:input path="ngayNhan" type="date"/> <form:errors path="ngayNhan"/> <br>
    Địa chỉ:
    <form:select path="diaChi">
        <c:forEach items="${listDC}" var="dc">
            <option value="${dc.maDiaChi}" ${dc.maDiaChi==phieuGiaoHang.diaChi.maDiaChi?"selected":""}>${dc.tenDiaChi}</option>
        </c:forEach>
    </form:select>
    <br>
    <button>Sửa</button>
</form:form>
</body>
</html>
