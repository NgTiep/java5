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

<form action="/sinh-vien/add" method="post">
    ID: <input type="number" name="id"> <br>
    Ten: <input type="text" name="ten"> <br>
    Tuoi: <input type="number" name="tuoi"> <br>
    Dia Chi: <input type="text" name="diaChi"> <br>
    Gioi Tinh:
    <input type="radio" name="gioiTinh" checked value="true">Nam
    <input type="radio" name="gioiTinh" value="false">Nữ
    <br>
    <button>ADD</button>
</form>

</body>
</html>
