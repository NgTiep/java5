<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 10/06/2023
  Time: 00:35
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

<form:form action="/chuc-vu/update/${chucVu.id}" method="post" modelAttribute="chucVu">
    Mã: <form:input path="ma"/> <form:errors path="ma"/> <br>
    Tên: <form:input path="ten"/> <form:errors path="ten"/> <br>
    <button>Update</button>
</form:form>

</body>
</html>
