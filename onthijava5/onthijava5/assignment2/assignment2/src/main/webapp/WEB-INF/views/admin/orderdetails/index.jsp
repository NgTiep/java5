<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 09/06/2023
  Time: 23:06
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page pageEncoding="utf-8" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap demo</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
</head>
<body>
<div class="container ">
    <table class="table table-striped">
        <thead>
        <tr>
            <th style="width:20%">Tên Sản Phẩm</th>
            <th style="width:10%">Giá Sản Phẩm</th>
            <th style="width:10%">Số Lượng</th>
            <th style="width:20%">Địa Chỉ</th>
            <th style="width:10%">Ngày Mua</th>
            <th style="width:10%"> </th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${listOrderDetail}" var="item">
            <tr>
                <td>${item.product.name}</td>
                <td>${item.price}</td>
                <td>${item.quantity}</td>
                <td>${item.order.address}</td>
                <td>${item.order.createDate}</td>
                <td>
                    <a href="/admin/orderdetails/delete/${item.id}" class="btn btn-sm btn-danger">DELETE</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz"
        crossorigin="anonymous"></script>

<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
        integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.min.js"
        integrity="sha384-fbbOQedDUMZZ5KreZpsbe1LCZPVmfTnH7ois6mU1QK+m14rQ1l2bGBq41eYeM/fS"
        crossorigin="anonymous"></script>
</body>
</html>

