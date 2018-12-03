/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Database.DatabasePenarikan;
import Model.Penarikan;
import View.Admin_InputPenarikan;
import View.Admin_LihatPenarikan;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Kilam
 */
public class ControllerInputPenarikan implements ActionListener {
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    ArrayList<Penarikan> penarikan = new ArrayList();
    private Admin_InputPenarikan viewInputPenarikan;
    private DatabasePenarikan dbPenarikan;
    
    public ControllerInputPenarikan() {
        viewInputPenarikan = new Admin_InputPenarikan();
        dbPenarikan = new DatabasePenarikan();
        viewInputPenarikan.addActionListener(this);
        viewInputPenarikan.setVisible(true);
        viewInputPenarikan.setLocationRelativeTo(null);
        viewInputPenarikan.setFormat(format);
        viewInputPenarikan.setBtnOK(false);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if (source.equals(viewInputPenarikan.getBtnCari())){
            btnCariAnggotaActionPerformed();
        }else if (source.equals(viewInputPenarikan.getBtnOK())){
            btnOKAnctionPerformed();
        }else if (source.equals(viewInputPenarikan.getBtnReset())){
            reset();
        }else if (source.equals(viewInputPenarikan.getBtnCancel())){
            reset();
            viewInputPenarikan.dispose();
        }
    }
    
    public void btnCariAnggotaActionPerformed(){
        String kode_ang = viewInputPenarikan.getTxkdAnggota().toString();
        if(!kode_ang.equals("")){
            String nama = dbPenarikan.cekAnggota(kode_ang);
            if(!nama.equals("")){
                int Saldo = dbPenarikan.cekSaldo(kode_ang);
                viewInputPenarikan.setTxNama(nama);
                viewInputPenarikan.setTxSaldo(Saldo);
                viewInputPenarikan.setBtnOK(true);
            }else{
                reset();
                JOptionPane.showMessageDialog(viewInputPenarikan, "Kode anggota tidak ditemukan","GAGAL",JOptionPane.ERROR_MESSAGE);
            }
        }else{
            JOptionPane.showMessageDialog(viewInputPenarikan, "Kode anggota tidak boleh kosong","GAGAL",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void btnOKAnctionPerformed(){
        String kode_ang = viewInputPenarikan.getTxkdAnggota().toString();
        if(kode_ang.isEmpty()){
            JOptionPane.showMessageDialog(viewInputPenarikan, "Terdapat data yang kosong","GAGAL",JOptionPane.ERROR_MESSAGE);
        }else{
            int jawab = JOptionPane.showConfirmDialog(null, 
                    "Apakah data sudah sesuai?", 
                    "Konfirmasi", 
                    JOptionPane.YES_NO_OPTION, 
                    JOptionPane.QUESTION_MESSAGE);
            if(jawab == JOptionPane.YES_OPTION){
                String kode_penarikan = kode_ang + "TRK" + dbPenarikan.getSum(kode_ang);
                String tgl_penarikan = viewInputPenarikan.getTxtglTarik();
                int saldo = Integer.valueOf(viewInputPenarikan.getTxSaldo());
                int jum_penarikan = Integer.valueOf(viewInputPenarikan.getTxJumTarik());
                if(jum_penarikan <= 0){
                    JOptionPane.showMessageDialog(viewInputPenarikan, "Jumlah penarikan tidak valid","GAGAL",JOptionPane.ERROR_MESSAGE);
                }else{
                    if(jum_penarikan > saldo){
                        JOptionPane.showMessageDialog(viewInputPenarikan, "Saldo tidak mencukupi","GAGAL",JOptionPane.ERROR_MESSAGE);
                    }else{
                        dbPenarikan.PenarikanUang(new Penarikan(
                                jum_penarikan, kode_ang, kode_penarikan, tgl_penarikan
                        ));
                        reset();
                        JOptionPane.showMessageDialog(viewInputPenarikan, "Penarikan berhasil disimpan","BERHASIL",JOptionPane.INFORMATION_MESSAGE);
                        viewInputPenarikan.setBtnOK(false);
                    }
                }
            }
        }
    }
    
    public void reset(){
        viewInputPenarikan.setTxkdAnggota("");
        viewInputPenarikan.setTxNama("");
        viewInputPenarikan.setTxSaldo(0);
        viewInputPenarikan.setTxJumTarik(0);
        viewInputPenarikan.setBtnOK(false);
    }
}