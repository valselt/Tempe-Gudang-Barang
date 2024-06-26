/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ViewBarang;

import Controller.ControllerBarang;
import Controller.ControllerHistori;
import Controller.ControllerLoginRegister;
import Model.TabelModelBarang;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author aldo1
 */
public class FormDelete extends javax.swing.JPanel {

    /**
     * Creates new form delete
     */
    public FormDelete() {
        initComponents();
        ctBarang = new ControllerBarang(this);
        ctHistori = new ControllerHistori(this);
        ctLoginRegister = new ControllerLoginRegister(this);
        ctBarang.isiComboboxKodeBarang(comboboxKodeBarang);
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        buttonHapus = new javax.swing.JButton();
        comboboxKodeBarang = new javax.swing.JComboBox<>();

        jLabel1.setFont(new java.awt.Font("Humnst777 Lt BT", 1, 38)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(95, 99, 104));
        jLabel1.setText("Histori");

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/deleteHeader.png"))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Humnst777 Lt BT", 1, 38)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(95, 99, 104));
        jLabel3.setText("Hapus Barang");

        jLabel8.setFont(new java.awt.Font("Humnst777 Lt BT", 0, 14)); // NOI18N
        jLabel8.setText("Kode Barang");

        buttonHapus.setBackground(new java.awt.Color(209, 26, 42));
        buttonHapus.setFont(new java.awt.Font("Humnst777 BT", 1, 18)); // NOI18N
        buttonHapus.setForeground(new java.awt.Color(255, 255, 255));
        buttonHapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/deleteforever.png"))); // NOI18N
        buttonHapus.setText("Hapus");
        buttonHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonHapusActionPerformed(evt);
            }
        });

        comboboxKodeBarang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboboxKodeBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboboxKodeBarangActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 304, Short.MAX_VALUE)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(buttonHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(104, 104, 104)
                                .addComponent(comboboxKodeBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 279, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(comboboxKodeBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(71, 71, 71)
                .addComponent(buttonHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(148, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buttonHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonHapusActionPerformed
        String level = ctLoginRegister.isItAdmin();
        
        if ("user".equals(level)){
            JOptionPane.showMessageDialog(null, "Level Pengguna Yang Anda Miliki Tidak Berhak Untuk Mengubah Data!");
            
        } else if ("admin".equals(level)){
            ctBarang.deleteBarang(); 
            ctHistori.historiDelete();
        }
    }//GEN-LAST:event_buttonHapusActionPerformed
  
    private void comboboxKodeBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboboxKodeBarangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboboxKodeBarangActionPerformed
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonHapus;
    private javax.swing.JComboBox<String> comboboxKodeBarang;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel8;
    // End of variables declaration//GEN-END:variables

     
    public JComboBox getComboKodeBarang(){
        return comboboxKodeBarang;
    }
    
    ControllerBarang ctBarang;
    ControllerHistori ctHistori;
    ControllerLoginRegister ctLoginRegister;

}
