<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 25/05/2023
  Time: 08:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="/account/login" method="post">
    <p>Username:<input name="username"></p>
    <p>Password:<input name="password"></p>
    <p>
        <input type="checkbox" name="remember" value="true">
        Remember me
    </p>
    <div>${mess}</div>
    <button>Login</button>
</form>
</body>
</html>
