/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Penarikan;
import Model.Person;
import Model.Pinjaman;
import Model.Simpanan;
import View.User_MenuUser;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ASUS
 */
public class ControllerUserMenu {
    private User_MenuUser vUser;
    private Person newP;
    private int totSaldo=0;
    private DefaultTableModel tabPinjam;
    private DefaultTableModel tabPelunasan;
    private DefaultTableModel tabSimpan;
    private DefaultTableModel tabPenarikan;
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
        this.tabPinjam = (DefaultTableModel) vUser.getU_tblPinjam().getModel();
        this.tabPelunasan = (DefaultTableModel) vUser.getU_tbPelunasan().getModel();
        this.tabSimpan = (DefaultTableModel) vUser.getU_tbSimpan().getModel();
        this.tabPenarikan = (DefaultTableModel) vUser.getU_tbPenarikan().getModel();
        for (Pinjaman pjm: this.newP.getPinjam()){
            tabPinjam.addRow(new Object[]{pjm.getTgl_pinjam(),pjm.getKet_pinjam(),pjm.getJum_pinjam(), pjm.getStatus_acc(),pjm.getKet_lunas()});
            if(pjm.getKet_lunas().equals("lunas")){
                tabPelunasan.addRow(new Object[]{pjm.getTgl_lunas(),pjm.getJum_pinjam()});
            }
        }
        for (Simpanan s : this.newP.getSimpan()){
            this.totSaldo+=s.getJum_simpanan();
            tabSimpan.addRow(new Object[]{s.getTgl_simpan(),s.getJum_simpanan()});
        }
        for (Penarikan pn : this.newP.getTarik()){
            this.totSaldo-=pn.getJum_penarikan();
            tabPenarikan.addRow(new Object[]{pn.getTgl_penarikan(),pn.getJum_penarikan()});
        }
        this.vUser.setVisible(true);
    }

    class UserMenuListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Object x=e.getSource();
            if(x.equals(vUser.getU_btnReqPinjam())){
                new ControllerReqPinjaman(newP,tabPinjam);
            }
            else if(x.equals(vUser.getU_btnCekSaldo())){
                JOptionPane.showMessageDialog(vUser,"Jumlah saldo saat ini : Rp"+totSaldo,"SALDO",JOptionPane.INFORMATION_MESSAGE);
            }
            else if(x.equals(vUser.getU_btnEdit())){
                new ControllerEditProfile(newP);
            }
            else if(x.equals(vUser.getU_btnLogout())){
                vUser.dispose();
                new ControllerLogin();
            }
        }
    }
    
}
