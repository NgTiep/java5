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
    <form:form action="/order/add" method="post" modelAttribute="order">
        <div class="row">
            <div class="col-4">ID:</div>
            <div class="col-8">
                <form:input class="form-control" path="id"/>
                <form:errors path="id" element="div"/>
            </div>
        </div>

        <div class="row">
            <div class="col-4">Address:</div>
            <div class="col-8">
                <form:input class="form-control" path="address"/>
                <form:errors path="address"/>
            </div>
        </div>

        <div class="row">
            <div class="col-4">Date:</div>
            <div class="col-8">
                <form:input type="date"  class="form-control" path="createDate"/>
                <form:errors path="createDate"/>
            </div>
        </div>


        <div class="row mt-2">
            <div class="col-4">Account Name:</div>
            <div class="col-8">
                <form:select path="account" class="form-control">
                    <c:forEach items="${listAccount}" var="account">
                        <option value="${account.username}">${account.username}</option>
                    </c:forEach>
                </form:select>
            </div>
        </div>


        <button class="btn btn-success"><a href="/order/hien-thi" style="text-decoration: none; color: white">Quay lại</a></button>
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
