<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 30/05/2023
  Time: 15:06
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="/lop-hoc/search" method="get">
    Name: <input type="text" name="name">
    <button>Search</button>
</form>


<form:form action="/lop-hoc/add" method="post" modelAttribute="lopHoc">
    Name: <form:input type="text" path="name"/><br>
    <button>ADD</button>
</form:form>

<button><a href="/lop-hoc/hien-thi">Hiển Thị</a></button>


<table>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th> </th>
    </tr>
    <tbody>
    <c:forEach items="${pageLopHoc.content}" var="page">
        <tr>
            <td>${page.id}</td>
            <td>${page.name}</td>
            <td>
                <button><a href="/lop-hoc/delete/${page.id}">Delete</a></button>
                <button><a href="/lop-hoc/detail/${page.id}">Detail</a></button>
                <button><a href="/lop-hoc/view-update/${page.id}">Update</a></button>
            </td>
        </tr>
        <button><a href="/lop-hoc/hien-thi?phanTu=0">First</a></button>
        <button><a href="/lop-hoc/hien-thi?phanTu=${pageLopHoc.number-1}">Pre</a></button>
        <button><a href="/lop-hoc/hien-thi?phanTu=${pageLopHoc.number+1}">Next</a></button>
        <button><a href="/lop-hoc/hien-thi?phanTu=${pageLopHoc.totalPages-1}">Last</a></button>
    </c:forEach>
    </tbody>
</table>

</body>
</html>
