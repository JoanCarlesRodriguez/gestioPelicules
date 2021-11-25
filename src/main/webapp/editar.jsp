<%@ page import="Dades.Pelicules" %><%--
  Created by IntelliJ IDEA.
  User: alumneifc33b
  Date: 18/11/21
  Time: 11:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:if test="${empty sessionScope.usuari}">
    <c:redirect url="error.jsp"/>
</c:if>
<html>
<head>
    <title>Title</title>

    <%          //Aixo modificar i posar s'id aqui que vendra de Servlet editar GET
        //ArrayList<Pelicules> llista = (ArrayList<Pelicules>) request.getAttribute("llista");
        //Pelicules peli = request.getAttribute("llista");
    %>


</head>
<body>
    <c: items="${pelicula}" var="pelicula">

    <form action="Servlet-EditarUna" method="get">

        <label for="titol" class="form-label">Titol:</label>
        <input type="text" class="form-control" id="titol" name="titol" value="${pelicula.titol}">
        <hr>
        <label for="any" class="form-label">Any:</label>
        <input type="number" class="form-control" id="any" name="any" value="${pelicula.any}">
        <hr>
        <label for="director" class="form-label">Director:</label>
        <input type="text" class="form-control" id="director" name="director" value="${pelicula.director}">
        <hr>
        <label for="genere" class="form-label">Genere:</label>
        <input type="text" class="form-control" id="genere" name="genere" value="${pelicula.genere}">
        <br>
        <button type="submit"  name="id" value="${pelicula.id}" class="btn btn-primary">Insertar</button>
    </form>
    </c:>

    <form action="ServletLogout" method="get">
        <input type="submit" class="btn btn-outline-info" value="Logout" />
    </form>
</body>
</html>
