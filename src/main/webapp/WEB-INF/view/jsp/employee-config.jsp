<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: mokujin
  Date: 12/12/16
  Time: 9:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Employee Configurations</title>
</head>
<body>
<c:set var="employee" value="${employee}"/>
<form action="<c:url value="/update_employee/${employee.id}"/>" enctype="multipart/form-data" method="post">
    <table class="center">
        <tr>
            <td>New Name:</td>
            <td><input type="text" name="name"></td>
        </tr>
        <tr>
            <td>New Phone:</td>
            <td><input type="text" name="phone"/></td>
        </tr>
        <tr>
            <td>New Photo:</td>
            <td><input type="file" accept=".jpg" name="file"/></td>
        </tr>
    </table>
    <input type="submit" class="button" id="2" value="Change"/>
</form>
<h4></h4>
</body>
</html>
