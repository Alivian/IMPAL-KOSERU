/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Kilam
 */
public class Penarikan {
    private double jum_penarikan;
    private String kode_ang;
    private String kode_penarikan;
    private String tgl_penarikan;

    public Penarikan(double jum_penarikan, String kode_ang, String kode_penarikan, String tgl_penarikan) {
        this.jum_penarikan = jum_penarikan;
        this.kode_ang = kode_ang;
        this.kode_penarikan = kode_penarikan;
        this.tgl_penarikan = tgl_penarikan;
    }

    public Penarikan() {}

    public double getJum_penarikan() {
        return jum_penarikan;
    }

    public void setJum_penarikan(double jum_penarikan) {
        this.jum_penarikan = jum_penarikan;
    }

    public String getKode_ang() {
        return kode_ang;
    }

    public void setKode_ang(String kode_ang) {
        this.kode_ang = kode_ang;
    }

    public String getKode_penarikan() {
        return kode_penarikan;
    }

    public void setKode_penarikan(String kode_penarikan) {
        this.kode_penarikan = kode_penarikan;
    }

    public String getTgl_penarikan() {
        return tgl_penarikan;
    }

    public void setTgl_penarikan(String tgl_penarikan) {
        this.tgl_penarikan = tgl_penarikan;
    }
    
    
}
