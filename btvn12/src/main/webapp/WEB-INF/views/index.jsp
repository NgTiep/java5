<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 01/06/2023
  Time: 22:22
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<section>
    <form:form action="/phong-ban/add" method="post" modelAttribute="phongBan">
        Mã: <form:input path="ma"/> <form:errors path="ma"/> <br>
        Tên: <form:input path="ten"/> <form:errors path="ten"/><br>
        Số Lượng Phòng Ban: <form:input path="soLuongPhongBan"/> <form:errors path="soLuongPhongBan"/> <br>
        Số Lượng Nhân Viên: <form:input path="soLuongNhanVien"/> <form:errors path="soLuongNhanVien"/> <br>
        Trạng Thái: <form:radiobutton value="0" path="trangThai"/> Hoạt Động
        <form:radiobutton value="1" path="trangThai"/>Ngừng Hoạt Động
        <form:errors path="trangThai"/>
        <br>
        Mã Loại Phòng Ban:
        <form:select path="loaiPhongBan">
            <c:forEach items="${listLoaiPhongBan}" var="lpb">
                <option value="${lpb.id}" ${lpb.id==phongBan.loaiPhongBan.id?"selected":""}>${lpb.ma}</option>
            </c:forEach>
        </form:select>
        <br>
        <button onclick="add()">ADD</button>
    </form:form>


    <table>
        <tr>
            <th>Mã</th>
            <th>Tên</th>
            <th>Số Lượng Phòng Ban</th>
            <th>Số Lượng Nhân Viên</th>
            <th>Trạng Thái</th>
            <th>Tên Loại Phòng Ban</th>
            <th>Action</th>
        </tr>
        <tbody>
        <c:forEach items="${listPhongBan.content}" var="pb">
            <tr>
                <td>${pb.ma}</td>
                <td>${pb.ten}</td>
                <td>${pb.soLuongPhongBan}</td>
                <td>${pb.soLuongNhanVien}</td>
                <td>
                    <c:if test="${pb.trangThai==0}">Hoạt Động</c:if>
                    <c:if test="${pb.trangThai==1}">Ngừng Hoạt Động</c:if>
                </td>
                <td>${pb.loaiPhongBan.ten}</td>
                <td>
                    <button><a href="/phong-ban/delete/${pb.id}" onclick="xoa()">Detele</a></button>
                    <button><a href="/phong-ban/detail/${pb.id}">Detail</a></button>
                    <button><a href="/phong-ban/view-update/${pb.id}">Update</a></button>
                </td>
            </tr>

        </c:forEach>
        </tbody>
    </table>

    <c:forEach begin="0" end="${ listPhongBan.totalPages -1}" varStatus="loop">
        <a class="page-link" href="/phong-ban/hien-thi?page=${loop.begin + loop.count - 1}">
                ${loop.begin + loop.count }
        </a>
    </c:forEach>

    <br>
    <label style="color:red">${mess}</label>


    <script>
        function add() {
            if (confirm("Bạn muốn thêm thông tin ?")) {
                return true;
            } else {
                return false
            }
        }

        function xoa() {
            if (confirm("Bạn muốn xóa thông tin ?")) {
                return true;
            } else {
                return false
            }
        }


    </script>
</section>

</body>
</html>
