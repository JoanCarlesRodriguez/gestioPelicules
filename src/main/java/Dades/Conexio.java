package Dades;

import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;

public class Conexio {
    private String user = "admin";
    private  String pass = "12345678";
    private String url = "jdbc:mysql://10.100.64.184/prova";          //Classe
    private String url2 = "jdbc:mysql://192.168.1.9/prova";    //Casa


    public static Connection conectar() throws SQLException, ClassNotFoundException {
        String sDriver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://10.100.64.184/prova";          //Classe
        String url2 = "jdbc:mysql://192.168.1.9/prova";    //Casa*/
        String user = "admin";
        String pass = "12345678";
        Class.forName("com.mysql.cj.jdbc.Driver");

        return DriverManager.getConnection(url2, user, pass);
    }
    public static void desconectar(Connection con, Statement sta) throws SQLException {
        sta.close();
        con.close();
    }
}
