<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 01/06/2023
  Time: 22:22
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="forn" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<section>
    <form:form action="/phong-ban/update/${phongBan.id}" method="post" modelAttribute="phongBan">
        Mã: <form:input path="ma"/> <form:errors path="ma"/> <br>
        Tên: <form:input path="ten"/> <form:errors path="ten"/><br>
        Số Lượng Phòng Ban: <form:input path="soLuongPhongBan"/> <form:errors path="soLuongPhongBan"/> <br>
        Số Lượng Nhân Viên: <form:input path="soLuongNhanVien"/> <form:errors path="soLuongNhanVien"/> <br>
        Trạng Thái: <form:radiobutton value="0" path="trangThai"/> Hoạt Động
        <form:radiobutton value="1" path="trangThai"/>Ngừng Hoạt Động
        <form:errors path="trangThai"/>
        <br>
        Mã Loại Phòng Ban:
        <form:select path="loaiPhongBan">
            <c:forEach items="${listLoaiPhongBan}" var="lpb">
                <option value="${lpb.id}" ${lpb.id==phongBan.loaiPhongBan.id?"selected":""}>${lpb.ma}</option>
            </c:forEach>
        </form:select>
        <br>
        <button onclick="update()">UPDATE</button>
    </form:form>
</section>

<script>
    function update(){
        if (confirm("Bạn muốn sửa thông tin ?")){
            return true;
        }else {
            return false
        }
    }
</script>

</body>
</html>
