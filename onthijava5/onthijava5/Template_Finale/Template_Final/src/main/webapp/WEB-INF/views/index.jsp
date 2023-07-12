<%@ page pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

<main>

    <form action="/khach-hang/search" method="get">
        Tìm Kiếm <input type="text" name="nhapGiaTri">
        Hạng Khách Hàng:
        <select name="hangKhachHang">
            <c:forEach items="${listHKH}" var="hkh">
                <option value="${hkh.maHang}">${hkh.maHang}</option>
            </c:forEach>
        </select>
        <button>Search</button>
    </form>


    <form:form action="/khach-hang/add" method="post" modelAttribute="khachHang">
        Tên Khách Hàng: <form:input path="tenKH"/> <form:errors path="tenKH"/> <br>
        Số Điện Thoại: <form:input path="sdt"/> <form:errors path="sdt"/> <br>
        Giới Tính: <form:radiobutton value="true" path="gioiTinh"/> Nam
        <form:radiobutton value="false" path="gioiTinh"/> Nữ
        <form:errors path="gioiTinh"/> <br>
        Hạng Khách Hàng:
        <form:select path="hangKhachHang">
            <c:forEach items="${listHKH}" var="hkh">
                <option value="${hkh.maHang}" ${hkh.maHang==khachHang.hangKhachHang.maHang?"selected":""}>${hkh.maHang}</option>
            </c:forEach>
        </form:select>
        <br>
        <button onclick="them()">ADD</button>
    </form:form>

    <table class="table">
        <thead>
        <tr>
            <th>STT</th>
            <th>Mã Khách Hàng</th>
            <th>Tên Khách Hàng</th>
            <th>Số Điện Thoại</th>
            <th>Giới Tính</th>
            <th>Hạng Khách Hàng</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="kh" items="${listKH.content}" varStatus="i">
            <tr>
                <td>${i.index+1}</td>
                <td>${kh.maKH}</td>
                <td>${kh.tenKH}</td>
                <td>${kh.sdt}</td>
                <td>
                    <c:if test="${kh.gioiTinh==true}">Nam</c:if>
                    <c:if test="${kh.gioiTinh==false}">Nữ</c:if>
                </td>
                <td>${kh.hangKhachHang.maHang}-${kh.hangKhachHang.tenHang}</td>
                <td>
                    <button><a href="/khach-hang/delete/${kh.maKH}" onclick="xoa()">Delete</a></button>
                    <button><a href="/khach-hang/detail/${kh.maKH}">Detail</a></button>
                    <button><a href="/khach-hang/view-update/${kh.maKH}">Update</a></button>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <a href="/khach-hang/hien-thi?page=0">Frist</a>
    <a href="/khach-hang/hien-thi?page=${listKH.number-1}">Person</a>
    <a href="/khach-hang/hien-thi?page=${listKH.number+1}">Next</a>
    <a href="/khach-hang/hien-thi?page=${listKH.totalPages-1}">Last</a>

    <br>
    <ul>
        <li>Trang Số Hiện Tại: ${listKH.number}</li>
        <li>Tổng Số Trang: ${listKH.totalPages}</li>
        <li>Tổng Số Phần Tử: ${listKH.totalElements}</li>
    </ul>

    <br>
    <label style="color: red">${mess}</label>

    <script>
        function them() {
            if(confirm("Bạn muốn thêm thông tin ?")){
                return true;
            }else return  false
        }

        function xoa() {
            if(confirm("Bạn muốn xóa thông tin ?")){
                return true;
            }else return  false
        }
    </script>
</main>

</body>
</html>