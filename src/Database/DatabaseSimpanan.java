/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import static Database.Mysql_DatabaseConnection.stmt;
import Model.Pinjaman;
import Model.Simpanan;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


/**
 *
 * @author Oliver Queen
 */
public class DatabaseSimpanan extends Mysql_DatabaseConnection{
    private ResultSet rs = null;
    private ArrayList<Simpanan> simpanan = new ArrayList();
    
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

    
    public int getSum(String kode_ang) {
        int sum=0;
        connect();
        try{
            String query = "select count(kode_simpan) from simpanan where kode_ang=";
            query  += "'" + kode_ang + "'";
            rs = stmt.executeQuery(query);
            rs.next();
            sum = rs.getInt(1) + 1;
            return sum;
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return sum;
    
    }

    public void SimpananUang(Simpanan simpan) {
        connect();
        try{
            String query = "insert into simpanan values(";
            query += "'" + simpan.getKode_simpan() + "',";
            query += "'" + simpan.getKode_ang() + "',";
            query += "'" + simpan.getJum_simpanan() + "',";
            query +="STR_TO_DATE('" + simpan.getTgl_simpan() + "', '%Y-%m-%d'))";
            if(manipulate(query)) simpanan.add(simpan);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void getSimpananUser(String kode_ang) {
        connect();
        try {
            String query ="select tgl_simpan, jum_simpan from simpanan where kode_ang= ";
            query += "'"+kode_ang+"'";
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                simpanan.add(new Simpanan(
                    rs.getDouble("jum_simpan"),
                    rs.getString("kode_ang"),
                    rs.getString("kode_simpan"),
                    rs.getString("tgl_simpan")
                ));
            }
            rs.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void getAllSimpanan() {
        connect();
        try{
            String query = "select * from penarikan";
            rs = stmt.executeQuery(query);
            while(rs.next()){
                simpanan.add(new Simpanan(
                        rs.getDouble("jum_simpan"),
                        rs.getString("kode_ang"),
                        rs.getString("kode_simpan"),
                        rs.getString("tgl_simpan")
                ));
            }
            rs.close();
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
    
    public ArrayList<Simpanan> getSimpanan() {
    return simpanan;
    }

    public void setSimpanan(ArrayList<Simpanan> simpanan) {
        this.simpanan = simpanan;
    }

    public void getAllSimpanan(boolean b) {
        connect();
        try{
            String query = "select * from simpanan where status_acc";
            if(!b) query += "!";
            query += "='menunggu'";
            rs = stmt.executeQuery(query);
            while(rs.next()){
                simpanan.add(new Simpanan(
                        rs.getDouble("jum_simpan"),
                        rs.getString("kode_ang"),
                        rs.getString("kode_simpan"),
                        rs.getString("tgl_simpan")
                ));
            }
            rs.close();
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
    
}
