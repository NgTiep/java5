<%--<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>--%>
<%--<form:form method="POST" action="/save-product"--%>
<%--    modelAttribute="product"--%>
<%--    enctype="multipart/form-data"--%>
<%-->--%>
<%--    <p>--%>
<%--        Name: <form:input path="name" />--%>
<%--        <form:errors path="name" element="div"/>--%>
<%--    </p>--%>
<%--    <p> Price: <form:input path="price" type="number"/></p>--%>
<%--    <p>--%>
<%--        Category:--%>
<%--        <form:select path="category.id">--%>
<%--            <option value="">----</option>--%>
<%--            <form:options items="${categoryList}"--%>
<%--                itemLabel="name" itemValue="id"--%>
<%--            />--%>
<%--        </form:select>--%>
<%--        &lt;%&ndash;--%>
<%--        <form:radiobuttons  path="category.id"--%>
<%--            items="${categoryList}"--%>
<%--            itemLabel="name" itemValue="id" /> &ndash;%&gt;--%>
<%--        <form:checkboxes  path="categIds"--%>
<%--            items="${categoryList}"--%>
<%--            itemLabel="name" itemValue="id" />--%>
<%--    </p>--%>
<%--    <p>Image:--%>
<%--        <input type="file" name="image"/>--%>
<%--    </p>--%>
<%--    <div>${message}</div>--%>
<%--    <button>Save</button>--%>
<%--</form:form>--%>

Name: ${sanPham.name} <br>
Price: ${sanPham.price}