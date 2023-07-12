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
            <th style="width:20%">Username</th>
            <th style="width:20%">Password</th>
            <th style="width:20%">FullName</th>
            <th style="width:20%">Email</th>
            <th style="width:20%"></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="account" items="${listAccount.content}">
            <tr>
                <td>${account.username}</td>
                <td>${account.password}</td>
                <td>${account.fullname}</td>
                <td>${account.email}</td>
                <td>
                    <a href="/account/delete/${account.username}" onclick="xoa()" class="btn btn-sm btn-danger">DELETE</a>
                    <a href="/account/view-update/${account.username}" class="btn btn-sm btn-secondary">UPDATE</a>
                    <a href="/account/view-add" class="btn btn-primary btn-sm">ADD</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <br>

    <a href="/account/hien-thi?number=0" class="btn btn-primary btn-sm">First</a>
    <a href="/account/hien-thi?number=${listAccount.number-1}" class="btn btn-primary btn-sm">Previous</a>
    <a href="/account/hien-thi?number=${listAccount.number+1}" class="btn btn-primary btn-sm">Next</a>
    <a href="/account/hien-thi?number=${listAccount.totalPages-1}" class="btn btn-primary btn-sm">Last</a>

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
