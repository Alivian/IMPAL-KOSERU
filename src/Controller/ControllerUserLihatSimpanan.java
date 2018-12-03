/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Database.DatabasePinjaman;
import Database.DatabaseSimpanan;
import Model.Pinjaman;
import Model.Simpanan;
import View.Admin_LihatPinjaman;
import View.Admin_LihatSimpanan;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Oliver
 */
public class ControllerUserLihatSimpanan {
    private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    private Admin_LihatSimpanan viewLihatSimpanan;
    private DatabaseSimpanan dbSimpanan;
    
    public ControllerUserLihatSimpanan() {
        viewLihatSimpanan = new Admin_LihatSimpanan();
        viewLihatSimpanan.setLocationRelativeTo(null);
        viewLihatSimpanan.setVisible(true);
        dbSimpanan = new DatabaseSimpanan();
        dbSimpanan.getAllSimpanan();
        loadTable();
    }
    
    public void loadTable(){
        DefaultTableModel model = new DefaultTableModel(new String[]{
            "Kode Anggota", "Nama", "Tanggal Simpan","Jumlah Simpanan"}, 0);
        ArrayList<Simpanan> simpanan = dbSimpanan.getSimpanan();
        for (Simpanan p : simpanan) {
            model.addRow(new Object[]{
                p.getKode_ang(),
                dbSimpanan.cekAnggota(p.getKode_ang()),
                p.getTgl_simpan(),
                p.getJum_simpanan(),
                p.getKode_simpan()
            });
        }
        viewLihatSimpanan.setA_tbLihatSimpanan(model);
    }
    
}
