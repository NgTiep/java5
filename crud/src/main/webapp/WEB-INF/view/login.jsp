<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 14/05/2023
  Time: 23:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="/login" method="post">
    <label>User name</label>
    <input type="text" name="username"><br>
    <label>Password</label>
    <input type="password" name="password"><br>
    <button type="submit" onclick="login()">Login</button>
    <label>${mess}</label>
</form>

<script>
    function login() {
        if (confirm("Ban muon dang nhap ?")) {
            return true;
        } else {
            return false;
        }
    }
</script>

</body>
</html>
