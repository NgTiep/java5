<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 18/05/2023
  Time: 00:20
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

ID: ${sv.id} <br>
Ten: ${sv.ten} <br>
Tuoi: ${sv.tuoi} <br>
Dia Chi: ${sv.diaChi} <br>
Gioi Tinh: <c:if test="${sv.gioiTinh==true}">Nam</c:if>
<c:if test="${sv.gioiTinh==false}">Nữ</c:if>

</body>
</html>
