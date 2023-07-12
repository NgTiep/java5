<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 05/06/2023
  Time: 22:56
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

<form:form action="/co-so/update/${coSo.id}" method="post" modelAttribute="coSo">
    Mã Cơ Sở: <form:input path="ma"/> <form:errors path="ma"/><br>
    Mã Tài Khoản Ngân Hàng:
    <form:select path="taiKhoanNganHang">
        <c:forEach var="tknh" items="${listTKNH}">
            <option value="${tknh.id}" ${tknh.id==coSo.taiKhoanNganHang.id?"selected":""}>${tknh.ma}</option>
        </c:forEach>
    </form:select>
    <br>
    Số Điện Thoại: <form:input path="soDienThoai"/> <form:errors path="soDienThoai"/><br>
    Ghi Chú: <form:input path="ghiChu"/> <form:errors path="ghiChu"/><br>
    Trạng Thái:
    <form:radiobutton value="0" path="trangThai"/> Hoạt Động
    <form:radiobutton value="1" path="trangThai"/> Ngừng Hoạt Động
    <form:errors path="trangThai"/>
    <br>
    <button>UpDate</button>
</form:form>



</body>
</html>
