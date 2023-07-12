<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 19/05/2023
  Time: 14:12
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
<form>

</form>
<button><a href="/giang-vien/view-add">Add</a></button>
<button><a href="/giang-vien/sap-xep">SapXep</a></button>
<table>
    <tr>
        <th>MSSV</th>
        <th>Ho Ten</th>
        <th>Tuoi</th>
        <th>Que Quan</th>
        <th>Action</th>
    </tr>
    <tbody>
    <c:forEach items="${listGiangVien}" var="gv">
        <tr>
            <td>${gv.ma}</td>
            <td>${gv.hoTen}</td>
            <td>${gv.tuoi}</td>
            <td>${gv.queQuan}</td>
            <td></td>
            <td>
                <button><a href="/giang-vien/delete/${gv.ma}">Delete</a></button>
                <button><a href="/giang-vien/detail/${gv.ma}">Detail</a></button>
                <button><a href="/giang-vien/view-update/${gv.ma}">Update</a></button>
            </td>
        </tr>
    </c:forEach>
    </tbody>

</table>
<label>${mess}</label>


</body>
</html>
