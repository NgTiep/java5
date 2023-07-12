<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 28/05/2023
  Time: 23:27
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

<form:form action="/product/update/${product.id}" method="post" modelAttribute="product">
    Ma: <form:input path="ma"/> <br>
    Ten: <form:input path="ten"/> <br>
    Gia: <form:input path="gia"/> <br>
    Mo Ta: <form:input path="moTa"/> <br>
    <button>Update</button>
</form:form>

</body>
</html>
