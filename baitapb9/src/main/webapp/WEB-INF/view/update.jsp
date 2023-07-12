<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 30/05/2023
  Time: 15:06
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form:form action="/lop-hoc/update/${lopHoc.id}" method="post" modelAttribute="lopHoc">
    Name: <form:input path="name"/><br>
    <button>Update</button>
</form:form>


</body>
</html>
