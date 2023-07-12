<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 14/05/2023
  Time: 21:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/product" method="post">
    <label>Name</label>
    <input type="text" name="name">
    <label>Number</label>
    <input type="number" name="number">
    <button>Save</button>
</form>

<label>${name}</label> <br>
<label>${number}</label><br>
</body>
</html>
