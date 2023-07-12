<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 04/06/2023
  Time: 22:29
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"/>

</head>
<body>


<div class="container mt-3">
    <form:form action="/account/add" method="post" modelAttribute="account">
        <div class="row">
            <div class="col-4">Username:</div>
            <div class="col-8">
                <form:input class="form-control" path="username"/>
                <form:errors path="username" element="div"/>
            </div>
        </div>

        <div class="row">
            <div class="col-4">Password:</div>
            <div class="col-8">
                <form:input class="form-control" path="password"/>
                <form:errors path="password"/>
            </div>
        </div>

        <div class="row mt-2">
            <div class="col-4">Fullname:</div>
            <div class="col-8">
                <form:input class="form-control" path="fullname"/>
                <form:errors path="fullname"/>
            </div>
        </div>

        <div class="row mt-2">
            <div class="col-4">Email:</div>
            <div class="col-8">
                <form:input class="form-control" path="email"/>
                <form:errors path="email"/>
            </div>
        </div>


        <button class="btn btn-success"><a href="/account/hien-thi" style="text-decoration: none; color: white">Quay lại</a></button>
        <button class="btn btn-primary" onclick="them()"> Lưu lại</button>
    </form:form>
</div>
<script>
    function them() {
        if (confirm("Bạn có chắc muốn thêm dữ liệu ?")) {
            return true;
        } else return false;
    }
</script>

</body>
</html>
