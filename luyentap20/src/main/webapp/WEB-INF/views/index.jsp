<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/06/2023
  Time: 23:41
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<section class="container">
    <form action="/tai-khoan/search" method="get">
        Từ Ngày: <input name="toDate"> <br>
        Đến Ngày: <input name="endDate"> <br>
        <button>Search</button>
    </form>

    <form:form action="/tai-khoan/add" modelAttribute="taiKhoan" method="post">
        Mã: <form:input path="ma"/> <form:errors path="ma"/> <br>
        Tên Tài Khoản: <form:input path="tenTaiKhoan"/> <form:errors path="tenTaiKhoan"/> <br>
        Họ: <form:input path="ho"/> <form:errors path="ho"/> <br>
        Tên Đệm: <form:input path="tenDem"/> <form:errors path="tenDem"/> <br>
        Tên: <form:input path="ten"/> <form:errors path="ten"/> <br>
        Ngày Sinh: <form:input path="ngaySinh"/> <form:errors path="ngaySinh"/> <br>
        Trạng Thái: <form:radiobutton value="0"  path="trangThai"/> Hoạt Động
        <form:radiobutton value="1"  path="trangThai"/>Ngừng Hoạt Động
        <form:errors path="trangThai"/> <br>
        Chức Vụ:
        <form:select path="chucVu">
            <c:forEach var="cv" items="${listChucVu}">
                <option value="${cv.id}" ${cv.id==taiKhoan.chucVu.id?"selected" :""}>${cv.ma}</option>
            </c:forEach>
        </form:select>
        <br>
        <button onclick="add()">ADD</button>
    </form:form>

    <table>
        <tr>
            <th>Mã</th>
            <th>Tên Tài Khoản</th>
            <th>Họ Tên</th>
            <th>Ngày Sinh</th>
            <th>Trạng Thái</th>
            <th>Chức Vụ</th>
            <th> </th>
        </tr>
        <tbody>
        <c:forEach var="tk" items="${listTaiKhoan.content}">
            <tr>
                <td>${tk.ma}</td>
                <td>${tk.tenTaiKhoan}</td>
                <td>${tk.ho} ${tk.tenDem} ${tk.ten}</td>
                <td>${tk.ngaySinh}</td>
                <td>
                    <c:if test="${tk.trangThai==0}">Hoạt động</c:if>
                    <c:if test="${tk.trangThai==1}">Ngừng Hoạt động</c:if>
                </td>
                <td>${tk.chucVu.ma}- ${tk.chucVu.ten}</td>
                <td>
                    <button><a href="/tai-khoan/detail/${tk.id}">Detail</a></button>
                    <button><a href="/tai-khoan/delete/${tk.id}" onclick="xoa()">Delete</a></button>
                    <button><a href="/tai-khoan/view-update/${tk.id}" >Update</a></button>
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
    <label style="color:red;">${mess}</label>

    <script>
        function xoa() {
            if (confirm("Ban muon xoa thong tin ?")){
                return true;
            }else return false;
        }

        function add() {
            if (confirm("Ban muon thêm thong tin ?")){
                return true;
            }else return false;
        }
    </script>
</section>


</body>
</html>
