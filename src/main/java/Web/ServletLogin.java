package Web;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.Objects;

@WebServlet(name = "ServletLogin", value = "/ServletLogin")
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
                RequestDispatcher dispatcher = request.getRequestDispatcher("principal.jsp");
                dispatcher.forward(request, response);
            } else {
                out.println("L'usuari i la contrassenya no son correctes");
                RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
                dispatcher.include(request, response);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        out.println("<html><body>");
        out.println("Password introducido" + request.getParameter("password1"));
    }

    private Boolean verifyAutentication(String usuari, String password) throws SQLException, ClassNotFoundException {
        boolean verify = false;

        String sDriver = "com.mysql.cj.jdbc.Driver";
        String user = "admin";
        String pass = "12345678";
        String url = "jdbc:mysql://10.100.64.93/prova";          //Classe
        String url2 = "jdbc:mysql://192.168.1.11:3306/prova";    //Casa
        Connection bd;
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(url, user, pass);
        Statement sta;
        ResultSet read;

        if (password.equals(pass) && usuari.equals(user)){
            verify = true;
        }else {
            verify = false;
        }
        return verify;

        /*
        try {
            sta = con.createStatement();
            read = sta.executeQuery("SELECT * FROM Users WHERE user = '"+usuari+"'");
            read.next();
            if (Objects.equals(read.getString("password"), password)) {
                verify = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return verify;*/

    }
}
