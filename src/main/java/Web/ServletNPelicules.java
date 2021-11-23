package Web;

import Dades.Conexio;
import Dades.Pelicules;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;

@WebServlet(name = "ServletNPelicules", value = "/ServletNPelicules")
public class ServletNPelicules extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //Especificar es format de sa resposta
        PrintWriter sortida = response.getWriter();

        //Generar sa resposta de sa peticio
        String get = request.getParameter("numero");        //Agaf es numero que vol des formulari
        int numero = Integer.parseInt(get);                     //El convertesc en INT



        try {

            Connection con = Conexio.conectar();
            Statement sta;
            ResultSet read;
            sta = con.createStatement();

            sortida.println("<h1>Funciona!</h1>");
            ArrayList salut = llista(numero);
            request.setAttribute("llista",salut);
            RequestDispatcher dispatcher = request.getRequestDispatcher("principal.jsp");
            dispatcher.forward(request, response);

            con.close();
            sta.close();
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

    private ArrayList llista(int num) throws SQLException, ClassNotFoundException {

        Connection con = Conexio.conectar();
        Statement sta;
        ResultSet read;

        ArrayList<Pelicules> llista = new ArrayList<Pelicules>();

        try {
            sta = con.createStatement();
            read = sta.executeQuery("SELECT * FROM catalegpelicules limit " + num +";");
            while (read.next()) {
                Pelicules pelicules = new Pelicules();
                pelicules.setId(read.getString("id"));
                pelicules.setTitol(read.getString("titol"));
                pelicules.setAny(read.getString("any"));
                pelicules.setDirector(read.getString("director"));
                pelicules.setGenere(read.getString("genere"));
                llista.add(pelicules);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return llista;
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
