<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<form:form action="/account/index" modelAttribute="item">
    <form:input path="username" placeholder="Username"/>
    <form:input path="fullname" placeholder="Fullname"/>
    <form:input path="password" placeholder="password"/>
    <form:input path="email" placeholder="email"/>
    <hr>
    <button formaction="/account/create">Create</button>
    <button formaction="/account/update">Update</button>
    <a href="/account/delete/${item.username}">Delete</a>
    <a href="/account/index">Reset</a>
</form:form>