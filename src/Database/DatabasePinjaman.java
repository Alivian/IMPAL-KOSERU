/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import static Database.Mysql_DatabaseConnection.stmt;
import Model.Penarikan;
import Model.Pinjaman;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Kilam
 */
public class DatabasePinjaman extends Mysql_DatabaseConnection{
    private ResultSet rs = null;
    private ArrayList<Pinjaman> pinjaman = new ArrayList();

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
    
    public void getAllPinjaman(){
        connect();
        try{
            String query = "select * from pinjaman";
            rs = stmt.executeQuery(query);
            while(rs.next()){
                pinjaman.add(new Pinjaman(
                        rs.getString("kode_pinjam"),
                        rs.getString("kode_ang"),
                        rs.getInt("jum_pinjam"),
                        rs.getString("tgl_pinjam"),
                        rs.getString("ket_pinjam"),
                        rs.getString("status_acc"),
                        rs.getString("ket_lunas"),
                        rs.getString("tgl_lunas")
                ));
            }
            rs.close();
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
    
    public void ubahStatusPinjaman(String kode_ang, String status){
        connect();
        try{
            String query = "update pinjaman set status_acc=";
            query += "'" + status + "'";
            query += "where kode_ang=";
            query += "'" + kode_ang + "'";
            if(manipulate(query)) removePinjaman(kode_ang);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void removePinjaman(String kode_ang){
        for(Pinjaman p : pinjaman){
            if(p.getKode_ang().equals(kode_ang)){
                pinjaman.remove(p);
            }
        }
    }
    
    public ArrayList<Pinjaman> getPinjaman() {
        return pinjaman;
    }

    public void setPinjaman(ArrayList<Pinjaman> pinjaman) {
        this.pinjaman = pinjaman;
    }
}
