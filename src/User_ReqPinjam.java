


import Model.Pinjam;
import static java.lang.Math.ceil;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Malik
 */
public class User_ReqPinjam extends javax.swing.JFrame {
    private String kode;
    private DatabasePinjaman ppd = new DatabasePinjaman();
    SimpleDateFormat format = new SimpleDateFormat("dd MMMMM yyyy");
    DefaultTableModel mdl;
    private DefaultComboBoxModel<String> dcm;
    /**
     * Creates new form ReqPinjam
     */
    public User_ReqPinjam(String kode, DefaultTableModel mdl) {
        initComponents();
        this.setLocationRelativeTo(null);
        U_txDatePinjam.setText(format.format(new Date())+"");
        dcm = (DefaultComboBoxModel<String>) BanyakCicilan.getModel();
        this.kode = kode;
        this.mdl = mdl;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        U_txDatePinjam = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        U_txKetPinjam = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        U_txJumPinjam = new javax.swing.JTextField();
        U_ReqbtnOK = new javax.swing.JButton();
        U_ReqbtnReset = new javax.swing.JButton();
        U_ReqbtnCancel = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        U_txTagihan = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        BanyakCicilan = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();

        jLabel4.setText("jLabel4");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        jPanel1.setEnabled(false);

        U_txDatePinjam.setEditable(false);
        U_txDatePinjam.setText("dd/mm/yy");
        U_txDatePinjam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                U_txDatePinjamActionPerformed(evt);
            }
        });

        jLabel1.setText("Keterangan Pinjam");

        jLabel2.setText("Tanggal Pinjam");

        U_txKetPinjam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                U_txKetPinjamActionPerformed(evt);
            }
        });

        jLabel5.setText("Jumlah Pinjam");

        U_txJumPinjam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                U_txJumPinjamActionPerformed(evt);
            }
        });

        U_ReqbtnOK.setText("OK");
        U_ReqbtnOK.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(204, 204, 204), null));
        U_ReqbtnOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                U_ReqbtnOKActionPerformed(evt);
            }
        });

        U_ReqbtnReset.setText("RESET");
        U_ReqbtnReset.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(204, 204, 204), null));
        U_ReqbtnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                U_ReqbtnResetActionPerformed(evt);
            }
        });

        U_ReqbtnCancel.setText("CANCEL");
        U_ReqbtnCancel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(204, 204, 204), null));
        U_ReqbtnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                U_ReqbtnCancelActionPerformed(evt);
            }
        });

        jLabel6.setText("Jumlah Tagihan per bulan");

        U_txTagihan.setEditable(false);
        U_txTagihan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                U_txTagihanActionPerformed(evt);
            }
        });

        jLabel7.setText("Banyaknya cicilan");

        BanyakCicilan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Pilih Banyaknya Cicilan --", "3", "6", "9", "12" }));
        BanyakCicilan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BanyakCicilanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(U_ReqbtnOK, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(U_ReqbtnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(U_ReqbtnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(U_txTagihan)
                    .addComponent(U_txDatePinjam)
                    .addComponent(U_txKetPinjam)
                    .addComponent(U_txJumPinjam)
                    .addComponent(BanyakCicilan, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(U_txDatePinjam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(U_txKetPinjam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(U_txJumPinjam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(56, 56, 56)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BanyakCicilan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(U_txTagihan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(U_ReqbtnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(U_ReqbtnCancel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(U_ReqbtnOK, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/KoseruPinjam.png"))); // NOI18N
        jButton1.setBorder(null);
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(69, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jButton1)
                .addGap(34, 34, 34)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void U_txKetPinjamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_U_txKetPinjamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_U_txKetPinjamActionPerformed

    private void U_txJumPinjamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_U_txJumPinjamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_U_txJumPinjamActionPerformed

    private void U_txDatePinjamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_U_txDatePinjamActionPerformed
        
    }//GEN-LAST:event_U_txDatePinjamActionPerformed

    private void U_ReqbtnOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_U_ReqbtnOKActionPerformed
       String a = U_txDatePinjam.getText();
       String b = U_txKetPinjam.getText();
       int c = Integer.valueOf(U_txJumPinjam.getText());
       if(c>=100000 && c<=10000000){
        if(ppd.pinjamUang(kode, new Pinjam(a, b, c, "Belum diproses","-",null))!=0){
            JOptionPane.showMessageDialog(rootPane, "Peminjaman sedang diproses","BERHASIL",JOptionPane.INFORMATION_MESSAGE);
            dispose();
        } else {
             JOptionPane.showMessageDialog(rootPane, "Peminjaman gagal diinput","GAGAL",JOptionPane.ERROR_MESSAGE);
        }
       }else{
           JOptionPane.showMessageDialog(rootPane, "Jumlah pinjaman harus kurang dari 10.000.000 dan lebih dari 100.000","GAGAL",JOptionPane.ERROR_MESSAGE);
       }
        mdl.addRow(new Object[]{a,b,c,"Belum diproses","-"});
        U_txJumPinjam.setText("");
        U_txKetPinjam.setText("");
    }//GEN-LAST:event_U_ReqbtnOKActionPerformed

    private void U_ReqbtnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_U_ReqbtnResetActionPerformed
        U_txJumPinjam.setText("");
        U_txKetPinjam.setText("");
    }//GEN-LAST:event_U_ReqbtnResetActionPerformed

    private void U_ReqbtnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_U_ReqbtnCancelActionPerformed
        this.dispose();
    }//GEN-LAST:event_U_ReqbtnCancelActionPerformed

    private void U_txTagihanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_U_txTagihanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_U_txTagihanActionPerformed

    private void BanyakCicilanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BanyakCicilanActionPerformed
        try{
            if(!BanyakCicilan.equals("-- Pilih Banyaknya Cicilan --")){
                int row = BanyakCicilan.getSelectedIndex();
                int count_cicil = Integer.valueOf(dcm.getElementAt(row).toString());
                double jum_tagihan = ceil((Double.valueOf(U_txJumPinjam.getText()))/count_cicil);
                U_txTagihan.setText(String.valueOf(jum_tagihan));
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_BanyakCicilanActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> BanyakCicilan;
    private javax.swing.JButton U_ReqbtnCancel;
    private javax.swing.JButton U_ReqbtnOK;
    private javax.swing.JButton U_ReqbtnReset;
    private javax.swing.JTextField U_txDatePinjam;
    private javax.swing.JTextField U_txJumPinjam;
    private javax.swing.JTextField U_txKetPinjam;
    private javax.swing.JTextField U_txTagihan;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
