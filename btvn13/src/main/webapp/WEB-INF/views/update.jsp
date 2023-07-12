<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 04/06/2023
  Time: 07:52
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

<section>
    <form:form action="/co-so/update/${coSo.id}" method="POST" modelAttribute="coSo">
        Mã Cơ Sở: <form:input path="ma"/> <form:errors path="ma"/> <label>${mess}</label><br>
        Mã Tên Tài Khoản:
        <form:select path="taiKhoanNganHang">
            <c:forEach items="${listTKNH}" var="tknh">
                <option value="${tknh.id}" ${tknh.id==coSo.taiKhoanNganHang.id?"selected":""}>${tknh.ma}</option>
            </c:forEach>
        </form:select>
        <br>
        Số Điện Thoại :<form:input path="soDienThoai"/> <form:errors path="soDienThoai"/><br>
        Ghi Chú: <form:input path="ghiChu"/> <form:errors path="ghiChu"/> <br>
        Trạng Thái: <form:radiobutton value="0" path="trangThai"/> Hoạt Động
        <form:radiobutton value="1" path="trangThai"/> Ngừng Hoạt Động
        <form:errors path="trangThai"/>
        <br>
        <button onclick="update()">Update</button>
    </form:form>
</section>

<script>
    function update() {
        if(confirm("Ban co muon sua du lieu ?")){
            return true;
        }else return false;
    }
</script>

</body>
</html>
