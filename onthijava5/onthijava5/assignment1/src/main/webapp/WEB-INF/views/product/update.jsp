<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 22/05/2023
  Time: 18:19
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"/>

<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="container mt-3">
    <form:form action="/product/update/${product.id}" method="post" modelAttribute="product">

<%--        <div class="row">--%>
<%--            <div class="col-4">ID:</div>--%>
<%--            <div class="col-8">--%>
<%--                <form:input class="form-control" placeholder="ID"  path="id"/>--%>
<%--                <form:errors path="id"/>--%>
<%--            </div>--%>
<%--        </div>--%>

        <div class="row">
            <div class="col-4">Tên sản phẩm:</div>
            <div class="col-8">
                <form:input  class="form-control" placeholder="Tên sản phẩm" path="name"/>
                <form:errors path="name"/>

            </div>
        </div>
        <div class="row mt-2">
            <div class="col-4">Nhóm sản phẩm:</div>
            <div class="col-8">
                <form:select path="category.id" class="form-control" placeholder="Tên sản phẩm">
                    <option value="">----</option>
                    <form:options items="${categoryList}"
                                  itemLabel="name" itemValue="id"
                    />
                </form:select>
            </div>
        </div>
        <div class="row mt-2">
            <div class="col-4">Giá sản phẩm:</div>
            <div class="col-8">
                <form:input class="form-control" placeholder="Giá sản phẩm" path="price"/>
                <form:errors path="price"/>

            </div>
        </div>
        <button class="btn btn-success"> <a href="/" style="text-decoration: none; color: white">Quay lại</a> </button>
        <button class="btn btn-primary" onclick="chinhSua()"> Lưu lại </button>
    </form:form>
</div>
<script>
    function chinhSua() {
        if (confirm("Bạn có chắc muốn sửa dữ liệu ?")) {
            return true;
        } else return false;
    }
</script>
</body>
</html>
