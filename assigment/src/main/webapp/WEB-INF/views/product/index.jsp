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
            <th style="width:10%">Name</th>
            <th style="width:10%">Price</th>
            <th style="width:10%">Category Name</th>
            <th style="width:20%">Date</th>
            <th style="width:20%"> </th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="product" items="${listProduct.content}">
            <tr>
                <td>${product.id}</td>
                <td>${product.name}</td>
                <td>${product.price}</td>
                <td>${product.category.name}</td>
                <td>${product.createDate}</td>
                <td>
                    <a href="/product/delete/${product.id}" onclick="xoa()" class="btn btn-sm btn-danger">DELETE</a>
                    <a href="/product/view-update/${product.id}" class="btn btn-sm btn-secondary">UPDATE</a>
                    <a href="/product/view-add" class="btn btn-primary btn-sm">ADD</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <a href="/product/hien-thi?number=0" class="btn btn-primary btn-sm">First</a>
    <a href="/product/hien-thi?number=${listProduct.number-1}" class="btn btn-primary btn-sm">Previous</a>
    <a href="/product/hien-thi?number=${listProduct.number+1}" class="btn btn-primary btn-sm">Next</a>
    <a href="/product/hien-thi?number=${listProduct.totalPages-1}" class="btn btn-primary btn-sm">Last</a>

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
