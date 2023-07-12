<%@ page pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>

<section class="container">
    <form:form action="/phieugiaohang/add" method="post" modelAttribute="phieuGiaoHang">
        Số Điện Thoại: <form:input path="soDienThoai"/> <form:errors path="soDienThoai"/> <br>
        Ngày Giao: <form:input path="ngayGiao"/> <form:errors path="ngayGiao"/> <br>
        Trạng Thái: <form:radiobutton path="trangThai" value="0"/>Kết Thúc
        <form:radiobutton path="trangThai" value="1"/>Bắt Đầu
        <br>
        Địa Chỉ:
        <form:select path="diaChi">
            <option value="">----</option>
            <c:forEach items="${listDC}" var="dc">
                <option value="${dc.maDiaChi}" ${dc.maDiaChi==phieuGiaoHang.diaChi.maDiaChi?"selected":""}>${dc.maDiaChi}</option>
            </c:forEach>
        </form:select>
        <label>${error}</label>
        <br>
        <button onclick="them()">Thêm</button>
    </form:form>

    <script>
        function them() {
            if (confirm("Bạn muốn thêm thông tin ?")) {
                return true;
            } else return false;
        }

    </script>
</section>
</body>
</html>
