<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 22/05/2023
  Time: 09:10
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

<form action="/san-pham/search" method="get">
    Tên: <input type="text" name="ten"><br>
    <button>Search</button>
</form>
<button><a href="/san-pham/view-add">Add</a></button>
<button><a href="/san-pham/san-pham-nam">San Pham Nam</a></button>
<button><a href="/san-pham/sap-xep">Sap Xep</a></button>

<table>
    <tr>
        <th>ID</th>
        <th>Ma</th>
        <th>Ten</th>
        <th>Gia</th>
        <th>Gioi Tinh</th>
        <th>Loai</th>
        <th>Action</th>
    </tr>
   <tbody>
   <c:forEach items="${listSanPham}" var="sp">
       <tr>
           <td>${sp.id}</td>
           <td>${sp.ma}</td>
           <td>${sp.ten}</td>
           <td>${sp.gia}</td>
           <td>
               <c:if test="${sp.gioiTinh==true}">Nam</c:if>
               <c:if test="${sp.gioiTinh==false}">Nữ</c:if>
           </td>
           <td>${sp.loai}</td>
           <td>
               <button><a href="/san-pham/delete/${sp.id}">Delete</a></button>
               <button><a href="/san-pham/detail/${sp.id}">Detail</a></button>
               <button><a href="/san-pham/view-update/${sp.id}">Update</a></button>
           </td>
       </tr>
   </c:forEach>
   </tbody>
</table>
</body>
</html>
