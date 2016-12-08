<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Danil
  Date: 08.12.16
  Time: 0:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<table class="center">
    <tr>
        <th>Name</th>
        <th>Phone</th>
        <th>Photo</th>
    </tr>
        <c:forEach var="employee" items="${employees}">
        <tr>
            <td><c:out value="${employee.name}"/></td>
            <td><c:out value="${employee.phone}"/></td>
            <td><c:out value="${employee.photo}"/></td>
        </tr>
        </c:forEach>
</table>


<form action="<c:url value="/add"/>" method="post">
    <table class="center">
        <tr>
            <td>Employee Name:</td>
            <td><input type="text" name="name"></td>
        </tr>
        <tr>
            <td>Employee Phone:</td>
            <td><input type="text" name="phone"/></td>
        </tr>
        <tr>
            <td>Employee Photo:</td>
            <td><input type="text" name="photo"/></td>
        </tr>
    </table>
    <input type="submit" class="button" id="2" value="Add"/>
</form>
</body>
</html>
