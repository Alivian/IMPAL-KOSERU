/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import Model.Penarikan;
import java.sql.ResultSet;
import java.sql.SQLException;
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
    
    public String cekAnggota(String kode_ang){
        connect();
        String nama_ang="";
        try {
            String query = "select * from anggota";
            rs = stmt.executeQuery(query);
            while(rs.next()){
                if(kode_ang.equals(rs.getString("kode_ang"))){
                    nama_ang = rs.getString("nama_ang");
                    rs.close();
                    break;
                }
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        disconnect();
        return nama_ang;
    }
    
    public int cekSaldo(String kode_ang){
        connect();
        int saldo = 0;
        try{
            String query_simpan = "select SUM(jum_simpan) AS total from simpanan where kode_ang=";
            query_simpan += "'" + kode_ang + "'";
            rs = stmt.executeQuery(query_simpan);
            while (rs.next()){
                saldo += rs.getInt(1);
            }
            rs.close();
            String query_tarik = "select SUM(jum_penarikan) AS total from penarikan where kode_ang=";
            query_tarik += "'" + kode_ang + "'";
            rs = stmt.executeQuery(query_tarik);
            while (rs.next()){
                saldo -= rs.getInt(1);
            }
            rs.close();
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        disconnect();
        return saldo;
    }
    
    public int getSum(String kode_ang){
        int sum=0;
        connect();
        try{
            String query = "select count(kode_penarikan) from penarikan where kode_ang=";
            query  += "'" + kode_ang + "'";
            rs = stmt.executeQuery(query);
            rs.next();
            sum = rs.getInt(1) + 1;
            disconnect();
            return sum;
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        disconnect();
        return sum;
    }
        
    public void PenarikanUang(Penarikan p){
        connect();
        try{
            String query = "insert into penarikan values(";
            query += "'" + p.getKode_penarikan() + "',";
            query += "'" + p.getKode_ang() + "',";
            query += "'" + p.getJum_penarikan() + "',";
            query +="STR_TO_DATE('" + p.getTgl_penarikan() + "', '%Y-%m-%d'))";
            if(manipulate(query)) penarikan.add(p);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        disconnect();
    }
    
    public void getPenarikanUser(String kode_ang){
        connect();
        try{
            String query = "select * from penarikan where kode_ang=";
            query += "'"+kode_ang+"'";
            rs = stmt.executeQuery(query);
            while(rs.next()){
                penarikan.add(new Penarikan(
                        rs.getDouble("jum_penarikan"),
                        rs.getString("kode_ang"),
                        rs.getString("kode_penarikan"),
                        rs.getString("tgl_penarikan")
                ));
            }
            rs.close();
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        disconnect();
    }
    
    public void getAllPenarikan(){
        connect();
        try{
            String query = "select * from penarikan";
            rs = stmt.executeQuery(query);
            while(rs.next()){
                penarikan.add(new Penarikan(
                        rs.getDouble("jum_penarikan"),
                        rs.getString("kode_ang"),
                        rs.getString("kode_penarikan"),
                        rs.getString("tgl_penarikan")
                ));
            }
            rs.close();
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        disconnect();
    }

    public ArrayList<Penarikan> getPenarikan() {
        return penarikan;
    }

    public void setPenarikan(ArrayList<Penarikan> penarikan) {
        this.penarikan = penarikan;
    }
    
    
    
}
