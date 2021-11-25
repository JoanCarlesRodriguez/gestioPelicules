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

@WebServlet(name = "ServletEliminar", value = "/servlet-eliminar")
public class ServletEliminar extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter sortida = response.getWriter();


        try {
            Connection con = Conexio.conectar();
            Statement sta;
            ResultSet read;
            String id = request.getParameter("id");
            sta = con.createStatement();
            sta.executeUpdate("DELETE from catalegpelicules where id='" + id + "';");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        //Aqui he de "recrear" sa vista imprimint aqui i que me demani si vol eliminar o no, si es que si fer query per eliminar.
        //Tmb puc fer-ho amb una vista passant s'id oculta a sa vista i fer un formulari alla.


        RequestDispatcher dispatcher = request.getRequestDispatcher("inici.jsp");
        dispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        try {
            Connection con = Conexio.conectar();
            Statement sta;
            ResultSet read;
            String id = request.getParameter("id");
            sta = con.createStatement();
            sta.executeUpdate("DELETE from catalegpelicules where id=" + id + ";");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        //Aqui he de "recrear" sa vista imprimint aqui i que me demani si vol eliminar o no, si es que si fer query per eliminar.
        //Tmb puc fer-ho amb una vista passant s'id oculta a sa vista i fer un formulari alla.







        RequestDispatcher dispatcher = request.getRequestDispatcher("inici.jsp");
        dispatcher.forward(request, response);
    }
}
