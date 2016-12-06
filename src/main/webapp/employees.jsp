<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<table style="align-items: center">
    <tr>
        <th>Name</th>
        <th>Phone</th>
        <th>Photo</th>
    </tr>
    <c:forEach var="employee" items="${employees}">
        <tr>
            <td>${employee.name}</td>
            <td>${employee.phone}</td>
            <td>${employee.photo}</td>
        </tr>
    </c:forEach>

</table>
</body>
</html>
