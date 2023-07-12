<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
    <title>Title</title>
</head>
<body>

<table>
    <form action="">
        Tên: <input name="ten"/>
        <button type="submit">Search</button>
    </form>
    <br/>
    <button><a href="/sinh-vien/view-add">Add Student</a></button>
    <tr>
        <th>STT</th>
        <th>MSSV</th>
        <th>Tên</th>
        <th>Tuổi</th>
        <th>Địa chỉ</th>
        <th>Giới tính</th>
        <th colspan="2">Action</th>
    </tr>
    </thead>

    <tbody>
    <c:forEach items="${lists}" var="sv" varStatus="stt">
        <tr>
            <td>${stt.index + 1}</td>
            <td>${sv.mssv}</td>
            <td>${sv.ten}</td>
            <td>${sv.tuoi}</td>
            <td>${sv.diaChi}</td>
            <td>${sv.gioiTinh}</td>
            <td>
                <button><a href="/sinh-vien/detail/${sv.mssv}">Detail </a></button>
                <button><a href="/sinh-vien/delete/${sv.mssv}">Delete </a></button>
                <button><a href="/sinh-vien/view-update/${sv.mssv}">Update </a></button>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
