<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<form:form action="/student/save" modelAttribute="student">
    Name: <form:input path="name"/> <form:errors path="name"/> <br>
    Email: <form:input path="email" type="email"/> <form:errors path="email"/> <br>
    Marks: <form:input path="marks" type="number"/> <form:errors path="marks"/> <br>
    Gender: <form:radiobuttons path="gender" items="${genders}" checked="true"/> <br>
    Faculty: <form:select path="faculty" items="${faculties}"/><br>
    Hobbies :<form:checkboxes path="hobbies" items="${hobbies}"/> <br>
    <form:errors path="hobbies"/><br>
    <button>Save</button>
</form:form>