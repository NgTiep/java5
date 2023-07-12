<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 31/05/2023
  Time: 16:49
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

<section>
    <form:form action="/nhan-vien/update/${nhanVien.id}" method="post" modelAttribute="nhanVien">
        Ma: <form:input path="ma"/> <form:errors path="ma"/> <br>
        Ten: <form:input path="ten"/> <form:errors path="ten"/><br>
        Ten Dem: <form:input path="tenDem"/> <form:errors path="tenDem"/><br>
        Ho: <form:input path="ho"/> <form:errors path="ho"/><br>
        Gioi Tinh:<form:radiobutton value="Nam" path="gioiTinh"/>Nam
        <form:radiobutton value="Nữ" path="gioiTinh"/>Nữ
        <form:errors path="gioiTinh"/>
        <br>
        Dia Chi: <form:input path="diaChi"/> <form:errors path="diaChi"/><br>
        Ten Cua Hang:
        <form:select path="cuaHang">
            <c:forEach items="${listCuaHang}" var="ch">
                <option value="${ch.id}" ${ch.id == nhanVien.cuaHang.id ? "selected" : ""}>${ch.ten}</option>
            </c:forEach>
        </form:select>
        <br>
        Ten Chuc Vu:
        <form:select path="chucVu">
            <c:forEach items="${listChucVu}" var="cv">
                <option value="${cv.id}" ${cv.id == nhanVien.chucVu.id ? "selected": ""}>${cv.ten}</option>
            </c:forEach>
        </form:select>
        <br>
        <button onclick="update()">Update</button>
    </form:form>
</section>

<script>
    function update() {
        if (confirm("Bạn muốn sửa dữ liệu ?")) {
            return true;
        } else {
            return false;
        }
    }
</script>
</body>
</html>
