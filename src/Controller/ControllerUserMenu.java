/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Person;
import View.User_MenuUser;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author ASUS
 */
public class ControllerUserMenu {
    private User_MenuUser vUser;
    public ControllerUserMenu(Person p) {
        this.vUser=new User_MenuUser();
        this.vUser.addListenerMUser(new UserMenuListener());
        this.vUser.getU_txEmail().setText(p.getEmail());
        this.vUser.getU_txKd_Anggota().setText(p.getKode_angg());
        this.vUser.getU_txNama().setText(p.getNama());
        this.vUser.getU_txNoTelp().setText(p.getNo_telp());
        this.vUser.getU_txProfesi().setText(p.getProfesi());
        this.vUser.getU_txTTL().setText(p.getTmplahir()+", "+p.getTgllahir());
        this.vUser.setVisible(true);
    }

    class UserMenuListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            
        }
    }
    
}
