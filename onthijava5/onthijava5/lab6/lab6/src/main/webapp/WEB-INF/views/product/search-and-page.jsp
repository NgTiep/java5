<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 03/06/2023
  Time: 07:23
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="/product/search-and-page" method="get">
    <input name="keywords">
    <button>Search</button>
</form>
<table border="1" style="width:100%">
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Price</th>
        <th>Date</th>
    </tr>

    <c:forEach var="item" items="${page.content}">
        <tr>
            <td>${item.id}</td>
            <td>${item.name}</td>
            <td>${item.price}</td>
            <td>${item.createDate}</td>
        </tr>
    </c:forEach>
</table>
<a href="/product/search-and-page?p=0">First</a>
<a href="/product/search-and-page?p=${page.number-1}">Previous</a>
<a href="/product/search-and-page?p=${page.number+1}">Next</a>
<a href="/product/search-and-page?p=${page.totalPages-1}">Last</a>
<ul>
    <li>Số thực thể hiện tại: ${page.numberOfElements}</li>
    <li>Trang số: ${page.number}</li>
    <li>Kích thước trang: ${page.size}</li>
    <li>Tổng số thực thể: ${page.totalElements}</li>
    <li>Tổng số trang: ${page.totalPages}</li>
</ul>


</body>
</html>
