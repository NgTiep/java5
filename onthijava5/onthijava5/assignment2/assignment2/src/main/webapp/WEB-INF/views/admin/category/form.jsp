<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"/>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">

</head>
<body>

<div class="container ">

    <form:form action="/admin/category/index" modelAttribute="item">
        <div class="mb-4">
            <label class="form-label">ID</label>
            <form:input class="form-control" path="id"/>
        </div>
        <div class="mb-4">
            <label class="form-label">Name</label>
            <form:input class="form-control" path="name"/>
        </div>
        <button type="submit" class="btn btn-sm btn-danger" formaction="/admin/category/create">Create</button>
        <button type="submit" class="btn btn-sm btn-secondary" formaction="/admin/category/update">Update</button>
    </form:form>

</div>
</body>
</html>