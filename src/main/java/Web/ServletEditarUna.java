package Web;

import Dades.Conexio;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@WebServlet(name = "ServletEliminarUna", value = "/Servlet-EditarUna")
public class ServletEditarUna extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
            RequestDispatcher dispatcher = request.getRequestDispatcher("inici.jsp");
            dispatcher.forward(request, response);
            //response.sendRedirect("principal.jsp");

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
