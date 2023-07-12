<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 19/05/2023
  Time: 14:13
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form:form action="/giang-vien/add" method="POST" modelAttribute="gv">
    Ma: <form:input  path="ma"/>
    <form:errors path="ma"/>
    <br>
    Ho Ten: <form:input path="hoTen"/>
    <form:errors path="hoTen"/>
    <br>
    Tuoi: <form:input path="tuoi"/>
    <form:errors path="tuoi"/>
    <br>
    Que Quan: <form:input path="queQuan"/>
    <form:errors path="queQuan"/>
    <br>
    <button>Add</button>
</form:form>


</body>
</html>
