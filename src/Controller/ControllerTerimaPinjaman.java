/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Database.DatabasePinjaman;
import Model.Pinjaman;
import View.Admin_TerimaPinjaman;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.plaf.ViewportUI;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Kilam
 */
public class ControllerTerimaPinjaman extends MouseAdapter implements ActionListener {
    private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    private Admin_TerimaPinjaman viewTerimaPinjaman;
    private DatabasePinjaman dbPinjaman;

    public ControllerTerimaPinjaman() {
        viewTerimaPinjaman = new Admin_TerimaPinjaman();
        viewTerimaPinjaman.addActionListener(this);
        viewTerimaPinjaman.addMouseAdapter(this);
        viewTerimaPinjaman.setVisible(true);
        viewTerimaPinjaman.setLocationRelativeTo(null);
        viewTerimaPinjaman.setBtnTerima(false);
        viewTerimaPinjaman.setBtnTolak(false);
        dbPinjaman = new DatabasePinjaman();
        dbPinjaman.getAllPinjaman(true);
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
        viewTerimaPinjaman.setTblReqPinjaman(model);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if (source.equals(viewTerimaPinjaman.getBtnTerima())){
            btnTerimaActionPerformed();
        }else if (source.equals(viewTerimaPinjaman.getBtnTolak())){
            btnTolakAnctionPerformed();
        }else if (source.equals(viewTerimaPinjaman.getBtnSelesai())){
            viewTerimaPinjaman.dispose();
        }
    }
    
    public void btnTerimaActionPerformed(){
        try{
            int row = viewTerimaPinjaman.getSelectedPinjaman();
            String kode_pinjam = viewTerimaPinjaman.getTblReqPinjaman().getValueAt(row, 2).toString();
            if(dbPinjaman.ubahStatusPinjaman(kode_pinjam, "diterima")){
                JOptionPane.showMessageDialog(viewTerimaPinjaman, "Pinjaman diterima","BERHASIL",JOptionPane.INFORMATION_MESSAGE);
            }
            viewTerimaPinjaman.getModel().removeRow(row);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        viewTerimaPinjaman.setBtnTerima(false);
        viewTerimaPinjaman.setBtnTolak(false);
    }
    
    public void btnTolakAnctionPerformed(){
        try{
            int row = viewTerimaPinjaman.getSelectedPinjaman();
            String kode_pinjam = viewTerimaPinjaman.getTblReqPinjaman().getValueAt(row, 2).toString();
            if(dbPinjaman.ubahStatusPinjaman(kode_pinjam, "ditolak")){
                JOptionPane.showMessageDialog(viewTerimaPinjaman, "Pinjaman ditolak","BERHASIL",JOptionPane.INFORMATION_MESSAGE);
            }
            viewTerimaPinjaman.getModel().removeRow(row);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        viewTerimaPinjaman.setBtnTerima(false);
        viewTerimaPinjaman.setBtnTolak(false);
    }
    
    @Override
    public void mousePressed(MouseEvent me){
        Object source = me.getSource();
        if (source.equals(viewTerimaPinjaman.getTblReqPinjaman())){
            int i = viewTerimaPinjaman.getSelectedPinjaman();
            if(i >= 0){
                viewTerimaPinjaman.setBtnTerima(true);
                viewTerimaPinjaman.setBtnTolak(true);
            }else{
                viewTerimaPinjaman.setBtnTerima(false);
                viewTerimaPinjaman.setBtnTolak(false);
            }
        }
    }
}
