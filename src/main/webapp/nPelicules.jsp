<%--
  Created by IntelliJ IDEA.
  User: alumneifc33b
  Date: 18/11/21
  Time: 9:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:if test="${empty sessionScope.usuari}">
    <c:redirect url="error.jsp"/>
</c:if>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>

<form action="ServletNPelicules" method="get">
    <label>Numero de pelicules: </label>
    <input type="number" name="numero">
    <input type="submit" value="Cercar">
</form>
<form action="ServletLogout" method="get">
    <input type="submit" class="btn btn-outline-info" value="Logout" />
</form>
</body>
</html>
