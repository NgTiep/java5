<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 10/06/2023
  Time: 22:49
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

<section class="container">
    <form action="/tai-khoan/search" method="get">
        Từ Ngày: <input name="min"> <br>
        Đến Ngày: <input name="max"> <br>
        <button>Search</button>
    </form>

    <form:form action="/tai-khoan/add" modelAttribute="taiKhoan" method="post">
        Mã Tài Khoản: <form:input path="ma"/> <form:errors path="ma"/> <br>
        Tên Tài Khoản: <form:input path="tenTaiKhoan"/> <form:errors path="tenTaiKhoan"/> <br>
        Họ: <form:input path="ho"/> <form:errors path="ho"/> <br>
        Tên Đệm: <form:input path="tenDem"/> <form:errors path="tenDem"/> <br>
        Tên: <form:input path="ten"/> <form:errors path="ten"/> <br>
        Ngày Sinh: <form:input path="ngaySinh"/> <form:errors path="ngaySinh"/> <br>
        Trạng Thái: <form:radiobutton value="0" path="trangThai"/>Hoạt Động
        <form:radiobutton value="1" path="trangThai"/>Ngừng Hoạt Động
        <form:errors path="trangThai"/> <br>
        Chức Vụ:
        <form:select path="chucVu">
            <c:forEach items="${listChucVu}" var="cv">
                <option value="${cv.id}" ${cv.id==taiKhoan.chucVu.id?"selected":""}>${cv.ma}</option>
            </c:forEach>
        </form:select>
        <button>ADD</button>
    </form:form>

    <table>
        <tr>
            <th>Mã Tài Khoản</th>
            <th>Tên Tài Khoản</th>
            <th>Họ Tên</th>
            <th>Ngày Sinh</th>
            <th>Trạng Thái</th>
            <th>Chức Vụ</th>
        </tr>
        <tbody>
        <c:forEach items="${listTaiKhoan.content}" var="tk">
            <tr>
                <td>${tk.ma}</td>
                <td>${tk.tenTaiKhoan}</td>
                <td>${tk.ho} ${tk.tenDem} ${tk.ten}</td>
                <td>${tk.ngaySinh}</td>
                <td>
                    <c:if test="${tk.trangThai==0}">Hoạt Động</c:if>
                    <c:if test="${tk.trangThai==1}">Ngừng Hoạt Động</c:if>
                </td>
                <td>${tk.chucVu.ma}-${tk.chucVu.ten}</td>
                <td>
                    <button><a href="/tai-khoan/delete/${tk.id}">Delete</a></button>
                    <button><a href="/tai-khoan/detail/${tk.id}">Detail</a></button>
                    <button><a href="/tai-khoan/view-update/${tk.id}">Update</a></button>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

        <a href="/tai-khoan/hien-thi?page=0">>></a>
        <a href="/tai-khoan/hien-thi?page=${listTaiKhoan.number-1}"><</a>
        <a href="/tai-khoan/hien-thi?page=${listTaiKhoan.number+1}">></a>
        <a href="/tai-khoan/hien-thi?page=${listTaiKhoan.totalPages-1}"> >></a>


    <li class="page-item"><a class="page-link">Trang số: ${listTaiKhoan.number}</a></li>
    <li class="page-item"><a class="page-link">Tổng số thực thể: ${listTaiKhoan.totalElements}</a></li>
    <li class="page-item"><a class="page-link">Tổng số trang: ${listTaiKhoan.totalPages}</a></li>
    </ul>
</section>

</body>
</html>
