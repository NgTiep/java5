<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 10/06/2023
  Time: 00:35
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
<section class="container">

    <form:form action="/chuc-vu/add" method="post" modelAttribute="chucVu">
        Mã: <form:input path="ma"/> <form:errors path="ma"/> <br>
        Tên: <form:input path="ten"/> <form:errors path="ten"/> <br>
        <button>ADD</button>
    </form:form>

    <table class="table">
        <thead>
        <tr>
            <th >Mã</th>
            <th>Tên</th>
            <th> </th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${listChucVu.content}" var="cv">
            <tr>
                <td>${cv.ma} </td>
                <td>${cv.ten} </td>
                <td>
                    <button><a href="/chuc-vu/delete/${cv.id}">Delete</a></button>
                    <button><a href="/chuc-vu/detail/${cv.id}">Detail</a></button>
                    <button><a href="/chuc-vu/view-update/${cv.id}">Update</a></button>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <a href="/chuc-vu/hien-thi?page=0">Fr</a>
    <a href="/chuc-vu/hien-thi?page=${listChucVu.number-1}">Ps</a>
    <a href="/chuc-vu/hien-thi?page=${listChucVu.number+1}">Nx</a>
    <a href="/chuc-vu/hien-thi?page=${listChucVu.totalPages-1}">Ls</a>

</section>


</body>
</html>
