<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 02/06/2023
  Time: 22:41
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

<form:form action="/phong-ban/update/${phongBan.id}" method="post" modelAttribute="phongBan">
    Mã: <form:input path="ma"/> <br>
    Tên: <form:input path="ten"/> <br>
    Số Lượng Phòng Ban: <form:input path="soLuongPhongBan"/> <br>
    Số Lượng Nhân Viên: <form:input path="soLuongNhanVien"/> <br>
    Trạng Thái: <form:radiobutton value="0" path="trangThai"/>Hoạt Động
    <form:radiobutton value="1" path="trangThai"/>Ngừng Hoạt Động
    <br>
    Tên Loại Phòng Ban :
    <form:select path="loaiPhongBan">
        <c:forEach items="${listLPB}" var="lpb">
            <option value="${lpb.id}" ${lpb.id==phongBan.loaiPhongBan.id?"selected":""}>${lpb.ten}</option>
        </c:forEach>
    </form:select>
    <br>
    <button>Update</button>
</form:form>


</body>
</html>
