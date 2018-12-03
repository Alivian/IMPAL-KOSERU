/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Database.DatabasePinjaman;
import Database.DatabaseSimpanan;
import Model.Simpanan;
import View.Admin_LihatSimpanan;
import View.User_LihatSimpanan;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Oliver
 */
public class ControllerUserLihatSimpanan implements ActionListener{
    private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    private User_LihatSimpanan viewLihatSimpanan;
    private DatabaseSimpanan dbSimpanan;
    
    public ControllerUserLihatSimpanan(String kode_ang) {
        viewLihatSimpanan = new User_LihatSimpanan();
        viewLihatSimpanan.setLocationRelativeTo(null);
        viewLihatSimpanan.setVisible(true);
        dbSimpanan = new DatabaseSimpanan();
        dbSimpanan.getAllSimpanan(kode_ang);
        loadTable();
    }
    
    public void loadTable(){
        DefaultTableModel model = new DefaultTableModel(new String[]{
            "Tanggal Simpan","Jumlah Uang"}, 0);
        ArrayList<Simpanan> simpanan = dbSimpanan.getSimpanan();
        for (Simpanan p : simpanan) {
            model.addRow(new Object[]{
                p.getTgl_simpan(),
                p.getJum_simpanan()
            });
        }
        viewLihatSimpanan.setU_tbSimpan(model);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        viewLihatSimpanan.dispose();
    }
    
}
