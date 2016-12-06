<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<form action="employee_adding.jsp" method="get">
    <table class="center">
        <tr>
            <td>Name:</td>
            <td><label>
                <input type="text" name="employeeName">
            </label></td>
        </tr>
        <tr>
            <td>Phone:</td>
            <td><label>
                <input type="text" name="employeePhone"/>
            </label></td>
        </tr>
        <tr>
            <td>Photo:</td>
            <td><label>
                <input type="text" name="employeePhoto"/>
            </label></td>
        </tr>
    </table>
    <input type="submit" class="button" id="2" value=" Add "/>
</form>
<a href="<c:url value="/employees"/>">Show all employees</a>
</body>
</html>
