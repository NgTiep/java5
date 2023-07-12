<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 23/05/2023
  Time: 12:34
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%--<section>--%>
<%--    <table>--%>
<%--        <tr>--%>
<%--            <th>ID</th>--%>
<%--            <th>Name</th>--%>
<%--            <th>Price</th>--%>
<%--            <th>QTY</th>--%>
<%--            <th>QTY</th>--%>
<%--            <th>ACtion</th>--%>
<%--        </tr>--%>
<%--        <tbody>--%>
<%--        <c:forEach items="${listSanPham}" var="sp">--%>
<%--            <tr>--%>
<%--                <td>${sp.id}</td>--%>
<%--                <td>${sp.name}</td>--%>
<%--                <td>${sp.price}</td>--%>
<%--                <td>${sp.qty}</td>--%>
<%--                <th>${sp.price*sp.qty}</th>--%>

<%--                <td>--%>
<%--                    <button><a href="/san-pham/view-add">ADD</a></button>--%>
<%--                    <button><a href="/san-pham/delete/${sp.id}">Delete</a></button>--%>
<%--                    <button><a href="/san-pham/view-update/${sp.id}">Update</a></button>--%>
<%--                    <button><a href="/san-pham/detail/${sp.id}">Detail</a></button>--%>
<%--                </td>--%>
<%--            </tr>--%>
<%--        </c:forEach>--%>
<%--        </tbody>--%>
<%--    </table>--%>
<%--    <button><a href="/san-pham/clear">Clear</a></button>--%>
<%--</section>--%>


<table border="1" style="width:100%">
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Price</th>
        <th>Quantity</th>
        <th>Total</th>
        <th>Action</th>
     </tr>
    <tbody>
    <c:forEach items="${listSanPham}" var="sp">
        <tr>
            <td>${sp.id}</td>
            <td>${sp.name}</td>
            <td>${sp.price}</td>
            <td>${sp.qty}</td>
            <td>${sp.price*sp.qty}</td>

            <td>
                <button><a href="/san-pham/delete/${sp.id}">Delete</a></button>
                <button><a href="/san-pham/view-update/${sp.id}">Update</a></button>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<button><a href="/san-pham/clear">Clear</a></button>
<button><a href="/san-pham/view-add">ADD</a></button>
</body>
</html>