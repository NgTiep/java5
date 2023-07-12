<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 01/06/2023
  Time: 14:19
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

<form action="" method="">
    Tên: <input type="text" name="ten">
    <button>Search</button>
</form>

<form:form action="" method="" modelAttribute="">
    Ma:<form:input path="ma"/> <br>
    Tên:<form:input path="ten"/> <br>
    Tên Đệm:<form:input path="tenDem"/> <br>
    Họ:<form:input path="ho"/> <br>
    Giới Tính:<form:radiobutton value="Nam" path="gioiTinh"/>
    <form:radiobutton value="Nữ" path="gioiTinh"/>
    <br>
    Tên Cửa Hàng:
    <form:select path="cuaHang">
        <c:forEach>
            <form:options></form:options>
        </c:forEach>
    </form:select>
    <br>
    Tên Chức Vụ:
    <form:select path="chucVu">
        <c:forEach>
            <form:options></form:options>
        </c:forEach>
    </form:select>
    <br>
    <button>ADD</button>
</form:form>

<button><a href="">Sap Xep</a></button>
<button><a href="">Gioi Tinh Nam</a></button>

<table>
    <tr>
        <th>Ma</th>
        <th>Ten</th>
        <th>Ten Dem</th>
        <th>Ho</th>
        <th>Gioi Tinh</th>
        <th>Ten Cua Hang</th>
        <th>Ten CHuc Vu</th>
        <th></th>
    </tr>
    <tbody>
    <c:forEach>
        <tr>
            <td>Alfreds Futterkiste</td>
            <td>Maria Anders</td>
            <td>Germany</td>
        </tr>
    </c:forEach>
    </tbody>
</table>


</body>
</html>
