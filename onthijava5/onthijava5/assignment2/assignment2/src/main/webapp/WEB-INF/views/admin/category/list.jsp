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
    <table class="table">
        <thead>
        <tr>
            <th style="width:20%">ID</th>
            <th style="width:20%">Name</th>
            <th style="width:20%"></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="item" items="${items}">
            <tr>
                <td>${item.id}</td>
                <td>${item.name}</td>
                <td>
                    <a href="/admin/category/delete/${item.id}" class="btn btn-sm btn-danger">DELETE</a>
                    <a href="/admin/category/edit/${item.id}" class="btn btn-sm btn-secondary">EDIT</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>


</div>
</body>
</html>
