<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 12/05/2023
  Time: 08:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="login" method="post">
    <label>User</label>
    <input type="text" placeholder="user" name="username"><br>
    <label>Pass</label>
    <input type="password" placeholder="password" name="password"><br>
    <button type="submit" onclick="error()">Login</button>
    <label>${mess}</label>
</form>

<script>
    function error() {
        if (confirm("Ban muon dang nhap ?")) {
            return true;
        } else {
            return false;
        }
    }
</script>


</body>
</html>
