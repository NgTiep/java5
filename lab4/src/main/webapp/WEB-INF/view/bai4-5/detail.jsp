<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 23/05/2023
  Time: 12:34
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
<form:form action="/san-pham/detail/${sp.id}" method="get" modelAttribute="sp">
    ID: <form:input path="id"/> <br>
    Name: <form:input path="name"/> <br>
    Price: <form:input path="price"/> <br>
    QTY: <form:input path="qty"/> <br>
</form:form>
</body>
</html>
