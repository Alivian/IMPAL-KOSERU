/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Oliver Queen
 */
public class Simpanan {
    private double jum_simpanan;
    private String kode_ang;
    private String kode_simpan;
    private String tgl_simpan;

    public Simpanan(double jum_simpanan, String kode_ang, String kode_simpan, String tgl_simpan) {
        this.jum_simpanan = jum_simpanan;
        this.kode_ang = kode_ang;
        this.kode_simpan = kode_simpan;
        this.tgl_simpan = tgl_simpan;
    }

    public void setJum_simpanan(double jum_simpanan) {
        this.jum_simpanan = jum_simpanan;
    }

    public void setKode_ang(String kode_ang) {
        this.kode_ang = kode_ang;
    }

    public void setKode_simpan(String kode_simpan) {
        this.kode_simpan = kode_simpan;
    }

    public void setTgl_simpan(String tgl_simpan) {
        this.tgl_simpan = tgl_simpan;
    }

    public double getJum_simpanan() {
        return jum_simpanan;
    }

    public String getKode_ang() {
        return kode_ang;
    }

    public String getKode_simpan() {
        return kode_simpan;
    }

    public String getTgl_simpan() {
        return tgl_simpan;
    }
    
    
    
}

