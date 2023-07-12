<%@ page pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>


<section class="container">
    <form:form action="/gio-hang/update/${gioHang.maGioHang}" method="post" modelAttribute="gioHang">
        Số Điện Thoại <form:input path="khachHang.soDienThoai"/>
        <label>${sdt}</label>
        <br>
        Ghi Chú: <form:input path="ghiChu"/>
        <form:errors path="ghiChu"/> <br>
        Mã Khách Hàng:
        <form:select path="khachHang">
            <option value="">-------</option>
            <c:forEach items="${listKH}" var="kh">
                <option value="${kh.maKhachHang}" ${kh.maKhachHang==gioHang.khachHang.maKhachHang?"selected":""}>${kh.maKhachHang}</option>
            </c:forEach>
        </form:select>
        <label>${error}</label>
        <br>
        Trạng Thái:<form:radiobutton path="trangThai" value="0"/> Ngừng Hoạt Động
        <form:radiobutton path="trangThai" value="1"/> Hoạt Động
        <br>
        <button onclick="sua()">Sửa</button>
    </form:form>

    <script>
        function sua() {
            if (confirm("Bạn muốn sửa dữ liệu ?")) {
                return true;
            } else return false;
        }
    </script>
</section>


</body>
</html>
