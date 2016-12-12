<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Employees</title>
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
            <td>
                <a href="edit_employee/${employee.id}">
                    <c:out value="${employee.name}"/>
                </a>
            </td>
            <td><c:out value="${employee.phone}"/></td>
            <c:if test="${not empty employee.photo}">
                <td><img src="<c:url value="/img/photo?id=${employee.id}"/>" alt="photo" height="100" width="100"/></td>
            </c:if>
            <c:if test="${empty employee.photo}">
                <td><img src="https://u.o0bc.com/avatars/no-user-image.gif" alt="photo" height="100" width="100"/></td>
            </c:if>

            <td><a href="delete_employee/${employee.id}">Delete</a></td>
        </tr>
    </c:forEach>
</table>


<form action="<c:url value="/add_employee"/>" enctype="multipart/form-data" method="post">
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
            <td><input type="file" accept=".jpg" name="file"/></td>
        </tr>
    </table>
    <input type="submit" class="button" id="2" value="Add"/>
</form>
<form action="<c:url value="/"/>" method="get">
    <input type="submit" class="button" value="Back to Main Menu"/>
</form>
</body>
</html>
