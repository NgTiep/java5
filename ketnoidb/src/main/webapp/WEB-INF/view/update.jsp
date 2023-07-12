<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 28/05/2023
  Time: 23:00
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form:form action="/category/update/${cate.id}" method="post" modelAttribute="cate">
    Ma: <form:input path="ma"/><br>
    Name: <form:input path="name"/><br>
    <button>Update</button>
</form:form>

</body>
</html>
