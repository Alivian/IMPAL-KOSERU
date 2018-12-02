package Model;


import java.util.*;
import sun.security.util.Password;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ASUS
 */
public class Person extends User {
    private String nama;
    private String status;
    private String tmplahir;
    private String tgllahir;
    private String kode_angg;
    private String no_telp;
    private String profesi;
    private String email;
    private List<Pinjaman> pinjam= new ArrayList();
    private List<Simpanan> simpan= new ArrayList();

    
    public Person(String kode_anggota, 
            String nama, String profesi, String ttl, String tgll, String email, String status, String notlp,
            String username, String pass, 
            List<Pinjaman> pinjam, List<Simpanan> simpan){
        super(username, pass);
        this.nama = nama;
        this.tmplahir = ttl;
        this.tgllahir = tgll;
        this.profesi = profesi;
        this.email = email;
        this.kode_angg =kode_anggota;
        this.status=status;
        this.no_telp=notlp;
        this.pinjam = pinjam;
        this.simpan = simpan;
    }
    
    public void setPinjam(Pinjaman pinjam) {
        this.pinjam.add(pinjam);
    }

    public List<Pinjaman> getPinjam() {
        return pinjam;
    }
    
    public List<Simpanan> getSimpan() {
        return simpan;
    }

    public void setSimpan(Simpanan simpann) {
        this.simpan.add(simpann);
    }

    public void setNo_telp(String no_telp) {
        this.no_telp = no_telp;
    }
    
    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }



    public void setTmpL(String ttl) {
        this.tmplahir = ttl;
    }
    
    
    public void setTglL(String tgl){
        this.tgllahir=tgl;
    }
    
    public String getKode_angg() {
        return kode_angg;
    }
    
    public void setKode_angg(String kode_angg) {
        this.kode_angg = kode_angg;
    }

    public String getProfesi() {
        return profesi;
    }

    public void setProfesi(String profesi) {
        this.profesi = profesi;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStatus() {
        return status;
    }

    public String getTmplahir() {
        return tmplahir;
    }

    public String getTgllahir() {
        return tgllahir;
    }

    public String getNo_telp() {
        return no_telp;
    }

    
    @Override
    public String getPassword() {
        return pass;
    }

    @Override
    public String getUsername() {
        return username;
    }
}
