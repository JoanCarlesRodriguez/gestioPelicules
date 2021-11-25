<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
    <h1>Gestio de Pelicules</h1>

    <form action="Servlet-Login" method="post">

        <label for="username" class="form-label">Usuari: </label>
        <input type="text" class="form-control" id="username" name="username" aria-describedby="usuariHelp">
        <hr>
        <label for="password1" class="form-label">Password</label>
        <input type="password" class="form-control" id="password1" name="password1">
<br>
        <button type="submit" class="btn btn-primary">Entrar</button>
    </form>
</body>
</html>