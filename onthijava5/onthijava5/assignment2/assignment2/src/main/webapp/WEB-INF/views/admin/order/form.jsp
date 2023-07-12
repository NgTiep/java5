<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"/>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">

</head>
<body>

<div class="container ">

    <form:form action="/admin/order/index" modelAttribute="item">
        <div class="mb-4">
            <label class="form-label">ID</label>
            <form:input class="form-control" path="id"/>
        </div>
        <div class="mb-4">
            <label class="form-label">Address</label>
            <form:input class="form-control" path="address"/>
        </div>

        <div class="mb-4">
            <label class="form-label">Category ID</label>
            <form:select path="account" class="form-control">
                <c:forEach items="${listAccount}" var="account">
                    <option value="${account.username}" ${account.username==item.account.username?"selected":""}>${account.username}</option>
                </c:forEach>
            </form:select>
        </div>


        <div class="mb-4">
            <label class="form-label">CreateDate</label>
            <form:input type="date" class="form-control" path="createDate"/>
        </div>
        <button type="submit" class="btn btn-sm btn-danger" formaction="/admin/order/create">Create</button>
        <button type="submit" class="btn btn-sm btn-secondary" formaction="/admin/order/update">Update</button>
    </form:form>

</div>
</body>
</html>