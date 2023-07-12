<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 02/06/2023
  Time: 22:41
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
    <form action="/phong-ban/search" method="get">
        Tên PHòng Ban: <input type="text" name="ten"> <br>
<%--        Min: <input name="min"> <br>--%>
<%--        Min: <input name="max"> <br>--%>
        <button>Search</button>
    </form>

    <br>
    <button><a href="/phong-ban/sap-xep">Sap Xep Phong Ban</a></button>
    <button><a href="/phong-ban/hoat-dong">Hoạt Động</a></button>

    <br>
    <form:form action="/phong-ban/add" method="post" modelAttribute="phongBan">
        Mã: <form:input path="ma"/> <br>
        Tên: <form:input path="ten"/> <br>
        Số Lượng Phòng Ban: <form:input path="soLuongPhongBan"/> <br>
        Số Lượng Nhân Viên: <form:input path="soLuongNhanVien"/> <br>
        Trạng Thái: <form:radiobutton value="0" path="trangThai"/>Hoạt Động
        <form:radiobutton value="1" path="trangThai"/>Ngừng Hoạt Động
        <br>
        Tên Loại Phòng Ban :
        <form:select path="loaiPhongBan">
            <c:forEach items="${listLPB}" var="lpb">
                <option value="${lpb.id}" ${lpb.id==phongBan.loaiPhongBan.id?"selected":""}>${lpb.ten}</option>
            </c:forEach>
        </form:select>
        <br>
        <button>ADD</button>
    </form:form>


    <table>
        <tr>
            <th>Ma</th>
            <th>Ten</th>
            <th>So Luong Phong Ban</th>
            <th>So Luong Nhan Vien</th>
            <th>Trang Thai</th>
            <th>Loai Phong Ban</th>

        </tr>
        <tbody>
        <c:forEach items="${listPB.content}" var="pb">
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
                    <button><a href="/phong-ban/delete/${pb.id}">Delete</a></button>
                    <button><a href="/phong-ban/detail/${pb.id}">Detail</a></button>
                    <button><a href="/phong-ban/view-update/${pb.id}">Update</a></button>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

        <a href="/tai-khoan/hien-thi?page=0">>></a>
        <a href="/tai-khoan/hien-thi?page=${listPB.number-1}"><</a>
        <a href="/tai-khoan/hien-thi?page=${listPB.number+1}">></a>
        <a href="/tai-khoan/hien-thi?page=${listPB.totalPages-1}"> >></a>

<%--    <ul>--%>
<%--        <li>--%>
<%--            <c:forEach begin="0" end="${listPB.totalPages-1}" varStatus="loop">--%>
<%--                <a href="/phong-ban/hien-thi?page=${loop.begin + loop.count -1} ">${loop.begin + loop.count}</a>--%>
<%--            </c:forEach>--%>
<%--        </li>--%>
<%--    </ul>--%>
</section>


</body>
</html>
