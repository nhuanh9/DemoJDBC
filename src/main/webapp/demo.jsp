<%--
  Created by IntelliJ IDEA.
  User: daonhuanh
  Date: 5/18/22
  Time: 9:24 AM
  To change this template use File | Settings | File Templates.
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:forEach var="pro" items="${ds}">
    <h2>${pro.name}, ${pro.price}, ${pro.category.name}</h2>
</c:forEach>
</body>
</html>
