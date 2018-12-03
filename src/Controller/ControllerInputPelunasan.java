/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Database.DatabasePenarikan;
import Database.DatabasePinjaman;
import Model.Penarikan;
import Model.Pinjaman;
import View.Admin_InputPelunasan;
import View.Admin_InputPenarikan;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Kilam
 */
public class ControllerInputPelunasan implements ActionListener {

    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    ArrayList<Penarikan> penarikan = new ArrayList();
    private Admin_InputPelunasan viewInputPelunasan;
    private DatabasePinjaman dbPinjaman;
    
    public ControllerInputPelunasan() {
        viewInputPelunasan = new Admin_InputPelunasan();
        dbPinjaman = new DatabasePinjaman();
        viewInputPelunasan.addActionListener(this);
        viewInputPelunasan.setVisible(true);
        viewInputPelunasan.setLocationRelativeTo(null);
        viewInputPelunasan.setFormat(format);
        viewInputPelunasan.setBtnOK(false);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if (source.equals(viewInputPelunasan.getBtnCari())){
            btnCariAnggotaActionPerformed();
        }else if (source.equals(viewInputPelunasan.getBtnOK())){
            btnOKActionPerformed();
        }else if (source.equals(viewInputPelunasan.getBtnReset())){
            reset();
        }else if (source.equals(viewInputPelunasan.getBtnCancel())){
            reset();
            viewInputPelunasan.dispose();
        }
    }
    
    public void btnCariAnggotaActionPerformed(){
        String kode_ang = viewInputPelunasan.getTxKodeAnggota().toString();
        if(!kode_ang.equals("")){
            String nama = dbPinjaman.cekAnggota(kode_ang);
            if(!nama.equals("")){
                Pinjaman p = dbPinjaman.cariPinjaman(kode_ang);
                if(p != null){
                    viewInputPelunasan.setBtnOK(true);
                    viewInputPelunasan.setTxNama(nama);
                    viewInputPelunasan.setTxTglPinjam(p.getTgl_pinjam());
                    viewInputPelunasan.setTxKet(p.getKet_pinjam());
                    viewInputPelunasan.setTxJumPinjam(p.getJum_pinjam()+"");
                }else{
                    JOptionPane.showMessageDialog(viewInputPelunasan, "Tidak ditemukan pinjaman yang belum lunas","INFORMASI",JOptionPane.ERROR_MESSAGE);
                    reset();
                }
            }else{
                reset();
                JOptionPane.showMessageDialog(viewInputPelunasan, "Kode anggota tidak ditemukan","GAGAL",JOptionPane.ERROR_MESSAGE);
            }
        }else{
            JOptionPane.showMessageDialog(viewInputPelunasan, "Kode anggota tidak boleh kosong","GAGAL",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void btnOKActionPerformed(){
        int jawab = JOptionPane.showConfirmDialog(null, 
                    "Apakah data sudah sesuai?", 
                    "Konfirmasi", 
                    JOptionPane.YES_NO_OPTION, 
                    JOptionPane.QUESTION_MESSAGE);
        if(jawab == JOptionPane.YES_OPTION){
            String kode_ang = viewInputPelunasan.getTxKodeAnggota().toString();
            if(dbPinjaman.setLunas(kode_ang)){
                JOptionPane.showMessageDialog(viewInputPelunasan, "Pelunasan berhasil disimpan","BERHASIL",JOptionPane.INFORMATION_MESSAGE);
            }
            else
                JOptionPane.showMessageDialog(viewInputPelunasan, "Pelunasan gagal disimpan","GAGAL",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void reset(){
        viewInputPelunasan.setTxKodeAnggota("");
        viewInputPelunasan.setTxTglPinjam("");
        viewInputPelunasan.setTxNama("");
        viewInputPelunasan.setTxJumPinjam("0");
        viewInputPelunasan.setTxKet("");
        viewInputPelunasan.setBtnOK(false);
    }
    
}
