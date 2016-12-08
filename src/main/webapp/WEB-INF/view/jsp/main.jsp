<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Danil
  Date: 08.12.16
  Time: 2:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome, Guest</title>
</head>
<body>
<form action="<c:url value="/employees"/>" method="get">
  <button type="submit" class="button">Employees</button>
</form>
<form action="<c:url value="/dishes"/>" method="get">
  <button type="submit" class="button">Dishes</button>
</form>
</body>
</html>
