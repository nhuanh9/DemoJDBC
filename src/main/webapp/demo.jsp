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
<c:forEach var="st" items="${list}">
    <h2>${st.id}, ${st.name}, ${st.age}</h2>
</c:forEach>
</body>
</html>
