<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 05/06/2023
  Time: 22:56
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<section>
    <form:form action="/co-so/add" method="post" modelAttribute="coSo">
        Mã Cơ Sở: <form:input path="ma"/> <form:errors path="ma"/><br>
        Mã Tài Khoản Ngân Hàng:
        <form:select path="taiKhoanNganHang">
            <c:forEach var="tknh" items="${listTKNH.content}">
                <option value="${tknh.id}" ${tknh.id==coSo.taiKhoanNganHang.id?"selected":""}>${tknh.ma}</option>
            </c:forEach>
        </form:select>

        <br>
        Số Điện Thoại: <form:input path="soDienThoai"/> <form:errors path="soDienThoai"/><br>
        Ghi Chú: <form:input path="ghiChu"/> <form:errors path="ghiChu"/><br>
        Trạng Thái:
        <form:radiobutton value="0" path="trangThai"/> Hoạt Động
        <form:radiobutton value="1" path="trangThai"/> Ngừng Hoạt Động
        <form:errors path="trangThai"/>
        <br>
        <button>ADD</button>
    </form:form>

    <table>
        <tr>
            <th>Mã Cơ Sở</th>
            <th>Mã Tài Khoản Ngân Hàng</th>
            <th>Số Điện Thoại</th>
            <th>Ghi Chú</th>
            <th>Trạng Thái</th>
            <th> </th>
        </tr>
       <tbody>
       <c:forEach items="${listCoSo.content}" var="cs">
           <tr>
               <td>${cs.ma}</td>
               <td>${cs.taiKhoanNganHang.ma}</td>
               <td>${cs.soDienThoai}</td>
               <td>${cs.ghiChu}</td>
               <td>
                   <c:if test="${cs.trangThai==0}">Hoạt Động</c:if>
                   <c:if test="${cs.trangThai==1}">Ngừng Hoạt Động</c:if>
               </td>
               <td>
                   <button><a href="/co-so/delete/${cs.id}">Delete</a></button>
                   <button><a href="/co-so/detail/${cs.id}">Detail</a></button>
                   <button><a href="/co-so/view-update/${cs.id}">Update</a></button>
               </td>
           </tr>
       </c:forEach>
       </tbody>
    </table>

    <a href="/co-so/hien-thi?number=0">Fr</a>
    <a href="/co-so/hien-thi?number=${listCoSo.number-1}">Ps</a>
    <a href="/co-so/hien-thi?number=${listCoSo.number+1}">Nx</a>
    <a href="/co-so/hien-thi?number=${listCoSo.totalPages-1}">Ls</a>

</section>


</body>
</html>
