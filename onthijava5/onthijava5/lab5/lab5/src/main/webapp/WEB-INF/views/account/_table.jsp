<%@ page pageEncoding="utf-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<table border="1" style="width:100%">
    <tr>
        <th>Username</th>
        <th>Password</th>
        <th>Fullname</th>
        <th>Email</th>
        <th> </th>
    </tr>
    <c:forEach var="item" items="${items}">
        <tr>
            <td>${item.username}</td>
            <td>${item.password}</td>
            <td>${item.fullname}</td>
            <td>${item.email}</td>
            <td><a href="/account/edit/${item.username}">Edit</a></td>
        </tr>
    </c:forEach>
</table>