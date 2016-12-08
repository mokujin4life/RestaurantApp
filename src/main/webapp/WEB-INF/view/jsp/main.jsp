<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
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
<from:form action="employee.jsp" method="get">
  <button type="submit" class="button">Employees</button>
</from:form>
<form action="<c:url value="/dishes"/>" method="get">
  <button type="submit" class="button">Dishes</button>
</form>
</body>
</html>
