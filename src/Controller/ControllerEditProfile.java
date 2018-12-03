/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Database.DatabaseUser;
import Model.Person;
import View.User_EditProfile;
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
    public ControllerEditProfile(Person p) {
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
        this.vEdit.getE_txTlp().setText(p.getNo_telp());
        this.vEdit.getE_cbJK().setSelectedIndex(0);
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
                        vEdit.getE_txProf().getText().length()==0||vEdit.getE_txTlp().getText().length()==0||
                        vEdit.getE_Kalen().getText().length()==0||vEdit.getE_txTempat().getText().length()==0||
                        vEdit.getE_cbJK().getSelectedIndex()==0){
                    JOptionPane.showMessageDialog(vEdit, "Semua Data Harus Terisi","PERHATIAN",JOptionPane.INFORMATION_MESSAGE);
                }else {
                    updateP.setNama(vEdit.getE_txNama().getText());
                    updateP.setEmail(vEdit.getE_txEmail().getText());
                    updateP.setNo_telp(vEdit.getE_txTlp().getText());
                    updateP.setProfesi(vEdit.getE_txProf().getText());
                    System.out.println(Date.valueOf(vEdit.getE_Kalen().getText()));
                    updateP.setTglL(Date.valueOf(vEdit.getE_Kalen().getText()));
                    System.out.println(updateP.getTgllahir().toString());
                    updateP.setTmpL(vEdit.getE_txTempat().getText());
                    if(dbUser.update(updateP)==true){
                        JOptionPane.showMessageDialog(vEdit, "Data anggota telah terupdate","BERHASIL",JOptionPane.INFORMATION_MESSAGE);
                    }else{
                        JOptionPane.showMessageDialog(vEdit, "Kesalahan, hubungi pegawai","GAGAL",JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        }
    }
}
