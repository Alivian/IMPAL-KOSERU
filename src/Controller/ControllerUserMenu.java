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
public class ControllerUserMenu implements ActionListener{
    private User_MenuUser vUser;
    private Person newP;
    private int totSaldo=0;
    private boolean ablePinjam;
    private DefaultTableModel tabPinjam;
    private DefaultTableModel tabPelunasan;
    private DefaultTableModel tabSimpan;
    private DefaultTableModel tabPenarikan;
    public ControllerUserMenu(Person p) {
        this.newP=p;
        this.vUser=new User_MenuUser();
        this.ablePinjam = true;
        this.vUser.addListenerMUser(this);
        this.vUser.getU_txEmail().setText(p.getEmail());
        this.vUser.getU_txKd_Anggota().setText(p.getKode_angg());
        this.vUser.getU_txNama().setText(p.getNama());
        this.vUser.getU_txAlamat().setText(p.getAlamat());
        this.vUser.getU_txProfesi().setText(p.getProfesi());
        if(p.getJk()=='L'){
            this.vUser.getU_txJk().setText("Laki-laki");
        }else{
            this.vUser.getU_txJk().setText("Perempuan");
        }
        this.vUser.getU_txTTL().setText(p.getTmplahir()+", "+p.getTgllahir());
        this.tabPinjam = (DefaultTableModel) vUser.getU_tblPinjam().getModel();
        this.tabPelunasan = (DefaultTableModel) vUser.getU_tbPelunasan().getModel();
        this.tabSimpan = (DefaultTableModel) vUser.getU_tbSimpan().getModel();
        this.tabPenarikan = (DefaultTableModel) vUser.getU_tbPenarikan().getModel();
        for (Pinjaman pjm: this.newP.getPinjam()){
            tabPinjam.addRow(new Object[]{pjm.getTgl_pinjam(),pjm.getKet_pinjam(),pjm.getJum_pinjam(), pjm.getStatus_acc(),pjm.getKet_lunas()});
            if(pjm.getKet_lunas().equals("lunas")){
                tabPelunasan.addRow(new Object[]{pjm.getTgl_lunas(),pjm.getJum_pinjam()});
            }else if(pjm.getStatus_acc().equals("Menunggu")||pjm.getKet_lunas().equals("belum lunas")){
                this.ablePinjam=false;
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



        @Override
        public void actionPerformed(ActionEvent e) {
            Object x=e.getSource();
            if(x.equals(vUser.getU_btnReqPinjam())){
                if(ablePinjam==true){
                   new ControllerReqPinjaman(newP,this,ablePinjam);
                }
                else{
                    JOptionPane.showMessageDialog(vUser,"Tidak bisa melakukan request","GAGAL",JOptionPane.ERROR_MESSAGE);
                }
            }
            else if(x.equals(vUser.getU_btnCekSaldo())){
                JOptionPane.showMessageDialog(vUser,"Jumlah saldo saat ini : Rp"+totSaldo,"SALDO",JOptionPane.INFORMATION_MESSAGE);
            }
            else if(x.equals(vUser.getU_btnEdit())){
                new ControllerEditProfile(newP,vUser);
            }
            else if(x.equals(vUser.getU_btnLogout())){
                vUser.dispose();
                new ControllerLogin();
            }
        }


    public void setAblePinjam(boolean ablePinjam) {
        this.ablePinjam = ablePinjam;
    }

    public DefaultTableModel getTabPinjam() {
        return tabPinjam;
    }
    
}
