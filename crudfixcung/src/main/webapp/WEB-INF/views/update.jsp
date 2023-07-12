<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 17/05/2023
  Time: 00:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>


<form action="/sinh-vien/update" method="post">
    MSSV: <input type="number" name="id" value="${sv.id}"/>
    <br/>
    Tên: <input type="text" name="ten" value="${sv.ten}"/>
    <br/>
    Tuổi: <input type="number" name="tuoi" value="${sv.tuoi}"/>
    <br/>
    Giới tính:
    <input type="radio" name="gioiTinh" checked value="true" ${sv.gioiTinh==true?"checked":""} />Nam
    <input type="radio" name="gioiTinh" value="false" ${sv.gioiTinh==false?"checked":""} />Nữ
    <br/>
    Địa chỉ: <input type="text" name="diaChi" value="${sv.diaChi}"/>
    <br/>
    <button>Update</button>
</form>

</body>
</html>
