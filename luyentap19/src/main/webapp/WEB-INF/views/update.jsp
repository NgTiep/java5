<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/06/2023
  Time: 22:18
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

<form:form action="/tai-khoan/update/${taiKhoan.id}" method="post" modelAttribute="taiKhoan">
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
    <button onclick="update()">Update</button>
</form:form>

<script>
    function update() {
        if (confirm("Ban muon sua thong tin ?")){
            return true
        }else  return false
    }

</script>

</body>
</html>
