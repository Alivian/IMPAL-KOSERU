/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Database.DatabaseSimpanan;
import Model.Simpanan;
import View.Admin_InputSimpanan;
import View.Admin_LihatSimpanan;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Randi Salam
 */
public class ControllerSimpanan implements ActionListener {
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    ArrayList<Simpanan> simpanan = new ArrayList();
    private Admin_InputSimpanan viewInputSimpanan;
    private DatabaseSimpanan dbSimpanan;

    public ControllerSimpanan() {
        viewInputSimpanan = new Admin_InputSimpanan();
        dbSimpanan = new DatabaseSimpanan();
        viewInputSimpanan.addActionListener(this);
        viewInputSimpanan.setVisible(true);
        viewInputSimpanan.setLocationRelativeTo(null);
        viewInputSimpanan.setFormat(format);
        viewInputSimpanan.setBtnOK(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source.equals(viewInputSimpanan.getBtnCari())){
            btnCariAnggotaActionPerformed();
        }else if (source.equals(viewInputSimpanan.getBtnOK())){
            btnOKAnctionPerformed();
        }else if (source.equals(viewInputSimpanan.getBtnReset())){
            reset();
        }else if (source.equals(viewInputSimpanan.getBtnCancel())){
            reset();
            viewInputSimpanan.dispose();
        }
    }
    
    
    
    public void btnCariAnggotaActionPerformed(){
        String kode_ang = viewInputSimpanan.getTxkdAnggota().toString();
        if(!kode_ang.equals("")){
            String nama = dbSimpanan.cekAnggota(kode_ang);
            if(!nama.equals("")){
                viewInputSimpanan.setTxNama(nama);
                viewInputSimpanan.setBtnOK(true);
            }else{
                reset();
                JOptionPane.showMessageDialog(viewInputSimpanan, "Kode anggota tidak ditemukan","GAGAL",JOptionPane.ERROR_MESSAGE);
            }
        }else{
            JOptionPane.showMessageDialog(viewInputSimpanan, "Kode anggota tidak boleh kosong","GAGAL",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void btnOKAnctionPerformed(){
        String kode_ang = viewInputSimpanan.getTxkdAnggota().toString();
        if(kode_ang.isEmpty()){
            JOptionPane.showMessageDialog(viewInputSimpanan, "Terdapat data yang kosong","GAGAL",JOptionPane.ERROR_MESSAGE);
        }else{
            String kode_simpanan = kode_ang + "TRK" + dbSimpanan.getSum(kode_ang);
            String tgl_simpanan = viewInputSimpanan.getTglSimpan();
            int jum_simpanan = Integer.valueOf(viewInputSimpanan.getTxJumSimpan()) ;
            if(jum_simpanan <= 0){
                JOptionPane.showMessageDialog(viewInputSimpanan, "Jumlah penarikan tidak valid","GAGAL",JOptionPane.ERROR_MESSAGE);
            }else{
                dbSimpanan.SimpananUang(new Simpanan(
                jum_simpanan, kode_ang, kode_simpanan, tgl_simpanan
                ));
                reset();
                JOptionPane.showMessageDialog(viewInputSimpanan, "Simpan uang berhasil disimpan","BERHASIL",JOptionPane.INFORMATION_MESSAGE);
                viewInputSimpanan.setBtnOK(false);
            }
        }
    }

    public void reset(){
        viewInputSimpanan.setTxkdAnggota("");
        viewInputSimpanan.setTxNama("");
        viewInputSimpanan.setTxJumSimpan(0);
        viewInputSimpanan.setBtnOK(false);
    }    
    
}
