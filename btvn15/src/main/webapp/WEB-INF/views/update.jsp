<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %></head>
<body>

<form:form action="/tai-khoan/update/${taiKhoan.id}" method="post" modelAttribute="taiKhoan">
    Ma Tai Khoan: <form:input path="ma"/> <br>
    Ten Tai Khoan: <form:input path="tenTaiKhoan"/> <br>
    Chuc Vu:
    <form:select path="chucVu">
        <c:forEach items="${listChucVu}" var="chucVu">
            <option value="${chucVu.id}" ${chucVu.id==taiKhoan.chucVu.id?"selected":""}>${chucVu.ma}</option>
        </c:forEach>
    </form:select>
    <br>
    Ho: <form:input path="ho"/> <br>
    Ten Dem: <form:input path="tenDem"/> <br>
    Ten: <form:input path="ten"/> <br>
    Ngay Sinh: <form:input type="date" path="ngaySinh"/><br>
    Trang Thai: <form:radiobutton value="0" path="trangThai"/> Hoat Dong
    <form:radiobutton value="1" path="trangThai"/> Ngung Hoat Dong
    <br>
    <button>Update</button>
</form:form>
</body>
</html>