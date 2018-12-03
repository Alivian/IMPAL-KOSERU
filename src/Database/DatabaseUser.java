package Database;

import static Database.Mysql_DatabaseConnection.*;
import Model.Admin;
import Model.Person;
import Model.Pinjaman;
import Model.Simpanan;
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
    private final DatabaseSimpanan dbSimpan= new DatabaseSimpanan();
    private final DatabasePenarikan dbTarik= new DatabasePenarikan();

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
        disconnect();
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
            disconnect();
            return sum;
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        disconnect();
        return sum;
    }
    
    public int regis(Person prsn){
        boolean value=false;
        connect();
        try{
            String query = "select * from anggota where kode_ang";
            query +="='"+prsn.getUsername()+"'";
            ResultSet rs = stmt.executeQuery(query);
            if(rs.wasNull()){
                query = "insert into anggota values (";
                query +="'" + prsn.getKode_angg()+ "',";
                query +="'" + prsn.getNama() + "',";
                query +="'" + prsn.getStatus()+ "',";
                query +="'" + prsn.getProfesi()+ "',";
                query +="'" + prsn.getTmplahir()+ "',";
                query +="STR_TO_DATE('"+prsn.getTgllahir().toString()+"', '%Y-%m-%d ')"+",";
                query +="'" + prsn.getEmail()+ "',";
                query +="'" + prsn.getNo_telp()+ "',";
                query +="'" + prsn.getUsername()+ "',";
                query +="'" + prsn.getPassword()+ "')";
                value=manipulate(query);
                if (value==true){
                    disconnect();
                    return 1;
                }
            }else{
                disconnect();
                return 2;
            }
        } catch (Exception e){
            System.out.println(e);
            return 0;
        }
        disconnect();
        return 0;
    }
    
    public boolean update(Person P){
        boolean value = false;
        connect();
        try{
            String query ="update anggota set "
                    + "nama_ang='"+P.getNama()+"',"
                    + "pekerjaan='"+P.getProfesi()+"',"
                    + "no_telp='"+P.getNo_telp()+"',"
                    + "tanggal_lahir=STR_TO_DATE('"+P.getTgllahir().toString()+"', '%Y-%m-%d ')"+","
                    + "tempat_lahir='"+P.getTmplahir()+"',"
                    + "email='"+P.getEmail()+"'"
                    + "where kode_ang='"+P.getKode_angg()+"'";
            value=manipulate(query);
            disconnect();
            return value;
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        disconnect();
        return value;
    }
    
    public Person getData(String user){
        Person prsn=null;
        
        connect();
        try{
            String query = "select * from anggota WHERE username = '"+user+"'";
            rs = stmt.executeQuery(query);
            
            if(rs.next()){
                dbPinjam.getAllPinjaman(rs.getString("kode_ang"));
                dbSimpan.getAllSimpanan(rs.getString("kode_ang"));
                dbTarik.getPenarikanUser(rs.getString("kode_ang"));
                prsn = new Person(rs.getString("kode_ang"),rs.getString("nama_ang"),rs.getString("pekerjaan"),rs.getString("tempat_lahir"),
                        rs.getDate("tanggal_lahir"),rs.getString("email"),rs.getString("status"),rs.getString("no_telp"),
                        rs.getString("username"),rs.getString("password"),dbPinjam.getPinjaman(),dbSimpan.getSimpanan(),dbTarik.getPenarikan());
            }
            
        } catch(Exception z){
            System.out.println(z.getMessage());
        }
        disconnect();
        return prsn;
    }
}
