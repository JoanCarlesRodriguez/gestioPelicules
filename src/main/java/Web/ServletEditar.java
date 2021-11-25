package Web;

import Dades.Conexio;
import Dades.Pelicules;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@WebServlet(name = "ServletEditar", value = "/servlet-editar")
public class ServletEditar extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter sortida = response.getWriter();

        String id = request.getParameter("id");
        String titol = request.getParameter("titol");
        String any = request.getParameter("any");
        String director = request.getParameter("director");
        String genere = request.getParameter("genere");

        sortida.println("<h2>"+ titol + "</h2>");
        sortida.println("<h2>"+ director + "</h2>");


        Pelicules pelicula1 = new Pelicules();
        pelicula1.setId(id);
        pelicula1.setTitol(titol);
        pelicula1.setAny(any);
        pelicula1.setDirector(director);
        pelicula1.setGenere(genere);


        request.setAttribute("pelicula",pelicula1);
        RequestDispatcher dispatcher = request.getRequestDispatcher("editar.jsp");
        dispatcher.forward(request, response);

        /*
        Redirigir aquest get amb s'id a un formulari amb tota sa info des producte, i en es formulari posar en es values de cada input
        es valors que li pas (que son es des producte), d'aquesta forma ell pot "edita" damunt lo que ja te, despres enviar i fer-ho
        per POST, i alla fer sa Query editant a sa bbdd amb sos parametres rebuts des formulari EDITAR.
        * */

        //RequestDispatcher dispatcher = request.getRequestDispatcher("inici.jsp");
        //dispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter sortida = response.getWriter();

        String id = request.getParameter("id");
        String titol = request.getParameter("titol");
        String any = request.getParameter("any");
        String director = request.getParameter("director");
        String genere = request.getParameter("genere");

        Connection con;
        Statement sta;
        ResultSet read;
        try {
            con = Conexio.conectar();
            sta = con.createStatement();
            sta.executeUpdate("update catalegpelicules set titol='"+titol+"', any="+any+", director='"+director+"', genere='"+genere+"' where id="+id+";");
            RequestDispatcher dispatcher = request.getRequestDispatcher("principal.jsp");
            dispatcher.forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
}
