<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 13/05/2023
  Time: 08:21
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form:form action="index" method="post"
           modelAttribute="product" enctype="multipart/form-data">
    Name: <form:input path="name"></form:input><br>
    <%--    Category:--%>
    <%--    <form:select path="category.id">--%>
    <%--        <option selected value="">------</option>--%>
    <%--        <form:option  value=""></form:option>--%>
    <%--    </form:select>--%>
    <%--    <form:radiobuttons path=""></form:radiobuttons>--%>
    Image:<input type="file" name="image">
    <button type="submit">Save</button>
</form:form>

</body>
</html>
