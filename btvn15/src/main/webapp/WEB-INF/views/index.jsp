<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
</head>
<body>

<section class="container">
    <form action="/tai-khoan/search" method="get">
        Tim Ten: <input type="text" name="ten">
        <button>Search</button>
    </form>

    <form:form action="/tai-khoan/add" method="post" modelAttribute="taiKhoan">
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
        <button>ADD</button>
    </form:form>

    <button><a href="/tai-khoan/hoat-dong">Hoat Dong</a></button>
    <button><a href="/tai-khoan/sap-xep">Sap Xep</a></button>

    <table class="table">
        <thead>
        <tr>
            <th>Ma Tai Khoan</th>
            <th>Ten Tai Khoan</th>
            <th>Ma Chuc Vu</th>
            <th>Ho Ten</th>
            <th>Ngay Sinh</th>
            <th>Trang Thai</th>
            <th> </th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${listTaiKhoan.content}" var="tk">
            <tr>
                <td>${tk.ma}</td>
                <td>${tk.tenTaiKhoan}</td>
                <td>${tk.chucVu.ma}-${tk.chucVu.ten}</td>
                <td>${tk.ho} ${tk.tenDem} ${tk.ten}</td>
                <td>${tk.ngaySinh}</td>
                <td>
                    <c:if test="${tk.trangThai==0}">Hoat Dong</c:if>
                    <c:if test="${tk.trangThai==1}">Ngung Hoat Dong</c:if>
                </td>
                <td>
                    <button><a href="/tai-khoan/delete/${tk.id}">Delete</a></button>
                    <button><a href="/tai-khoan/detail/${tk.id}">Detail</a></button>
                    <button><a href="/tai-khoan/view-update/${tk.id}">Update</a></button>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <a href="/tai-khoan/hien-thi?number=0">Fr</a>
    <a href="/tai-khoan/hien-thi?number=${listTaiKhoan.number-1}">Ps</a>
    <a href="/tai-khoan/hien-thi?number=${listTaiKhoan.number+1}">Nx</a>
    <a href="/tai-khoan/hien-thi?number=${listTaiKhoan.totalPages-1}">Ls</a>
</section>

</body>
</html>