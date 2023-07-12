<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 16/06/2023
  Time: 23:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>


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
<main>
    <form:form action="/khach-hang/update/${khachHang.maKH}" method="post" modelAttribute="khachHang">
        Tên Khách Hàng: <form:input path="tenKH"/> <form:errors path="tenKH"/> <br>
        Số Điện Thoại: <form:input path="sdt"/> <form:errors path="sdt"/> <br>
        Giới Tính: <form:radiobutton value="true" path="gioiTinh"/> Nam
        <form:radiobutton value="false" path="gioiTinh"/> Nữ
        <form:errors path="gioiTinh"/> <br>
        Hạng Khách Hàng:
        <form:select path="hangKhachHang">
            <c:forEach items="${listHKH}" var="hkh">
                <option value="${hkh.maHang}" ${hkh.maHang==khachHang.hangKhachHang.maHang?"selected":""}>${hkh.maHang}</option>
            </c:forEach>
        </form:select>
        <br>
        <button onclick="sua()">Update</button>
    </form:form>

    <script>
        function sua() {
            if(confirm("Bạn muốn sửa thông tin ?")){
                return true;
            }else return  false
        }
    </script>
</main>
</body>
</html>

