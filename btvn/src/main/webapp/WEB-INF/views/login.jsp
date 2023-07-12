<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 13/05/2023
  Time: 01:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="/login" method="post">
    <label>Username</label>
    <input type="text" placeholder="username" name="username"> <br>
    <label>Password</label>
    <input type="passwords" placeholder="password" name="password"> <br>
    <button type="submit" onclick="error()">LOgin</button>
    <label>${mess}</label>
</form>

<script>
    function error() {
        if (confirm("Bạn có chắc muốn đăng nhập")) {
            return true;
        } else {
            return false;
        }
    }
</script>
</body>
</html>
