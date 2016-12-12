<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
            <c:if test="${not empty employee.photo}">
                <td><img src="<c:url value="/img/photo?id=${employee.id}"/>" alt="photo" height="100" width="100"/></td>
            </c:if>
            <form action="save_image/${employee.id}" enctype="multipart/form-data" method="post">
                <td><input type="file" accept=".jpg" name="photo"/>
                    <input type="submit" class="button" value="Add"/>
            </form>
            <td><a href="delete_employee/${employee.id}">Delete</a></td>
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
    </table>
    <input type="submit" class="button" id="2" value="Add"/>
</form>
</body>
</html>
