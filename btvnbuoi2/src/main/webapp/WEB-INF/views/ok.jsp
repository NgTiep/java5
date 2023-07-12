<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 15/05/2023
  Time: 13:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="/ctrl/ok" method="post">
    <button>OK 1</button>
    <button formmethod="get">OK 2</button>
    <button formaction="/ctrl/ok/2">OK 3</button>
</form>


</body>
</html>
