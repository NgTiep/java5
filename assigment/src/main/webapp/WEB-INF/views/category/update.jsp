<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 04/06/2023
  Time: 22:30
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
    <form:form action="/category/update/${category.id}" method="post" modelAttribute="category">
        <div class="row">
            <div class="col-4">ID:</div>
            <div class="col-8">
                <form:input class="form-control" path="id"/>
                <form:errors path="id"/>
            </div>
        </div>

        <div class="row mt-2">
            <div class="col-4">Name:</div>
            <div class="col-8">
                <form:input class="form-control" path="name"/>
                <form:errors path="name"/>
            </div>
        </div>

        <button class="btn btn-success"><a href="/category/hien-thi" style="text-decoration: none; color: white">Quay lại</a></button>
        <button class="btn btn-primary" onclick="sua()"> Lưu lại</button>
    </form:form>
</div>
<script>
    function sua() {
        if (confirm("Bạn có chắc muốn sửa dữ liệu ?")) {
            return true;
        } else return false;
    }
</script>

</body>
</html>
