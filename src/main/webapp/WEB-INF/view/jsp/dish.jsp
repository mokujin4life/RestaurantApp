<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<table class="center">
    <tr>
        <th>Name</th>
        <th>Weight</th>
        <th>Price</th>
        <th>Photo</th>
        <th>Ingredients</th>
    </tr>
    <c:forEach var="dish" items="${dishes}">
        <tr>
            <td><c:out value="${dish.name}"/></td>
            <td><c:out value="${dish.weight}"/></td>
            <td><c:out value="${dish.price}"/></td>

            <c:if test="${not empty dish.photo}">
                <td><img src="<c:url value="/img/food_img?id=${dish.id}"/>" alt="photo" height="100" width="100"/></td>
            </c:if>
            <c:if test="${empty dish.photo}">
                <td><img src="http://www.finecooking.com/images/no_image_ld.jpg" alt="photo" height="100" width="100"/></td>
            </c:if>
            <form action="dish_save_image/${dish.id}" enctype="multipart/form-data" method="post">
                <td><input type="file" accept=".jpg" name="file"/>
                    <input type="submit" class="button" value="Add"/>
            </form>
            <td><a href="delete_dish/${dish.id}">Delete</a></td>
        </tr>
    </c:forEach>
</table>


<form action="<c:url value="/add_employee"/>" method="post">
    <table class="center">
        <tr>
            <td>Dish Title:</td>
            <td><input type="text" name="title"></td>
        </tr>
        <tr>
            <td>Dish Weight:</td>
            <td><input type="text" name="phone"/></td>
        </tr>
        <tr>
            <td>Dish Price:</td>
            <td><input type="text" name="phone"/></td>
        </tr>
    </table>
    <input type="submit" class="button" id="2" value="Add"/>
</form>
<form action="<c:url value="/"/>" method="get">
    <input type="submit" class="button" value="Back to Main Menu"/>
</form>
</body>
</html>
