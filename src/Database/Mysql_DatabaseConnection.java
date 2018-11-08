package Database;


import java.sql.Connection;
import java.sql.DriverManager;

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
    public static Connection connect = null;
    public Mysql_DatabaseConnection(){
     //String url = "jdbc:ucanaccess://D://Materi Kuliah Tel-U//Smt 5//IMPAL//Koperasi/Database.accdb";
     String url = "jdbc:mysql://us-cdbr-gcp-east-01.cleardb.net/gcp_eae35478d266dd67ae8b";
     String user = "b517774f39b450"; String pass = "ff8c88ca";
         try {
             //Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
             //Class.forName("net.mysql.jdbc.Driver");
             connect = DriverManager.getConnection(url, user, pass);
             System.out.println("Database terhubung");
         } catch (Exception ex){
             System.out.println(ex.getMessage());
             System.out.println("gagal");
         }
         System.out.println("haha");
    }
}
