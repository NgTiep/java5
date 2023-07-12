<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 09/06/2023
  Time: 13:44
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
    <table class="table">
        <thead>
        <tr>
            <th>Mã Tài Khoản</th>
            <th>Tên Tài Khoản</th>
            <th>Chức Vụ</th>
            <th>Họ Tên</th>
            <th>Ngày Sinh</th>
            <th>Trạng Thái</th>
            <th> </th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${listTaiKhoan.content}" var="tk">
            <tr>
                <td>${tk.ma}</td>
                <td>${tk.tenTaiKhoan}</td>
                <td>${tk.chucVu.ma}-${tk.chucVu.ten}</td>
                <td>${tk.ho} ${tk.tenDem} ${tk.ten}</td>
                <td>${tk.ngaySinh}</td>
                <td>
                    <c:if test="${tk.trangThai==0}">Hoạt Động</c:if>
                    <c:if test="${tk.trangThai==1}">Ngừng Hoạt Động</c:if>
                </td>
                <td>
                    <button><a href="/tai-khoan/delete/${tk.id}">Delete</a></button>
                    <button><a href="/tai-khoan/detail/${tk.id}">Detail</a></button>
                    <button><a href="/tai-khoan/view-update/${tk.id}">Update</a></button>
                    <button><a href="/tai-khoan/view-add">Add</a></button>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <a href="/tai-khoan/hien-thi?page=0">Fr</a>
    <a href="/tai-khoan/hien-thi?page=${listTaiKhoan.number-1}">Ps</a>
    <a href="/tai-khoan/hien-thi?page=${listTaiKhoan.number+1}">Nx</a>
    <a href="/tai-khoan/hien-thi?page=${listTaiKhoan.totalPages-1}">Ls</a>
</section>

</body>
</html>
