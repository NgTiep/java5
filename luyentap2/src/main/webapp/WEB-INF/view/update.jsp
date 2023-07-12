<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 18/05/2023
  Time: 00:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="/sinh-vien/update" method="post">
    ID: <input type="number" name="id" value="${sv.id}"> <br>
    Ten: <input type="text" name="ten" value="${sv.ten}"> <br>
    Tuoi: <input type="number" name="tuoi" value="${sv.tuoi}"> <br>
    Dia Chi: <input type="text" name="diaChi" value="${sv.diaChi}"> <br>
    Gioi Tinh:
    <input type="radio" name="gioiTinh" checked value="true" ${sv.gioiTinh==true?"checked":""}>Nam
    <input type="radio" name="gioiTinh" value="false" ${sv.gioiTinh==false?"checked":""}>Nữ
    <br>
    <button>Update</button>
</form>

</body>
</html>
