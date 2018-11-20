package Model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ASUS
 */
public class Pinjaman {
    private String kode_pinjam;
    private String kode_ang;
    private int jum_pinjam;
    private String tgl_pinjam;
    private String ket_pinjam;
    private String status_acc;
    private String ket_lunas;
    private String tgl_lunas;

    public Pinjaman(String kode_pinjam, String kode_ang, int jum_pinjam, String tgl_pinjam, String ket_pinjam) {
        this.kode_pinjam = kode_pinjam;
        this.kode_ang = kode_ang;
        this.jum_pinjam = jum_pinjam;
        this.tgl_pinjam = tgl_pinjam;
        this.ket_pinjam = ket_pinjam;
        this.status_acc = "Menunggu";
        this.ket_lunas = "";
        this.tgl_lunas = "";
    }

    public Pinjaman(String kode_pinjam, String kode_ang, int jum_pinjam, String tgl_pinjam, String ket_pinjam, String status_acc, String ket_lunas, String tgl_lunas) {
        this.kode_pinjam = kode_pinjam;
        this.kode_ang = kode_ang;
        this.jum_pinjam = jum_pinjam;
        this.tgl_pinjam = tgl_pinjam;
        this.ket_pinjam = ket_pinjam;
        this.status_acc = status_acc;
        this.ket_lunas = ket_lunas;
        this.tgl_lunas = tgl_lunas;
    }

    
    
    

    public String getKode_pinjam() {
        return kode_pinjam;
    }

    public void setKode_pinjam(String kode_pinjam) {
        this.kode_pinjam = kode_pinjam;
    }

    public String getKode_ang() {
        return kode_ang;
    }

    public void setKode_ang(String kode_ang) {
        this.kode_ang = kode_ang;
    }

    public int getJum_pinjam() {
        return jum_pinjam;
    }

    public void setJum_pinjam(int jum_pinjam) {
        this.jum_pinjam = jum_pinjam;
    }

    public String getTgl_pinjam() {
        return tgl_pinjam;
    }

    public void setTgl_pinjam(String tgl_pinjam) {
        this.tgl_pinjam = tgl_pinjam;
    }

    public String getKet_pinjam() {
        return ket_pinjam;
    }

    public void setKet_pinjam(String ket_pinjam) {
        this.ket_pinjam = ket_pinjam;
    }

    public String getStatus_acc() {
        return status_acc;
    }

    public void setStatus_acc(String status_acc) {
        this.status_acc = status_acc;
    }

    public String getKet_lunas() {
        return ket_lunas;
    }

    public void setKet_lunas(String ket_lunas) {
        this.ket_lunas = ket_lunas;
    }

    public String getTgl_lunas() {
        return tgl_lunas;
    }

    public void setTgl_lunas(String tgl_lunas) {
        this.tgl_lunas = tgl_lunas;
    }
    
    
}
