/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Database.DatabasePenarikan;
import Model.Penarikan;
import View.Admin_LihatPenarikan;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Kilam
 */
public class ControllerLihatPenarikan {
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    private Admin_LihatPenarikan viewLihatPenarikan;
    private DatabasePenarikan dbPenarikan;

    public ControllerLihatPenarikan() {
        viewLihatPenarikan = new Admin_LihatPenarikan();
        viewLihatPenarikan.setLocationRelativeTo(null);
        viewLihatPenarikan.setVisible(true);
        dbPenarikan = new DatabasePenarikan();
        dbPenarikan.getAllPenarikan();
        loadTable();
    }
    
    public void loadTable(){
        DefaultTableModel model = new DefaultTableModel(new String[]{
            "ID Anggota", "Nama", "Kode Penarikan", "Tanggal Penarikan", "Jumlah Penarikan"}, 0);
        ArrayList<Penarikan> penarikan = dbPenarikan.getPenarikan();
        for (Penarikan p : penarikan) {
            model.addRow(new Object[]{p.getKode_ang(), dbPenarikan.cekAnggota(p.getKode_ang()), p.getKode_penarikan(), p.getTgl_penarikan(), p.getJum_penarikan()});
        }
        viewLihatPenarikan.setTbPenarikan(model);
    }
    
}
