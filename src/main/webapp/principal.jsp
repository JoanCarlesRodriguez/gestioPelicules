<%@ page import="Dades.Conexio" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Principal</title>
</head>
<body>
<h1>pag Principal</h1>

<%
    try {
        Conexio
        Class.forName("com.mysql.jdbc.Driver");
        bd = DriverManager.getConnection(url2, user, password);
        conexio = bd.createStatement();

        sortida.println("<h1>Totes ses Pelicules</h1>");
        sortida.println("<h3>Que vols fer??</h3><br>" +
                "<a href='npelicules.html'>Cercar pelicules</a><br><hr>");

        resultat = conexio.executeQuery("SELECT * FROM catalegpelicules;");
        while (resultat.next()) {
            sortida.print(resultat.getString("id") + " " + resultat.getString("titol") + " " + resultat.getString("any") + " " + resultat.getString("director") + " " + resultat.getString("genere"));
            sortida.println("<br><hr>");

        }

        bd.close();
        conexio.close();
    } catch (SQLException | ClassNotFoundException e) {
        e.printStackTrace();
    }
%>
</body>
</html>