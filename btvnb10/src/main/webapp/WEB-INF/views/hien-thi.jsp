<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 31/05/2023
  Time: 16:50
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

<section>

    <form action="/nhan-vien/search" method="get">
        Tên: <input type="text" name="ten">
        <button>Search</button>
    </form>

    <button><a href="/nhan-vien/view-add">ADD</a></button>
    <button><a href="/nhan-vien/sap-xep">Sap Xep Ten</a></button>

    <table>
        <tr>
            <th>Ma</th>
            <th>Ho Ten</th>
            <th>Gioi Tinh</th>
            <th>Dia Chi</th>
            <th>Tên Cửa Hàng</th>
            <th>Tên Chức Vụ</th>
            <th>Action</th>
        </tr>
        <tbody>
        <c:forEach items="${listNhanVien.content}" var="nv">
            <tr>
                <td>${nv.ma}</td>
                <td>${nv.ho} ${nv.tenDem} ${nv.ten}</td>
                <td>${nv.gioiTinh}</td>
                <td>${nv.diaChi}</td>
                <td>${nv.cuaHang.ten}</td>
                <td>${nv.chucVu.ten}</td>
                <td>
                    <button><a href="/nhan-vien/delete/${nv.id}" onclick="xoa()">Delete</a></button>
                    <button><a href="/nhan-vien/view-update/${nv.id}">Update</a></button>
                    <button><a href="/nhan-vien/detail/${nv.id}">Detail</a></button>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <c:forEach begin="0" end="${ listNhanVien.totalPages -1}" varStatus="loop">
        <a class="page-link" href="/nhan-vien/hien-thi?page=${loop.begin + loop.count - 1}">
                ${loop.begin + loop.count }
        </a>
    </c:forEach>

    <div>${mess}</div>
</section>

<script>
    function xoa() {
        if (confirm("Bạn muốn xóa dữ liệu ?")) {
            return true;
        } else {
            return false;
        }
    }
</script>

</body>
</html>
