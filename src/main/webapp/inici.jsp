<%--
  Created by IntelliJ IDEA.
  User: alumneifc33b
  Date: 18/11/21
  Time: 9:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:if test="${empty sessionScope.usuari}">
    <c:redirect url="error.jsp"/>
</c:if>
<html>
<head>
    <title>INICI</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

</head>
<body>
    <h3>Que vols fer?</h3>
    <br>
    <br>
    <a href="nPelicules.jsp"><button class="btn btn-primary">Veure la taula</button></a>
    <br>
    <a href="insert.jsp"><button class="btn btn-primary">Insertar una nova peli</button></a>

    <form action="ServletLogout" method="get">
        <input type="submit" class="btn btn-outline-info" value="Logout" />
    </form>
</body>
</html>
