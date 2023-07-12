<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"/>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">

</head>
<body>

<div class="container ">

    <form:form action="/admin/product/index" modelAttribute="item">
        <div class="mb-4">
            <label class="form-label">ID</label>
            <form:input class="form-control" path="id"/>
        </div>
        <div class="mb-4">
            <label class="form-label">Name</label>
            <form:input class="form-control" path="name"/>
        </div>

        <div class="mb-4">
            <label class="form-label">Image</label>
            <form:input class="form-control" path="image"/>
        </div>


        <div class="mb-4">
            <label class="form-label">Price</label>
            <form:input class="form-control" path="price"/>

        </div>

        <div class="mb-4">
            <label class="form-label">Category ID</label>
            <form:select path="category" class="form-control">
                <c:forEach items="${listCategory}" var="category">
                    <option value="${category.id}" ${category.id==item.category.id?"selected":""}>${category.name}</option>
                </c:forEach>
            </form:select>
        </div>


        <div class="mb-4">
            <label class="form-label">CreateDate</label>
            <form:input type="date" class="form-control" path="createDate"/>
        </div>
        <button type="submit" class="btn btn-sm btn-danger" formaction="/admin/product/create">Create</button>
        <button type="submit" class="btn btn-sm btn-secondary" formaction="/admin/product/update">Update</button>
    </form:form>

</div>
</body>
</html>