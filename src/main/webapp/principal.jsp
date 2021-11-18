<%@ page import="Dades.Conexio" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="Dades.Pelicules" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Principal</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

    <%
        ArrayList<Pelicules> llista = (ArrayList<Pelicules>) request.getAttribute("llista");
    %>
</head>
<body>
<h1>Pagina Principal</h1>



<table class="table table-striped">
    <tr>
        <th>ID</th>
        <th>TITOL</th>
        <th>ANY</th>
        <th>DIRECTOR</th>
        <th>GENERE</th>
        <th></th>
        <th></th>
    </tr>
    <%for (Pelicules pelis: llista) { %>
    <tr>
        <td scope='row'><%=pelis.getId()%></td>
        <td><%=pelis.getTitol()%></td>
        <td><%=pelis.getAny()%></td>
        <td><%=pelis.getDirector()%></td>
        <td><%=pelis.getGenere()%></td>
        <td><button><a href="servlet-editar">Editar</a></button></td>
        <td><button><a href="servlet-eliminar?<%pelis.getId();%>">Eliminar</a></button></td>
    </tr>
    <%}%>
</table>
<br>
<a href="insert.jsp"><button>Insertar</button></a>

</body>
</html>