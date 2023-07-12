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

<form:form action="/phieu-giam-gia/update/${phieuGiamGia.maPhieu}" method="post" modelAttribute="phieuGiamGia">
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
    <button>Update</button>
</form:form>

</body>
</html>
