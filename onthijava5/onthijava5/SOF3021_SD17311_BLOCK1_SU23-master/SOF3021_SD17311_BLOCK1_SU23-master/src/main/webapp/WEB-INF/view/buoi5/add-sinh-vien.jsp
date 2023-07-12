<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%--<form action="/sinh-vien/add" method="post">--%>
<%--    MSSV: <input type="text" name="mssv"/>--%>
<%--    <br/>--%>
<%--    Tên: <input type="text" name="ten"/>--%>
<%--    <br/>--%>
<%--    Tuổi: <input type="text" name="tuoi"/>--%>
<%--    <br/>--%>
<%--    Địa chỉ: <input type="text" name="diaChi"/>--%>
<%--    <br/>--%>
<%--    Giới tính:--%>
<%--    <input type="radio" name="gioiTinh" checked value="true"/>Nam--%>
<%--    <input type="radio" name="gioiTinh" value="false"/>Nữ--%>
<%--    <br/>--%>
<%--    <button type="submit">Add</button>--%>
<%--</form>--%>
<form:form action="/sinh-vien/add" method="POST" modelAttribute="sv">
    MSSV: <form:input path="mssv"/>
    <form:errors path="mssv"/>
    <br/>
    Ten: <form:input path="ten"/>
    <form:errors path="ten"/>
    <br/>
    Tuoi: <form:input path="tuoi"/>
    <form:errors path="tuoi"/>
    <br/>
    Dia Chi:<form:input path="diaChi"/>
    <br/>
    Gioi Tinh: <form:radiobutton value="true" path="gioiTinh"/>Nam
    <form:radiobutton value="false" path="gioiTinh" checked="true"/>Nu
    <br/>
    <form:button type="submit"> Add</form:button>
</form:form>
</body>
</html>
