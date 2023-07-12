<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/06/2023
  Time: 22:18
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
</head>
<body>

<section class="container">

    <form action="/tai-khoan/search" method="get">
        Tên Tài Khoản: <input name="tenTaiKhoan">
        <button>Search</button>
    </form>

    <form:form action="/tai-khoan/add" method="post" modelAttribute="taiKhoan">
        Mã Tài Khoản: <form:input path="ma"/> <form:errors path="ma"/> <br>
        Tên Tài Khoản: <form:input path="tenTaiKhoan"/> <form:errors path="tenTaiKhoan"/> <br>
        Họ: <form:input path="ho"/> <form:errors path="ho"/> <br>
        Tên Đệm: <form:input path="tenDem"/> <form:errors path="tenDem"/> <br>
        Tên: <form:input path="ten"/> <form:errors path="ten"/> <br>
        Ngày Sinh: <form:input path="ngaySinh" type="date"/> <form:errors path="ngaySinh"/> <br>
        Trạng Thái: <form:radiobutton value="0" path="trangThai"/> Hoạt Động
        <form:radiobutton value="1" path="trangThai"/> Ngừng Hoạt Động
        <form:errors path="trangThai"/>
        <br>
        Chức vụ:
        <form:select path="chucVu">
            <c:forEach items="${listChucVu}" var="cv">
                <option value="${cv.id}" ${cv.id==taiKhoan.chucVu.id?"selected":""}>${cv.ma}</option>
            </c:forEach>
        </form:select>
        <br>
        <button onclick="add()">ADD</button>
    </form:form>


    <table>
        <tr>
            <th>Mã Tài Khoản</th>
            <th>Tên Tài Khoản</th>
            <th>Họ Tên</th>
            <th>Ngày Sinh</th>
            <th>Trạng Thái</th>
            <th>Chức Vụ</th>
            <th></th>
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
                    <button><a href="/tai-khoan/delete/${tk.id}" onclick="xoa()">Delete</a></button>
                    <button><a href="/tai-khoan/detail/${tk.id}">Detail</a></button>
                    <button><a href="/tai-khoan/view-update/${tk.id}">Update</a></button>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <a href="/tai-khoan/hien-thi?page=0">Fr</a>
    <a href="/tai-khoan/hien-thi?page=${listTaiKhoan.number-1}">Ps</a>
    <a href="/tai-khoan/hien-thi?page=${listTaiKhoan.number+1}">Nx</a>
    <a href="/tai-khoan/hien-thi?page=${listTaiKhoan.totalPages-1}">Ls</a>

    <br>
    <label style="color: red">${mess}</label>

    <script>
        function xoa() {
            if (confirm("Ban muon xoa thong tin ?")){
                return true
            }else  return false
        }

        function add() {
            if (confirm("Ban muon them thong tin ?")){
                return true
            }else  return false
        }
    </script>
</section>


</body>
</html>
