package Database;

import static Database.Mysql_DatabaseConnection.*;
import Model.Admin;
import Model.Person;
import Model.Pinjam;
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

//    ArrayList<Pinjam> ar = new ArrayList();
//    ArrayList<Simpan> sp = new ArrayList();
    
    public int login(String user, String pass){
        int value=0;
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
    
//    public int getSum(){
//        int sum=0;
//        try{
//            PreparedStatement st =  connect.prepareStatement("select count(kode_ang) from anggota");
//            ResultSet rs = st.executeQuery();
//            rs.next();
//            sum=rs.getInt(1)+1;
//            return sum;
//        }catch(Exception e){
//            System.out.println(e.getMessage());
//        }
//        return sum;
//    }
//    public int regis(Person prsn){
//        int value =0;
//        try{
//            PreparedStatement pst = connect.prepareStatement("insert into anggota values (?,?,?,?,?,?,?,?,?,?)");
//            pst.setString(1, prsn.getKode_angg());
//            pst.setString(2, "anggota");
//            pst.setString(3, prsn.getNama());
//            pst.setString(4, prsn.getProfesi());
//            pst.setString(5, prsn.getTmpL());
//            java.util.Date utilDate = prsn.getTglL();
//            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
//            pst.setDate(6, sqlDate);
//            pst.setString(7, prsn.getEmail());
//            pst.setString(8, "081234");
//            pst.setString(9, prsn.getUsername());
//            pst.setString(10, prsn.getPassword());
//            value = pst.executeUpdate();
//            
//            return value;
//        } catch (Exception e){
//            System.out.println("aw");
//            System.out.println(prsn.getKode_angg()+prsn.getKode_angg());
//            System.out.println(prsn.getNama());
//            System.out.println(prsn.getPassword());
//            System.out.println(e.getMessage());
//        }
//        return value;
//    }
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
//    public Person getData(String user){
//        Person prsn=null;
//        try{
//            PreparedStatement st =  connect.prepareStatement("select * from anggota");
//            ResultSet rs = st.executeQuery();
//            
//            while(rs.next()){
//                if(user.equals(rs.getString(1).replaceAll("<div>","").replaceAll("</div>",""))){
//                    String a=(rs.getString(1));
//                    String b=(rs.getString(2));
//                    String c=(rs.getString(3));
//                    String d=(rs.getString(4));
//                    String e=(rs.getString(5));
//                    String f=(rs.getString(6));
//                    String g=(rs.getString(7));
//                    PreparedStatement stm =  connect.prepareStatement("select * from PinjamanUser where kode_ang = ?");
//                    stm.setString(1,c);
//                    ResultSet rc = stm.executeQuery();
//                    while(rc.next()){
//                        Pinjam p = new Pinjam(rc.getString(3),rc.getString(4),rc.getInt(5),rc.getString(6),rc.getString(7),rc.getString(8));
//                        ar.add(p);
//                    }
//                    PreparedStatement std =  connect.prepareStatement("select * from SimpananUser where kode_ang = ?");
//                    std.setString(1,c);
//                    ResultSet rd = std.executeQuery();
//                    while(rd.next()){
//                        Simpan s = new Simpan(rd.getString(3),rd.getInt(4));
//                        sp.add(s);
//                    }
//                    //prsn = new Person(rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(1),rs.getString(2),ar,sp);
//                    rs.close();
//                    return prsn;
//                }
//            }
//        } catch(Exception z){
//            System.out.println(z.getMessage());
//        }
//        return prsn;
//    }
}
