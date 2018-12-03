/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Database.DatabasePinjaman;
import Model.Pinjaman;
import View.Admin_LihatPinjaman;
import View.User_LihatPinjaman;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Kilam
 */
public class ControllerUserLihatPinjaman {
    private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    private User_LihatPinjaman viewLihatPinjaman;
    private DatabasePinjaman dbPinjaman;

    public ControllerUserLihatPinjaman(String kode_ang) {
        viewLihatPinjaman = new User_LihatPinjaman();
        viewLihatPinjaman.setLocationRelativeTo(null);
        viewLihatPinjaman.setVisible(true);
        dbPinjaman = new DatabasePinjaman();
        dbPinjaman.getAllPinjaman(kode_ang);
        loadTable();
    }
    
    public void loadTable(){
        DefaultTableModel model = new DefaultTableModel(new String[]{
            "Tanggal Pinjam", "Keterangan", "Jumlah Pinjam", "Status", "Pelunasan"}, 0);
        DefaultTableModel model2 = new DefaultTableModel(new String[]{
            "Tanggal Pelunasan", "Jumlah Uang"}, 0);
        ArrayList<Pinjaman> pinjaman = dbPinjaman.getPinjaman();
        for (Pinjaman p : pinjaman) {
            model.addRow(new Object[]{
                p.getTgl_pinjam(),
                p.getKet_pinjam(),
                p.getJum_pinjam(),
                p.getStatus_acc(),
                p.getKet_lunas()
            });
        }
        viewLihatPinjaman.setTbLihatPinjaman(model);
        viewLihatPinjaman.setTbLihatPinjaman(model);
    }
}
