<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 04/06/2023
  Time: 07:52
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
</head>
<body>
<section>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">Mã Cơ Sở</th>
            <th scope="col">Mã Tài Khoản Ngân Hàng</th>
            <th scope="col">SĐT Cơ Sở</th>
            <th scope="col">Ghi Chú</th>
            <th scope="col">Trạng Thái</th>
        </tr>
        </thead>
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
                   <button><a href="/co-so/delete/${cs.id}" onclick="xoa()">Delete</a></button>
                   <button><a href="/co-so/detail/${cs.id}">Detail</a></button>
                   <button><a href="/co-so/view-update/${cs.id}">Update</a></button>
                   <button><a href="/co-so/view-add">Add</a></button>
               </td>
           </tr>
       </c:forEach>
        </tbody>
    </table>

    <button><a href="/co-so/hien-thi?number=0">Fr</a></button>
    <button><a href="/co-so/hien-thi?number=${listCoSo.number-1}">Pr</a></button>
    <button><a href="/co-so/hien-thi?number=${listCoSo.number+1}">Nx</a></button>
    <button><a href="/co-so/hien-thi?number=${listCoSo.totalPages-1}">Ls</a></button>

    <br>
    <label style="color: red">${mess}</label>
</section>

<script>
    function xoa() {
        if(confirm("Ban co muon xoa du lieu ?")){
           return true;
        }else return false;
    }
</script>

</body>
</html>
