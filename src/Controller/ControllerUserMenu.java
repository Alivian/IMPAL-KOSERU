/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Person;
import Model.Pinjaman;
import Model.Simpanan;
import View.User_MenuUser;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ASUS
 */
public class ControllerUserMenu {
    private User_MenuUser vUser;
    private Person newP;
    DefaultTableModel tabPijam;
    DefaultTableModel tabPelunasan;
    DefaultTableModel tabSimpan;
    DefaultTableModel mdltrk;
    public ControllerUserMenu(Person p) {
        this.newP=p;
        this.vUser=new User_MenuUser();
        this.vUser.addListenerMUser(new UserMenuListener());
        this.vUser.getU_txEmail().setText(p.getEmail());
        this.vUser.getU_txKd_Anggota().setText(p.getKode_angg());
        this.vUser.getU_txNama().setText(p.getNama());
        this.vUser.getU_txNoTelp().setText(p.getNo_telp());
        this.vUser.getU_txProfesi().setText(p.getProfesi());
        this.vUser.getU_txTTL().setText(p.getTmplahir()+", "+p.getTgllahir());
        this.tabPijam = (DefaultTableModel) vUser.getU_tblPinjam().getModel();
        this.tabPelunasan = (DefaultTableModel) vUser.getU_tbPelunasan().getModel();
        this.tabSimpan = (DefaultTableModel) vUser.getU_tbSimpan().getModel();
        for (Pinjaman pjm: this.newP.getPinjam()){
            tabPijam.addRow(new Object[]{pjm.getTgl_pinjam(),pjm.getKet_pinjam(),pjm.getJum_pinjam(), pjm.getStatus_acc(),pjm.getKet_lunas()});
            if(pjm.getKet_lunas().equals("lunas")){
                tabPelunasan.addRow(new Object[]{pjm.getTgl_lunas(),pjm.getJum_pinjam()});
            }
        }
        for (Simpanan s : this.newP.getSimpan()){
            tabSimpan.addRow(new Object[]{s.getTgl_simpan(),s.getJum_simpanan()});
        }
        this.vUser.setVisible(true);
    }

    class UserMenuListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Object x=e.getSource();
            if(x.equals(vUser.getU_btnReqPinjam())){
                new ControllerReqPinjaman(newP);
            }
        }
    }
    
}
