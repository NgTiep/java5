<%@ page pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>LT Buoi 3</title>
</head>
<body>
<center><h1>Quản lý cửa hàng</h1>
    <a href="create">Them</a>
    <table>
        <tr>
            <td>Mã</td>
            <td>Tên</td>
            <td>Địa chỉ</td>
            <td>Thành Phố</td>
            <td>Quốc Gia</td>
            <td>Action</td>
        </tr>
        <c:forEach items="${listCuaHang}" var="ch" varStatus="viTri">
            <tr>
                <td>${ch.ma}</td>
                <td>${ch.ten}</td>
                <td>${ch.diaChi}</td>
                <td>${ch.thanhPho}</td>
                <td>${ch.quocGia}</td>
                <td>
                    <a href="edit/${ch.ma}">Edit</a>
                    <a href="delete/${ch.ma}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>

</center>
</body>
</html>