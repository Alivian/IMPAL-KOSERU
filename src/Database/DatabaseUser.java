package Database;

import static Database.Mysql_DatabaseConnection.*;
import Model.Admin;
import Model.Person;
import Model.Pinjaman;
import Model.Simpan;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ASUS
 */
public class DatabaseUser extends Mysql_DatabaseConnection{
    ResultSet rs;
    private final DatabasePinjaman dbPinjam= new DatabasePinjaman();
//    ArrayList<Pinjam> ar = new ArrayList();
//    ArrayList<Simpan> sp = new ArrayList();
    
    public int login(String user, String pass){
        int value=0;
        connect();
        try {
            String query = "select * from anggota";
            rs = stmt.executeQuery(query);
            while(rs.next()){
                if(user.equals(rs.getString("username"))&&
                   pass.equals(rs.getString("password"))&&
                        rs.getString("status").equals("ang")){
                    value=1;
                    rs.close(); 
                    break;
                }else if(user.equals(rs.getString("username"))&&
                   pass.equals(rs.getString("password"))&&
                        rs.getString("status").equals("peg")){
                    value=2;
                    rs.close(); 
                    break;
                }
            }
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
        return value;
    }
    
    public int getSum(){
        int sum=0;
        connect();
        try{
            String query = "select count(kode_ang) from anggota";
            ResultSet rs = stmt.executeQuery(query);
            rs.next();
            sum=rs.getInt(1)+1;
            return sum;
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return sum;
    }
    
    public boolean regis(Person prsn){
        boolean value=false;
        connect();
        try{
            String query = "insert into anggota values (";
            query +="'" + prsn.getKode_angg()+ "',";
            query +="'" + prsn.getNama() + "',";
            query +="'" + prsn.getStatus()+ "',";
            query +="'" + prsn.getProfesi()+ "',";
            query +="'" + prsn.getTmplahir()+ "',";
            query +="STR_TO_DATE('"+prsn.getTgllahir()+"', '%Y-%m-%d ')"+",";
            query +="'" + prsn.getEmail()+ "',";
            query +="'" + prsn.getNo_telp()+ "',";
            query +="'" + prsn.getUsername()+ "',";
            query +="'" + prsn.getPassword()+ "')";
            value=manipulate(query);
            return value;
        } catch (Exception e){
            System.out.println(e);
        }
        return value;
    }
//    public int update(String kode_ang,String nama, String prof,String email){
//        int value = 0;
//        try{
//            PreparedStatement pst = connect.prepareStatement("update anggota set nama=?,profesi=?,email=? where kode_ang=?");
//            pst.setString(1, nama);
//            pst.setString(2, prof);
//            pst.setString(3, email);
//            pst.setString(4, kode_ang);
//            value = pst.executeUpdate();
//            return value;
//        }catch (Exception e){
//            System.out.println(e.getMessage());
//        }
//        return value;
//    }
//    
    public Person getData(String user){
        Person prsn=null;
        
        connect();
        try{
            String query = "select * from anggota WHERE username = '"+user+"'";
            rs = stmt.executeQuery(query);
            
            if(rs.next()){
                System.out.println(rs.getString("kode_ang"));
                dbPinjam.getAllPinjaman(rs.getString("kode_ang"));
                prsn = new Person(rs.getString("kode_ang"),rs.getString("nama_ang"),rs.getString("pekerjaan"),rs.getString("tempat_lahir"),
                        rs.getString("tanggal_lahir"),rs.getString("email"),rs.getString("status"),rs.getString("no_telp"),
                        rs.getString("username"),rs.getString("password"),dbPinjam.getPinjaman(),null);
            }
            
        } catch(Exception z){
            System.out.println(z.getMessage());
        }
        return prsn;
    }
}
