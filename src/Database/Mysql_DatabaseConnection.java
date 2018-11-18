package Database;


import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ASUS
 */
public class Mysql_DatabaseConnection {
    protected static Connection con = null;
    protected static Statement stmt = null;
    private String url;
    private String user;
    private String pass;

    public Mysql_DatabaseConnection() {
        this.url = "jdbc:mysql://us-cdbr-gcp-east-01.cleardb.net/gcp_eae35478d266dd67ae8b";
        this.user = "b517774f39b450";
        this.pass = "ff8c88ca";
    }
    
    public void connect(){
        try {
             this.url = "jdbc:mysql://us-cdbr-gcp-east-01.cleardb.net/gcp_eae35478d266dd67ae8b";
        this.user = "b517774f39b450";
        this.pass = "ff8c88ca";
             con = DriverManager.getConnection(url, user, pass);
             stmt = con.createStatement();
             System.out.println("Database terhubung");
         } catch (Exception ex){
             System.out.println(ex.getMessage());
             System.out.println("Database gagal");
         }
    }
    
    public void disconnect(){
        try {
            con.close();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(Mysql_DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean manipulate(String query){
        boolean cek = false;
        try {
            int rows = stmt.executeUpdate(query);
            if (rows > 0) cek = true;
        } catch (SQLException ex) {
            Logger.getLogger(Mysql_DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cek;
    }
}
