package Dades;

import java.sql.*;

public class Conexio {


    public Connection Conexio() throws SQLException {
            String sDriver = "com.mysql.cj.jdbc.Driver";
        String user = "admin";
        String pass = "12345678";
        String url = "jdbc:mysql://10.100.64.93/prova";          //Classe
        String url2 = "jdbc:mysql://192.168.1.9/prova";    //Casa
        Connection bd;
        //Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(url2, user, pass);
        Statement sta;
        ResultSet read;
        return con;
    }
    public static void desconectar(Connection con, Statement sta) throws SQLException {
        sta.close();
        con.close();
    }
}
