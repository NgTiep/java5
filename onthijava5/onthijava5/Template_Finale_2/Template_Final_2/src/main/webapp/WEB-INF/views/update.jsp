<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 17/06/2023
  Time: 23:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html>
<head>
    <title>Title</title>
</head>
<body>

<section class="container">

    <form:form action="/phieu-giao-hang/update/${phieuGiaoHang.maphieugiao}" method="post" modelAttribute="phieuGiaoHang">
        Người Nhận: <form:input path="nguoinhan"/> <br>
        Số Điện Thoại: <form:input path="sdt"/> <br>
        Ngày Giao: <form:input path="ngaygiao"/> <br>
        Ngày Nhận: <form:input path="ngaynhan"/> <br>
        Hóa Đơn:
        <form:select path="hoadon">
            <c:forEach items="${listHD}" var="hd">
                <option value="${hd.mahoadon}" ${hd.mahoadon==phieuGiaoHang.hoadon.mahoadon?"selected":""}>${hd.mahoadon}</option>
            </c:forEach>
        </form:select>
        <br>
        <button>Sửa</button>
    </form:form>

</section>

</body>
</html>
