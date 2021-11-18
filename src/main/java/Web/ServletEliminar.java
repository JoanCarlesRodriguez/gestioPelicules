package Web;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ServletEliminar", value = "/ServletEliminar")
public class ServletEliminar extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");

        //Aqui he de "recrear" sa vista imprimint aqui i que me demani si vol eliminar o no, si es que si fer query per eliminar.
        //Tmb puc fer-ho amb una vista passant s'id oculta a sa vista i fer un formulari alla.

        RequestDispatcher dispatcher = request.getRequestDispatcher("inici.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
