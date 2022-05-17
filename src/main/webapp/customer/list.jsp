<%--
  Created by IntelliJ IDEA.
  User: daonhuanh
  Date: 11/30/21
  Time: 11:11 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Đây là danh sách</h1>
<a href="/customers?act=create">Tạo mới</a>
<a href="/customers?act=order">Sắp xếp theo tuổi</a>
<form action="/customers">
    <input type="text" name="key">
    <button>Tìm</button>
</form>
<c:forEach var="cus" items="${dsKH}">
    <h2>${cus.id}, ${cus.name}, ${cus.age}</h2>
</c:forEach>
</body>
</html>
