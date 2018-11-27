/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import View.User_ReqPinjam;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 *
 * @author ASUS
 */
public class ControllerReqPinjaman {
    private User_ReqPinjam vReqPinjam;

    public ControllerReqPinjaman() {
        this.vReqPinjam=new User_ReqPinjam();
        this.vReqPinjam.addListener(new RegPinjamListener());
        this.vReqPinjam.setVisible(true);
    }

    class RegPinjamListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Object x = e.getSource();
            if(x.equals(vReqPinjam.getBanyakCicilan())){
                String valuee = vReqPinjam.getBanyakCicilan().getSelectedItem().toString();
                vReqPinjam.getU_txTagihan().setText(Integer.toString(Integer.parseInt(vReqPinjam.getU_txJumPinjam().getText())/Integer.parseInt(valuee)));
            }
        }
    }


}
