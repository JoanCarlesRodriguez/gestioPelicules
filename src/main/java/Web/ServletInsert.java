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

@WebServlet(name = "ServletInsert", value = "/servlet-insert")
public class ServletInsert extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter sortida = response.getWriter();
        try {
            insertar(request,response);
            RequestDispatcher dispatcher = request.getRequestDispatcher("principal.jsp");
            dispatcher.forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    public void insertar (HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException, ClassNotFoundException, ServletException {
        //Especificar es format de sa resposta
        PrintWriter sortida = response.getWriter();
        Connection con = Conexio.conectar();
        Statement sta;
        ResultSet read;

        String titol = request.getParameter("titiol");
        String any = request.getParameter("any");
        String director = request.getParameter("director");
        String genere = request.getParameter("genere");

        sta = con.createStatement();
        sta.executeUpdate("INSERT into catalegpelicules (titol,any,director,genere) values ('"+titol+"'," + any + ",'"+director+"','"+genere+"');");



    }
}
