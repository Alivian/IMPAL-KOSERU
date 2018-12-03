/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Database.DatabaseUser;
import Model.Person;
import View.User_EditProfile;
import View.User_MenuUser;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.Calendar;
import javax.swing.JOptionPane;

/**
 *
 * @author ASUS
 */
public class ControllerEditProfile {
    private User_EditProfile vEdit;
    private DatabaseUser dbUser= new DatabaseUser();
    private Person updateP;
    private User_MenuUser vUser;
    public ControllerEditProfile(Person p, User_MenuUser vUser) {
        this.vUser=vUser;
        this.vEdit= new User_EditProfile();
        this.vEdit.addListener(new EditProfileListener());
        this.vEdit.getE_txNama().setText(p.getNama());
        this.vEdit.getE_txKode_ang().setText(p.getKode_angg());
        Calendar d= Calendar.getInstance();
        d.setTime(p.getTgllahir());
        this.vEdit.getE_Kalen().setSelectedDate(d);
        this.vEdit.getE_txTempat().setText(p.getTmplahir());
        this.vEdit.getE_txEmail().setText(p.getEmail());
        this.vEdit.getE_txProf().setText(p.getProfesi());
        this.vEdit.getE_txAlamat().setText(p.getAlamat());
        if(p.getJk()=='L')
            this.vEdit.getE_cbJK().setSelectedIndex(1);
        else
            this.vEdit.getE_cbJK().setSelectedIndex(2);
        this.updateP=p;
        this.vEdit.setVisible(true);
    }

    class EditProfileListener implements ActionListener {

        public EditProfileListener() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            Object source = e.getSource();
            if(source == vEdit.getE_btnConfirm()){
                if(vEdit.getE_txNama().getText().length()==0||vEdit.getE_txEmail().getText().length()==0||
                        vEdit.getE_txProf().getText().length()==0||vEdit.getE_txAlamat().getText().length()==0||
                        vEdit.getE_Kalen().getText().length()==0||vEdit.getE_txTempat().getText().length()==0||
                        vEdit.getE_cbJK().getSelectedIndex()==0||vEdit.getE_cbJK().getSelectedIndex()==0){
                    JOptionPane.showMessageDialog(vEdit, "Semua Data Harus Terisi","GAGAL",JOptionPane.ERROR_MESSAGE);
                }else {
                    updateP.setNama(vEdit.getE_txNama().getText());
                    updateP.setEmail(vEdit.getE_txEmail().getText());
                    updateP.setAlamat(vEdit.getE_txAlamat().getText());
                    updateP.setProfesi(vEdit.getE_txProf().getText());
                    updateP.setTglL(Date.valueOf(vEdit.getE_Kalen().getText()));
                    updateP.setTmpL(vEdit.getE_txTempat().getText());
                    if(vEdit.getE_cbJK().getSelectedIndex()==1){
                        updateP.setJk('L');
                    }else{
                        updateP.setJk('P');
                    }
                    if(dbUser.update(updateP)==true){
                        vUser.getU_txNama().setText(updateP.getNama());
                        vUser.getU_txEmail().setText(updateP.getEmail());
                        vUser.getU_txAlamat().setText(updateP.getAlamat());
                        vUser.getU_txProfesi().setText(updateP.getProfesi());
                        vUser.getU_txTTL().setText(updateP.getTmplahir()+", "+updateP.getTgllahir());
                        JOptionPane.showMessageDialog(vEdit, "Data anggota telah terupdate","BERHASIL",JOptionPane.INFORMATION_MESSAGE);
                        vEdit.dispose();
                    }else{
                        JOptionPane.showMessageDialog(vEdit, "Kesalahan, hubungi pegawai","GAGAL",JOptionPane.ERROR_MESSAGE);
                    }
                }
            }else if(source==vEdit.getBtnKembali()){
                vEdit.dispose();
            }
        }
    }
}
