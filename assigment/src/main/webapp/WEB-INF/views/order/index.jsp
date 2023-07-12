<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 04/06/2023
  Time: 16:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"/>
</head>
<body>

<div class="container mt-3">
    <table class="table">
        <thead>
        <tr>
            <th style="width:10%">ID</th>
            <th style="width:10%">Address</th>
            <th style="width:10%">Createdate</th>
            <th style="width:10%">Account Username</th>
            <th style="width:20%"> </th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="order" items="${listOrder.content}">
            <tr>
                <td>${order.id}</td>
                <td>${order.address}</td>
                <td>${order.createDate}</td>
                <td>${order.account.username}</td>
                <td>
                    <a href="/order/delete/${order.id}" onclick="xoa()" class="btn btn-sm btn-danger">DELETE</a>
                    <a href="/order/view-update/${order.id}" class="btn btn-sm btn-secondary">UPDATE</a>
                    <a href="/order/view-add" class="btn btn-primary btn-sm">ADD</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <a href="/order/hien-thi?number=0" class="btn btn-primary btn-sm">First</a>
    <a href="/order/hien-thi?number=${listOrder.number-1}" class="btn btn-primary btn-sm">Previous</a>
    <a href="/order/hien-thi?number=${listOrder.number+1}" class="btn btn-primary btn-sm">Next</a>
    <a href="/order/hien-thi?number=${listOrder.totalPages-1}" class="btn btn-primary btn-sm">Last</a>

</div>
<script>
    function xoa() {
        if (confirm("Bạn có chắc muốn xóa dữ liệu ?")) {
            return true;
        } else return false;
    }
</script>
</body>
</html>
