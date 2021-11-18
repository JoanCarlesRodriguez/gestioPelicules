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
import java.util.Objects;

@WebServlet(name = "ServletLogin", value = "/Servlet-Login")
public class ServletLogin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String username = request.getParameter("username");
        String password = request.getParameter("password1");

        try {
            if(verifyAutentication(username, password)) {
                /*ArrayList salut = llista();
                request.setAttribute("llista",salut);*/

                RequestDispatcher dispatcher = request.getRequestDispatcher("inici.jsp");
                dispatcher.forward(request, response);
            } else {
                out.println("L'usuari i la contrassenya no son correctes");
                RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
                dispatcher.include(request, response);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
    private ArrayList llista() throws SQLException, ClassNotFoundException {

        Connection con = Conexio.conectar();
        Statement sta;
        ResultSet read;

        ArrayList<Pelicules> llista = new ArrayList<Pelicules>();

        try {
            sta = con.createStatement();
            read = sta.executeQuery("SELECT * FROM catalegpelicules;");
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

    private Boolean verifyAutentication(String usuari1, String password) throws SQLException, ClassNotFoundException {
        boolean verify = false;

        Connection con = Conexio.conectar();
        Statement sta;
        ResultSet read;

        try {
            sta = con.createStatement();
            read = sta.executeQuery("SELECT * FROM Users WHERE usuari = '"+usuari1+"'");
            read.next();
            if (Objects.equals(read.getString("password"), password)) {
                verify = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return verify;

    }

}
