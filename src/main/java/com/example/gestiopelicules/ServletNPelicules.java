package com.example.gestiopelicules;

import Dades.Conexio;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "ServletNPelicules", value = "/ServletNPelicules")
public class ServletNPelicules extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //Especificar es format de sa resposta
        PrintWriter sortida = response.getWriter();

        //Generar sa resposta de sa peticio
        String get = request.getParameter("numero");        //Agaf es numero que vol des formulari
        int numero = Integer.parseInt(get);                     //El convertesc en INT
        sortida.println("<html><body>");


        String user = "admin";
        String password = "12345678";
        String url = "jdbc:mysql://10.100.64.184/prova";          //Classe
        String url2 = "jdbc:mysql://192.168.1.9/prova";    //Casa
        Connection bd;
        Statement conexio;
        ResultSet resultat;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            bd = DriverManager.getConnection(url,user,password);
            conexio = bd.createStatement();

            sortida.println("<h1>Funciona!</h1>");

            resultat = conexio.executeQuery("SELECT * FROM catalegpelicules limit " + numero + ";"); //Aqui limit es numero de pelis
            while (resultat.next()) {
                sortida.print(resultat.getString("id") + " " + resultat.getString("titol") + " " + resultat.getString("any") + " " + resultat.getString("director") + " " + resultat.getString("genere"));
                sortida.println("<br><hr>");
            }

            bd.close();
            conexio.close();
        }catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        /*try {
            llegirPelicula(numero, response);     //Faig es metode d'abaix amb es num per parametre d'abans
        } catch (SQLException e) {
            e.printStackTrace();
        }*/

        sortida.println("</body></html>");


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }


    private void llegirPelicula(int numeroPelis,HttpServletResponse response) throws SQLException, IOException {

        String user = "admin";
        String password = "12345678";
        String url = "jdbc:mysql://10.100.64.93/prova";          //Classe
        String url2 = "jdbc:mysql://192.168.1.9/prova";    //Casa
        Connection bd;
        Statement conexio;
        ResultSet resultat;

        bd = DriverManager.getConnection(url,user,password);

        conexio = bd.createStatement();

        PrintWriter sortida = response.getWriter();
        sortida.println("<h1>Funciona!</h1>");
        resultat = conexio.executeQuery("SELECT * FROM pelicules limit " + numeroPelis + ";"); //Aqui limit es numero de pelis
        while (resultat.next()) {
            sortida.print(resultat.getString("id") + " " + resultat.getString("titol") + " " + resultat.getString("any") + " " + resultat.getString("director") + " " + resultat.getString("genere"));
        }

        bd.close();
        conexio.close();

    }
}
