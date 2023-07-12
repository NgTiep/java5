<%@ page pageEncoding="utf-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>

<section class="container">

    <form:form action="/phieu-giao-hang/add" method="post" modelAttribute="phieuGiaoHang">
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
        <button>Thêm</button>
    </form:form>

    <table class="table">
        <thead>
        <tr>
            <th>Người Nhận</th>
            <th>Sđt</th>
            <th>Ngày Giao</th>
            <th>Ngày Nhận</th>
            <th>Trạng Thái</th>
            <th>Hóa Đơn</th>
            <th> </th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${listPGH.content}" var="pgh">
            <tr>
                <td>${pgh.nguoinhan}</td>
                <td>${pgh.sdt}</td>
                <td>${pgh.ngaygiao}</td>
                <td>${pgh.ngaynhan}</td>
                <td>
                    <c:if test="${pgh.trangthai==0}">Đã Nhận</c:if>
                    <c:if test="${pgh.trangthai==1}">Chưa Nhận</c:if>
                </td>
                <td>${pgh.hoadon.mahoadon}-${pgh.hoadon.nguoilap}</td>
                <td>
                    <button><a href="/phieu-giao-hang/delete/${pgh.maphieugiao}">Delete</a></button>
                    <button><a href="/phieu-giao-hang/detail/${pgh.maphieugiao}">Detail</a></button>
                    <button><a href="/phieu-giao-hang/view-update/${pgh.maphieugiao}">Update</a></button>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <a href="/phieu-giao-hang/hien-thi?page=0">Frist</a>
    <a href="/phieu-giao-hang/hien-thi?page=${listPGH.number-1}">Person</a>
    <a href="/phieu-giao-hang/hien-thi?page=${listPGH.number+1}">Next</a>
    <a href="/phieu-giao-hang/hien-thi?page=${listPGH.totalPages-1}">Last</a>
    <br>
    <label style="color:red;">${mess}</label>

</section>

</body>
</html>