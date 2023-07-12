<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 24/05/2023
  Time: 13:51
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form:form action="/student/save" modelAttribute="student">
    Name: <form:input path="name"/> <form:errors path="name"/> <br>
    Email: <form:input path="email" type="email"/> <form:errors path="email"/> <br>
    Marks: <form:input path="marks" type="number"/> <form:errors path="marks"/> <br>
    Gender: <form:radiobuttons path="gender" items="${genders}" checked="true"/> <form:errors path="gender"/><br>
    Faculty: <form:select path="faculty" items="${faculties}"/> <form:errors path="faculty"/><br>
    Hobbies :<form:checkboxes path="hobbies" items="${hobbies}"/> <br>
    <form:errors path="hobbies"/><br>
    <button>Save</button>
</form:form>

</body>
</html>
