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
    <form:form action="/tai-khoan/update/${taiKhoan.id}" modelAttribute="taiKhoan" method="post">
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
        <button>Update</button>
    </form:form>

</section>
</body>
</html>
