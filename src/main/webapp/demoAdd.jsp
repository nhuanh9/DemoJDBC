<%--
  Created by IntelliJ IDEA.
  User: daonhuanh
  Date: 5/27/22
  Time: 2:48 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post">
    <input type="text" name="name">
    <input type="text" name="price">
    <select name="category">
        <c:forEach var="cate" items="${cates}">
            <option value="${cate.id}">${cate.name}</option>
        </c:forEach>
    </select>
    <button>Thêm</button>
</form>
</body>
</html>
