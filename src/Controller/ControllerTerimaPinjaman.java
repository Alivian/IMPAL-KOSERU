/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Database.DatabasePinjaman;
import Model.Pinjaman;
import View.Admin_MenuAdmin;
import com.mysql.jdbc.PingTarget;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.plaf.ViewportUI;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Kilam
 */
public class ControllerTerimaPinjaman extends MouseAdapter implements ActionListener {
    private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    private Admin_MenuAdmin viewMenuAdmin;
    private DatabasePinjaman dbPinjaman;

    public ControllerTerimaPinjaman() {
        viewMenuAdmin = new Admin_MenuAdmin();
        viewMenuAdmin.setLocationRelativeTo(null);
        viewMenuAdmin.addActionListener(this);
        viewMenuAdmin.setVisible(true);
        viewMenuAdmin.setBtnTerima(false);
        viewMenuAdmin.setBtnTolak(false);
        dbPinjaman = new DatabasePinjaman();
        dbPinjaman.getAllPinjaman();
        loadTable();
    }
    
    public void loadTable(){
        DefaultTableModel model = new DefaultTableModel(new String[]{
            "Kode Anggota", "Nama", "Kode Pinjam", "Tanggal Pinjam", "Keterangan", "Jumlah Pinjam"}, 0);
        ArrayList<Pinjaman> pinjaman = dbPinjaman.getPinjaman();
        for (Pinjaman p : pinjaman) {
            model.addRow(new Object[]{
                p.getKode_ang(),
                dbPinjaman.cekAnggota(p.getKode_ang()),
                p.getKode_pinjam(),
                p.getTgl_pinjam(),
                p.getKet_pinjam(),
                p.getJum_pinjam()
            });
        }
        viewMenuAdmin.setTblReqPinjaman(model);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if (source.equals(viewMenuAdmin.getBtnTerima())){
            btnTerimaActionPerformed();
        }else if (source.equals(viewMenuAdmin.getBtnTolak())){
            btnTolakAnctionPerformed();
        }
    }
    
    public void btnTerimaActionPerformed(){
        try{
            int row = viewMenuAdmin.getSelectedPinjaman();
            String kode_ang = viewMenuAdmin.getTblReqPinjaman().getValueAt(row, 3).toString();
            dbPinjaman.ubahStatusPinjaman(kode_ang, "diterima");
            viewMenuAdmin.getTblReqPinjaman().removeRow(row);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        viewMenuAdmin.setBtnTerima(false);
    }
    
    public void btnTolakAnctionPerformed(){
        try{
            int row = viewMenuAdmin.getSelectedPinjaman();
            String kode_ang = viewMenuAdmin.getTblReqPinjaman().getValueAt(row, 3).toString();
            dbPinjaman.ubahStatusPinjaman(kode_ang, "ditolak");
            viewMenuAdmin.getTblReqPinjaman().removeRow(row);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        viewMenuAdmin.setBtnTolak(false);
    }
    
    @Override
    public void mousePressed(MouseEvent me){
        Object source = me.getSource();
        if (source.equals(viewMenuAdmin.getTblReqPinjaman())){
            int i = viewMenuAdmin.getSelectedPinjaman();
            if(i >= 0){
                viewMenuAdmin.setBtnTerima(true);
                viewMenuAdmin.setBtnTolak(true);
            }else{
                viewMenuAdmin.setBtnTerima(false);
                viewMenuAdmin.setBtnTolak(false);
            }
        }
    }
}
