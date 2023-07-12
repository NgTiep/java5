<%@ page pageEncoding="utf-8" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
    <title>Thiết kế layout</title>
</head>
<body>
<tiles:insertAttribute name="header"/>
<tiles:insertAttribute name="menu"/>
<table style="width:100%" border="1">
    <tr>
        <td valign="top"><tiles:insertAttribute name="body"/></td>
        <td width="250"><tiles:insertAttribute name="aside"/></td>
    </tr>
</table>
<tiles:insertAttribute name="footer"/>
</body>
</html>
