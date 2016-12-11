<%--
  Created by IntelliJ IDEA.
  User: Danil
  Date: 08.12.16
  Time: 19:31
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
    <c:forEach var="employee" items="${dishes}">
        <tr>
            <td><c:out value="${dish.name}"/></td>
            <td><c:out value="${dish.weight}"/></td>
            <td><c:out value="${dish.price}"/></td>
        </tr>
    </c:forEach>
</table>


<form action="<c:url value="/add_employee"/>" method="post">
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