/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Database.DatabasePinjaman;
import Model.Pinjaman;
import View.User_LihatPinjaman;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Kilam
 */
public class ControllerUserLihatPinjaman implements ActionListener{
    private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    private User_LihatPinjaman viewLihatPinjaman;
    private DatabasePinjaman dbPinjaman;
    private boolean ablePinjam;
    private ControllerUserMenu cUser;
    public ControllerUserLihatPinjaman(String kode_ang, ControllerUserMenu cUser) {
        this.cUser=cUser;
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
            if(p.getKet_lunas().equals("lunas")){
                model2.addRow(new Object[]{p.getTgl_lunas(),p.getJum_pinjam()});
            }else if(p.getStatus_acc().equals("Menunggu")||p.getKet_lunas().equals("belum lunas")){
                cUser.setAblePinjam(false);
            }
        }
        viewLihatPinjaman.setU_tbPelunasan(model2);
        viewLihatPinjaman.setU_tblPinjam(model);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object x=e.getSource();
        if(x==viewLihatPinjaman.getBtnKembali()){
            viewLihatPinjaman.dispose();
        }
    }
}
