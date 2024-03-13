/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package forme;

import domain.Doktor;
import domain.Pacijent;
import forme.glavna.FrmKlinika;
import javax.swing.JOptionPane;
import logika.KontrolerKlijent;

/**
 *
 * @author Jovana
 */
public class FrmUnosDoktora extends javax.swing.JFrame {

    Doktor doktor;
    FrmKlinika frmKlinika;
    /**
     * Creates new form FrmUnosDoktora
     */
    public FrmUnosDoktora(FrmKlinika frmKlinika,Doktor doktor) {
        initComponents();
        this.doktor=doktor;
        this.frmKlinika=frmKlinika;
        setLocationRelativeTo(null);
        
        if(doktor!=null){
            btnDodajDoktora.setEnabled(false);
            btnIzmeni.setEnabled(true);
            setTitle("Izmeni podatke o doktoru");
            popuniPolja();
        }else{
            btnIzmeni.setEnabled(false);
            btnDodajDoktora.setEnabled(true);
            setTitle("Unesi doktora");
        }
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
        txtIme = new javax.swing.JTextField();
        txtPrezime = new javax.swing.JTextField();
        txtSpecijalizacija = new javax.swing.JTextField();
        btnDodajDoktora = new javax.swing.JButton();
        btnIzmeni = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Ime:");

        jLabel2.setText("Prezime:");

        jLabel3.setText("Specijalizacija:");

        btnDodajDoktora.setText("Dodaj");
        btnDodajDoktora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDodajDoktoraActionPerformed(evt);
            }
        });

        btnIzmeni.setText("Izmeni");
        btnIzmeni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIzmeniActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnIzmeni)
                        .addGap(18, 18, 18)
                        .addComponent(btnDodajDoktora))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addGap(34, 34, 34)
                            .addComponent(txtSpecijalizacija, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1)
                                .addComponent(jLabel2))
                            .addGap(64, 64, 64)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtPrezime, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtIme, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(68, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(49, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtIme, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtPrezime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSpecijalizacija, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDodajDoktora)
                    .addComponent(btnIzmeni))
                .addGap(93, 93, 93))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDodajDoktoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDodajDoktoraActionPerformed
        // TODO add your handling code here:
         try {
            if (txtIme.getText().isEmpty()
                    || txtPrezime.getText().isEmpty()
                    || txtSpecijalizacija.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Sistem ne moze da zapamti doktora!");
                return;
            }
            String ime=txtIme.getText();
            String prezime=txtPrezime.getText();
            
            String specijalizacija=txtSpecijalizacija.getText();
            Doktor doktor=new Doktor(0L, ime, prezime, specijalizacija);
            KontrolerKlijent.getInstance().sacuvajDoktora(doktor);
            frmKlinika.popuniCmbLista();
            JOptionPane.showMessageDialog(this, "Sistem je zapamatio doktora!");
            this.dispose();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
        
    }//GEN-LAST:event_btnDodajDoktoraActionPerformed

    private void btnIzmeniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIzmeniActionPerformed
        // TODO add your handling code here:
        try {
            if (txtIme.getText().isEmpty()
                    || txtPrezime.getText().isEmpty()
                    || txtSpecijalizacija.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Sistem ne moze da zapamti doktora!");
                return;
            }
            String ime=txtIme.getText();
            String prezime=txtPrezime.getText();
            
            String specijalizacija=txtSpecijalizacija.getText();
            doktor=new Doktor(doktor.getDoktorId(), ime, prezime, specijalizacija);
            KontrolerKlijent.getInstance().izmeniDoktora(doktor);
            frmKlinika.popuniCmbLista();
            JOptionPane.showMessageDialog(this, "Sistem je zapamatio doktora!");
            this.dispose();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }//GEN-LAST:event_btnIzmeniActionPerformed

    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDodajDoktora;
    private javax.swing.JButton btnIzmeni;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField txtIme;
    private javax.swing.JTextField txtPrezime;
    private javax.swing.JTextField txtSpecijalizacija;
    // End of variables declaration//GEN-END:variables

    private void popuniPolja() {
        txtIme.setText(doktor.getIme());
        txtPrezime.setText(doktor.getPrezime());
        txtSpecijalizacija.setText(doktor.getSpecijalizacija());
    }
}