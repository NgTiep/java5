<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 03/06/2023
  Time: 08:02
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<table border="1" style="width:100%">
    <tr>
        <th>Loại hàng</th>
        <th>Tổng giá</th>
        <th>Số sản phẩm</th>
    </tr>
    <c:forEach var="item" items="${items}">
        <tr>
            <td>${item.group.name}</td>
            <td>${item.sum}</td>
            <td>${item.count}</td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
