<%--
  Created by IntelliJ IDEA.
  User: alumneifc33b
  Date: 16/11/21
  Time: 11:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <title>INSERT</title>
</head>
<body>
<h2>INSERT</h2>
<form action="servlet-insert" method="get">
    <label for="titol" class="form-label">Titol:</label>
    <input type="text" class="form-control" id="titol" name="titol">
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
