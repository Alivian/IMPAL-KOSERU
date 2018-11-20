/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Database.DatabasePinjaman;
import Model.Pinjaman;
import View.Admin_LihatPinjaman;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Kilam
 */
public class ControllerLihatPinjaman {
    private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    private Admin_LihatPinjaman viewLihatPinjaman;
    private DatabasePinjaman dbPinjaman;

    public ControllerLihatPinjaman() {
        viewLihatPinjaman = new Admin_LihatPinjaman();
        viewLihatPinjaman.setLocationRelativeTo(null);
        viewLihatPinjaman.setVisible(true);
        dbPinjaman = new DatabasePinjaman();
        dbPinjaman.getAllPinjaman(false);
        loadTable();
    }
    
    public void loadTable(){
        DefaultTableModel model = new DefaultTableModel(new String[]{
            "Kode Anggota", "Nama", "Tanggal Pinjam", "Keterangan", "Jumlah Pinjam", "Status", "Pelunasan"}, 0);
        ArrayList<Pinjaman> pinjaman = dbPinjaman.getPinjaman();
        for (Pinjaman p : pinjaman) {
            model.addRow(new Object[]{
                p.getKode_ang(),
                dbPinjaman.cekAnggota(p.getKode_ang()),
                p.getTgl_pinjam(),
                p.getKet_pinjam(),
                p.getJum_pinjam(),
                p.getStatus_acc(),
                p.getKet_lunas()
            });
        }
        viewLihatPinjaman.setTbLihatPinjaman(model);
    }
}
