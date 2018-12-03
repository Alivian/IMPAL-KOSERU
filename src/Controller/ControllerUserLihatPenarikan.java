/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Database.DatabasePenarikan;
import Model.Penarikan;
import View.User_LihatPenarikan;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Kilam
 */
public class ControllerUserLihatPenarikan implements ActionListener{
    private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    private User_LihatPenarikan viewLihatPenarikan;
    private DatabasePenarikan dbPenarikan;
    public ControllerUserLihatPenarikan(String kode_ang) {
        viewLihatPenarikan = new User_LihatPenarikan();
        viewLihatPenarikan.setLocationRelativeTo(null);
        viewLihatPenarikan.setVisible(true);
        dbPenarikan = new DatabasePenarikan();
        dbPenarikan.getPenarikanUser(kode_ang);
        loadTable();
    }
    
    public void loadTable(){
        DefaultTableModel model = new DefaultTableModel(new String[]{
            "Tanggal Penarikan", "Jumlah Uang"}, 0);
        
        ArrayList<Penarikan> penarikan = dbPenarikan.getPenarikan();
        for (Penarikan p : penarikan) {
            model.addRow(new Object[]{p.getTgl_penarikan(), p.getJum_penarikan()});
        }
        viewLihatPenarikan.setU_tbPenarikan(model);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object x=e.getSource();
        if(x==viewLihatPenarikan.getBtnKembali()){
            viewLihatPenarikan.dispose();
        }
    }
    
}
