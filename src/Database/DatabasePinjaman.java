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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Kilam
 */
public class DatabasePinjaman extends Mysql_DatabaseConnection{
    private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    private ResultSet rs = null;
    private ArrayList<Pinjaman> pinjaman = new ArrayList();

    public boolean reqPinjam(Pinjaman pjm){
        boolean value=false;
        connect();
        try{
            System.out.println("masuk db");
            String query = "insert into pinjaman values (";
            query +="'" + pjm.getKode_pinjam()+ "',";
            query +="'" + pjm.getKode_ang()+ "',";
            query +="'" + pjm.getJum_pinjam()+ "',";
            query +="STR_TO_DATE('"+pjm.getTgl_pinjam()+"', '%Y-%m-%d ')"+",";
            query +="'" + pjm.getKet_pinjam()+ "',";
            query +="'" + pjm.getStatus_acc()+ "',";
            query +="'" + pjm.getKet_lunas()+ "',";
            query +=null+")";
            value=manipulate(query);
            disconnect();
            return value;
        } catch (Exception e){
            System.out.println(e);
        }
        disconnect();
        return value;
    }
    
    public int getSumAll(){
        int sum=0;
        connect();
        try{
            System.out.println("masuk db count");
            String query = "select count(kode_pinjam) from pinjaman";
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
    
    public void getAllPinjaman(boolean cek){
        connect();
        try{
            String query = "select * from pinjaman where status_acc";
            if(!cek) query += "!";
            query += "='menunggu'";
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
            disconnect();
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
    
    public void getAllPinjaman(String kode){
        connect();
        try{
            String query = "select * from pinjaman where kode_ang";
            query += "='"+ kode +"'";
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
            disconnect();
            rs.close();
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
    
    public boolean ubahStatusPinjaman(String kode_pinjam, String status){
        connect();
        try{
            String query = "update pinjaman set status_acc=";
            query += "'" + status + "'";
            if(status.equals("diterima")) query += ",ket_lunas = 'belum lunas'";
            query += "where kode_pinjam=";
            query += "'" + kode_pinjam + "'";
            if(manipulate(query)) {
                removePinjaman(kode_pinjam);
                disconnect();
                return true;
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        disconnect();
        return false;
    }
    
    public Pinjaman cariPinjaman(String kode_ang){
        connect();
        try{
            String query = "select * from pinjaman where kode_ang=";
            query += "'" + kode_ang + "' and";
            query += "ket_lunas = 'belum lunas'";
            rs = stmt.executeQuery(query);
            while(rs.next()){
                Pinjaman p = new Pinjaman(
                        rs.getString("kode_pinjam"),
                        rs.getString("kode_ang"),
                        Integer.valueOf(rs.getString("jum_pinjam")),
                        rs.getString("tgl_pinjam"),
                        rs.getString("ket_pinjam"),
                        rs.getString("status_acc"),
                        rs.getString("ket_lunas"),
                        rs.getString("tgl_lunas"));
                return p;
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    } 
    
    public boolean setLunas(String kode_ang){
        connect();
        try{
            String query = "update pinjaman set ket_lunas = 'lunas',";
            query += "tgl_lunas='" +  format.format(new Date()) + "'";
            query += "where kode_ang=";
            query += "'" + kode_ang + "'";
            query += "and ket_lunas = 'belum lunas'";
            if (manipulate(query)){
                disconnect();
                return true;
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        disconnect();
        return false;
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
