/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import Model.Penarikan;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Kilam
 */
public class DatabasePenarikan extends Mysql_DatabaseConnection{
    private ResultSet rs = null;
    private ArrayList<Penarikan> penarikan = new ArrayList();
    
    public String cekAnggota(String kode){
        connect();
        String value="";
        try {
            String query = "select * from DataUser";
            rs = stmt.executeQuery(query);
            while(rs.next()){
                if(kode.equals(rs.getString("kode_ang").replaceAll("<div>","").replaceAll("</div>",""))){
                    value = rs.getString("kode_ang");
                    break;
                }
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        disconnect();
        return value;
    }
        
    public int PenarikanUang(String kode, Penarikan pnr){
        int value =0;
        try{
            PreparedStatement pst = connect.prepareStatement("insert into PenarikanUser (kode_ang,tgl_penarikan,jum_penarikan) values (?,?,?)");
            pst.setString(1, kode);
            pst.setString(2, pnr.getTgl());
            pst.setInt(3, pnr.getUang());
            value = pst.executeUpdate();
            return value;
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return value;
    }
    
    public void getAllPenarikan(DefaultTableModel mdl){
        try{
            PreparedStatement pst;
            pst = connect.prepareStatement("select DataUser.nama, PenarikanUser.kode_ang, PenarikanUser.tgl_penarikan, PenarikanUser.jum_penarikan from DataUser join PenarikanUser on DataUser.kode_ang=PenarikanUser.kode_ang");
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                mdl.addRow(new Object[]{rs.getString(2),rs.getString(1),rs.getString(3),rs.getString(4)});
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    public void getPenarikanUser(DefaultTableModel mdl, String kode_ang){
        try{
            PreparedStatement pst;
            pst = connect.prepareStatement("select tgl_penarikan, jum_penarikan from PenarikanUser where kode_ang=?");
            pst.setString(1, kode_ang);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                mdl.addRow(new Object[]{rs.getString(1),rs.getString(2)});
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public int cekSaldo(String kode){
        int saldo = 0;
        int tarik = 0;
        try{
            PreparedStatement pst = connect.prepareStatement("select SUM(jum_simpan) AS total from SimpananUser where kode_ang=?");
            pst.setString(1, kode);
            ResultSet rs = pst.executeQuery();
            while (rs.next()){
                saldo += rs.getInt(1);
            }
            pst = connect.prepareStatement("select SUM(jum_penarikan) AS total from PenarikanUser where kode_ang=?");
            pst.setString(1, kode);
            rs = pst.executeQuery();
            while (rs.next()){
                saldo -= rs.getInt(1);
            }
            return saldo;
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return saldo;
    }
    
    public List<Penarikan> getAllPenarikan(String thn){
        List<Penarikan> ls = new ArrayList();
        try{
            PreparedStatement pst;
            
            pst = connect.prepareStatement("select kode_ang, tgl_penarikan, jum_penarikan from PenarikanUser where tgl_penarikan like ?");
            pst.setString(1,"%"+thn);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){ 
                ls.add(new Penarikan(rs.getString(1),rs.getString(2),Integer.parseInt(rs.getString(3))));
            }
            return ls;
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
            return ls;
    }
}
