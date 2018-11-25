/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import View.Admin_MenuAdmin;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Kilam
 */
public class ControllerMenuAdmin implements ActionListener{
    private Admin_MenuAdmin viewMenuAdmin;

    public ControllerMenuAdmin() {
        viewMenuAdmin = new Admin_MenuAdmin();
        viewMenuAdmin.setLocationRelativeTo(null);
        viewMenuAdmin.addActionListener(this);
        viewMenuAdmin.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if (source.equals(viewMenuAdmin.getBtnInputSimpan())){
            new ControllerSimpanan();
        }else if (source.equals(viewMenuAdmin.getBtnInputPenarikan())){
            new ControllerInputPenarikan();
        }else if (source.equals(viewMenuAdmin.getBtnInputBayar())){
        }else if (source.equals(viewMenuAdmin.getBtnLihatSimpan())){
        }else if (source.equals(viewMenuAdmin.getBtnLihatPenarikan())){
            new ControllerLihatPenarikan();
        }else if (source.equals(viewMenuAdmin.getBtnLihatPinjam())){
            new ControllerLihatPinjaman();
        }else if (source.equals(viewMenuAdmin.getBtnTerimaPinjaman())){
            new ControllerTerimaPinjaman();
        }else if (source.equals(viewMenuAdmin.getBtnLogout())){
            new ControllerLogin();
            viewMenuAdmin.dispose();
        }
    }
    
}
