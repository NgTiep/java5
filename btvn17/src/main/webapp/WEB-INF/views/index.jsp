<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 09/06/2023
  Time: 15:45
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<section class="container">
    <form action="/tai-khoan/search" method="get">
        Tên :<input name="ten">
        <button>Search</button>
    </form>

    <form:form action="/tai-khoan/add" method="post" modelAttribute="taiKhoan">
        Mã Tài Khoản: <form:input path="ma"/> <form:errors path="ma"/> <br>
        Tên Tài Khoản: <form:input path="tenTaiKhoan"/> <form:errors path="tenTaiKhoan"/> <br>
        Họ: <form:input path="ho"/> <form:errors path="ho"/> <br>
        Tên Đệm: <form:input path="tenDem"/> <form:errors path="tenDem"/> <br>
        Tên: <form:input path="ten"/> <form:errors path="ten"/> <br>
        Ngày Sinh: <form:input type="date" path="ngaySinh"/> <form:errors path="ngaySinh"/> <br>
        Trạng Thái: <form:radiobutton value="0" path="trangThai"/> Hoạt Động
        <form:radiobutton value="1" path="trangThai"/> Ngừng Hoạt Động
        <form:errors path="trangThai"/> <br>
        Chức Vụ:
        <form:select path="chucVu">
            <c:forEach items="${listChucVu}" var="cv">
                <option value="${cv.id}"   ${cv.id==taiKhoan.chucVu.id?"selected":""}>${cv.ten}</option>
            </c:forEach>
        </form:select>
        <br>
        <button>ADD</button>
    </form:form>

    <br>
    <button><a href="/tai-khoan/sap-xep">Sap Xep</a></button>
    <button><a href="/tai-khoan/hoat-dong">Hoat Dong</a></button>


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
                        <button><a href="/tai-khoan/view-update/${tk.id}">Edit</a></button>
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
