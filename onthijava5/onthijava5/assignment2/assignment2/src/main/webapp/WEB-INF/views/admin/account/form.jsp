<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
</head>
<body>

<div class="container ">

    <form:form action="/admin/account/index" modelAttribute="item">
        <div class="mb-4">
            <label class="form-label">Username</label>
            <form:input class="form-control" path="username"/>
        </div>
        <div class="mb-4">
            <label class="form-label">Password</label>
            <form:input class="form-control" path="password"/>
        </div>

        <div class="mb-4">
            <label class="form-label">Fullname</label>
            <form:input class="form-control" path="fullname"/>
        </div>

        <div class="mb-4">
            <label class="form-label">Email</label>
            <form:input class="form-control" path="email"/>
        </div>

        <button type="submit" class="btn btn-sm btn-danger" formaction="/admin/account/create">Create</button>
        <button type="submit" class="btn btn-sm btn-secondary" formaction="/admin/account/update">Update</button>
    </form:form>

</div>
</body>
</html>