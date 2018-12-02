/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Database.DatabasePinjaman;
import Model.Person;
import Model.Pinjaman;
import View.User_ReqPinjam;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author ASUS
 */
public class ControllerReqPinjaman {
    private User_ReqPinjam vReqPinjam;
    private final DatabasePinjaman dbPinjam= new DatabasePinjaman();
    private Pinjaman pinjam;
    private Person p;
    DefaultTableModel tabPinjam;
    public ControllerReqPinjaman(Person p, DefaultTableModel tabPinjam) {
        this.p=p;
        this.tabPinjam=tabPinjam;
        this.vReqPinjam=new User_ReqPinjam();
        this.vReqPinjam.addListener(new RegPinjamListener());
        this.vReqPinjam.addFocusListener(new RegPinjamFListener());
        this.vReqPinjam.setVisible(true);
    }
    
    private void btnOptionDialogActionPerformed(java.awt.event.ActionEvent evt) {

    int jawab = JOptionPane.showConfirmDialog(null, 
                    "Apakah Semua data sudah sesuai?", 
                    "Konfirmasi", 
                    JOptionPane.YES_NO_OPTION, 
                    JOptionPane.QUESTION_MESSAGE);
    
    if(jawab == JOptionPane.YES_OPTION){
        Pinjaman pd=new Pinjaman("PJM"+String.valueOf(dbPinjam.getSumAll()), p.getKode_angg(), Integer.parseInt(vReqPinjam.getU_txJumPinjam().getText()), vReqPinjam.getU_txDatePinjam().getText(), vReqPinjam.getU_txKetPinjam().getText());
        if(dbPinjam.reqPinjam(pd)==true){
            JOptionPane.showMessageDialog(vReqPinjam, "Reqeust berhasil dikirim","BERHASIL",JOptionPane.INFORMATION_MESSAGE);
            tabPinjam.addRow(new Object[]{pd.getTgl_pinjam(),pd.getKet_pinjam(),pd.getJum_pinjam(), pd.getStatus_acc(),pd.getKet_lunas()});
            vReqPinjam.dispose();
        }else{
            JOptionPane.showMessageDialog(vReqPinjam, "Gagal","GAGAL",JOptionPane.ERROR_MESSAGE);
        } 
    }  
}

    class RegPinjamFListener implements FocusListener {

        public RegPinjamFListener() {
        }

        @Override
        public void focusGained(FocusEvent e) {
            
        }

        @Override
        public void focusLost(FocusEvent e) {
            Object x = e.getSource();
            if(x==vReqPinjam.getU_txJumPinjam()){
                vReqPinjam.getU_txTagihan().setText("");
                vReqPinjam.getBanyakCicilan().setSelectedIndex(0);
            }
        }
    }

    class RegPinjamListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Object x = e.getSource();
            if(x.equals(vReqPinjam.getBanyakCicilan())){
                System.out.println();
                if(vReqPinjam.getU_txJumPinjam().getText().length()==0){
                    JOptionPane.showMessageDialog(vReqPinjam, "Isi jumlah uang pinjaman","GAGAL",JOptionPane.ERROR_MESSAGE);
                }else if(vReqPinjam.getBanyakCicilan().getSelectedIndex()!=0) {
                    String valuee = vReqPinjam.getBanyakCicilan().getSelectedItem().toString();
                    vReqPinjam.getU_txTagihan().setText(Double.toString(Math.ceil(Double.parseDouble(vReqPinjam.getU_txJumPinjam().getText())/Double.parseDouble(valuee))));
                }
            }else if(x.equals(vReqPinjam.getU_ReqbtnReset())){
                vReqPinjam.getU_txJumPinjam().setText("");
                vReqPinjam.getU_txKetPinjam().setText("");
                vReqPinjam.getU_txTagihan().setText("");
                vReqPinjam.getBanyakCicilan().setSelectedIndex(0);
            }else if(x.equals(vReqPinjam.getU_ReqbtnCancel())){
                vReqPinjam.dispose();
            }else if(x.equals(vReqPinjam.getU_ReqbtnOK())){
                if(vReqPinjam.getU_txJumPinjam().getText().length()==0||vReqPinjam.getU_txKetPinjam().getText().length()==0||vReqPinjam.getU_txTagihan().getText().length()==0){
                    JOptionPane.showMessageDialog(vReqPinjam, "Isi semua data dengan benar","GAGAL",JOptionPane.ERROR_MESSAGE);
                }else{
                    btnOptionDialogActionPerformed(e);
                }
            }
        }
    }


}
