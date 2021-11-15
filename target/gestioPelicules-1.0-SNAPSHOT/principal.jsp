<%@ page import="java.beans.Statement" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="sun.net.smtp.SmtpPrintStream" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="java.io.PrintWriter" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Principal</title>
</head>
<body>
<h1>pag Principal</h1>

<%
    String user = "admin";
    String password = "12345678";
    String url = "jdbc:mysql://10.100.64.93/prova";          //Classe
    String url2 = "jdbc:mysql://192.168.1.9/prova";    //Casa
    Connection bd;
    Statement conexio;
    ResultSet resultat;

    try {
        Class.forName("com.mysql.jdbc.Driver");
        bd = DriverManager.getConnection(url2, user, password);
        conexio = (Statement) bd.createStatement();

        PrintWriter sortida = response.getWriter();
        sortida.println("<h1>Totes ses Pelicules</h1>");
        sortida.println("<h3>Que vols fer??</h3><br>" +
                "<a href='npelicules.html'>Cercar pelicules</a><br><hr>");

        resultat = ((java.sql.Statement) conexio).executeQuery("SELECT * FROM catalegpelicules;");
        while (resultat.next()) {
            sortida.print(resultat.getString("id") + " " + resultat.getString("titol") + " " + resultat.getString("any") + " " + resultat.getString("director") + " " + resultat.getString("genere"));
            sortida.println("<br><hr>");

        }

        bd.close();
        ((java.sql.Statement) conexio).close();
    } catch (SQLException | ClassNotFoundException e) {
        e.printStackTrace();
    }
%>
</body>
</html>