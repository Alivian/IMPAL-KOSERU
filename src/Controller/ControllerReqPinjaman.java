/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Database.DatabasePinjaman;
import Model.Person;
import Model.Pinjaman;
import View.User_MenuUser;
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
public class ControllerReqPinjaman implements ActionListener{
    private User_ReqPinjam vReqPinjam;
    private final DatabasePinjaman dbPinjam= new DatabasePinjaman();
    private Pinjaman pinjam;
    private Person p;
    private ControllerUserMenu cUser;
    private boolean ablePinjam;
    public ControllerReqPinjaman(Person p, ControllerUserMenu cUser,boolean ablePinjam) {
        this.p=p;
        this.cUser=cUser;
        this.ablePinjam=ablePinjam;
        this.vReqPinjam=new User_ReqPinjam();
        this.vReqPinjam.addListener(this);
        this.vReqPinjam.setVisible(true);
    }
    
    private void btnOptionDialogActionPerformed(java.awt.event.ActionEvent evt) {

    int jawab = JOptionPane.showConfirmDialog(null, 
                    "Apakah Semua data sudah sesuai?", 
                    "Konfirmasi", 
                    JOptionPane.YES_NO_OPTION, 
                    JOptionPane.QUESTION_MESSAGE);
    
    if(jawab == JOptionPane.YES_OPTION){
        Pinjaman pd=new Pinjaman("PJM"+String.valueOf(dbPinjam.getSumAll()), p.getKode_angg(), Integer.parseInt(vReqPinjam.getU_txJumPinjam().getText()), 
                vReqPinjam.getU_txDatePinjam().getText(), vReqPinjam.getU_txKetPinjam().getText());
        if(dbPinjam.reqPinjam(pd)==true){
            JOptionPane.showMessageDialog(vReqPinjam, "Reqeust berhasil dikirim","BERHASIL",JOptionPane.INFORMATION_MESSAGE);
            cUser.setAblePinjam(false);
            cUser.getTabPinjam().addRow(new Object[]{pd.getTgl_pinjam(),pd.getKet_pinjam(),pd.getJum_pinjam(), pd.getStatus_acc(),pd.getKet_lunas()});
            vReqPinjam.dispose();
        }else{
            JOptionPane.showMessageDialog(vReqPinjam, "Gagal","GAGAL",JOptionPane.ERROR_MESSAGE);
        } 
    }  
}



        @Override
        public void actionPerformed(ActionEvent e) {
            Object x = e.getSource();
            if(x.equals(vReqPinjam.getU_ReqbtnReset())){
                vReqPinjam.getU_txJumPinjam().setText("");
                vReqPinjam.getU_txKetPinjam().setText("");
            }else if(x.equals(vReqPinjam.getU_ReqbtnCancel())){
                vReqPinjam.dispose();
            }else if(x.equals(vReqPinjam.getU_ReqbtnOK())){
                if(vReqPinjam.getU_txJumPinjam().getText().length()==0||vReqPinjam.getU_txKetPinjam().getText().length()==0){
                    JOptionPane.showMessageDialog(vReqPinjam, "Isi semua data dengan benar","GAGAL",JOptionPane.ERROR_MESSAGE);
                }else{
                    try{
                        int jumlah = Integer.parseInt(vReqPinjam.getU_txJumPinjam().getText());
                        
                        btnOptionDialogActionPerformed(e);
                    }catch(Exception ex){
                        JOptionPane.showMessageDialog(vReqPinjam, "Jumlah Pinjaman harus dalam angka","GAGAL",JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        }



}
