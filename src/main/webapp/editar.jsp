<%@ page import="Dades.Pelicules" %><%--
  Created by IntelliJ IDEA.
  User: alumneifc33b
  Date: 18/11/21
  Time: 11:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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

    <form action="servlet-editar" method="post">
        <label for="titol" class="form-label">Titol:</label>
        <input type="text" class="form-control" id="titol" name="titol" value="${pelicula.id}">
        <hr>
        <label for="any" class="form-label">Any:</label>
        <input type="number" class="form-control" id="any" name="any">
        <hr>
        <label for="director" class="form-label">Director:</label>
        <input type="text" class="form-control" id="director" name="director">
        <hr>
        <label for="genere" class="form-label">Genere:</label>
        <input type="text" class="form-control" id="genere" name="genere">
        <br>
        <button type="submit" class="btn btn-primary">Insertar</button>
    </form>

</body>
</html>
