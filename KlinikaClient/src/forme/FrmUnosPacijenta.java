/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package forme;

import domain.Pacijent;
import forme.glavna.FrmKlinika;
import javax.swing.JOptionPane;
import logika.KontrolerKlijent;

/**
 *
 * @author Jovana
 */
public class FrmUnosPacijenta extends javax.swing.JFrame {

    Pacijent pacijentZaIzmenu;
    FrmKlinika frmKlinika;
    /**
     * Creates new form FrmUnosPacijenta
     */
    public FrmUnosPacijenta(Pacijent zaIzmenu, FrmKlinika frmKlinika) {
        initComponents();
        
        this.frmKlinika=frmKlinika;
        this.pacijentZaIzmenu=zaIzmenu;
        setLocationRelativeTo(null);
        if(zaIzmenu!=null){
            btnDodajPacijenta.setEnabled(false);
            btnIzmeni.setEnabled(true);
            setTitle("Izmeni podatke o pacijentu");
            popuniPolja();
        }else{
            btnIzmeni.setEnabled(false);
            btnDodajPacijenta.setEnabled(true);
            setTitle("Dodaj pacijenta");
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
        txtIme = new javax.swing.JTextField();
        txtPrezime = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtStarost = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtAdresa = new javax.swing.JTextField();
        btnDodajPacijenta = new javax.swing.JButton();
        btnIzmeni = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Ime:");

        jLabel2.setText("Prezime:");

        jLabel3.setText("Starost:");

        jLabel4.setText("Adresa:");

        txtAdresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAdresaActionPerformed(evt);
            }
        });

        btnDodajPacijenta.setText("Dodaj");
        btnDodajPacijenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDodajPacijentaActionPerformed(evt);
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
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnIzmeni)
                        .addGap(18, 18, 18)
                        .addComponent(btnDodajPacijenta))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtAdresa, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtStarost, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtIme, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addGap(37, 37, 37)
                            .addComponent(txtPrezime, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(72, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtIme, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtPrezime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtStarost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtAdresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDodajPacijenta)
                    .addComponent(btnIzmeni))
                .addContainerGap(72, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtAdresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAdresaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAdresaActionPerformed

    private void btnDodajPacijentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDodajPacijentaActionPerformed
        // TODO add your handling code here:
         try {
            if (txtIme.getText().isEmpty()
                    || txtPrezime.getText().isEmpty()
                    || txtStarost.getText().isEmpty()
                    || txtAdresa.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Sva polja su obavezna!");
                return;
            }
            String ime=txtIme.getText();
            String prezime=txtPrezime.getText();
            int starost=Integer.parseInt(txtStarost.getText());
            String adresa=txtAdresa.getText();
            Pacijent p=new Pacijent(0L, ime, prezime, starost, adresa);
            KontrolerKlijent.getInstance().sacuvajPacijenta(p);
            JOptionPane.showMessageDialog(this, "Sistem je zapamatio pacijenta!");
            frmKlinika.popuniCmbLista();
            this.dispose();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }//GEN-LAST:event_btnDodajPacijentaActionPerformed

    private void btnIzmeniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIzmeniActionPerformed
        // TODO add your handling code here:
        try {
            if (txtIme.getText().isEmpty()
                    || txtPrezime.getText().isEmpty()
                    || txtStarost.getText().isEmpty()
                    || txtAdresa.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Sva polja su obavezna!");
                return;
            }
            String ime=txtIme.getText();
            String prezime=txtPrezime.getText();
            int starost=Integer.parseInt(txtStarost.getText());
            String adresa=txtAdresa.getText();
            Pacijent p=new Pacijent(pacijentZaIzmenu.getPacijentId(), ime, prezime, starost, adresa);
            KontrolerKlijent.getInstance().izmeniPacijenta(p);
            frmKlinika.popuniCmbLista();
            JOptionPane.showMessageDialog(this, "Sistem je zapamatio pacijenta!");
            this.dispose();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Sistem nije zapamtio izmene.");
        }
    }//GEN-LAST:event_btnIzmeniActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDodajPacijenta;
    private javax.swing.JButton btnIzmeni;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField txtAdresa;
    private javax.swing.JTextField txtIme;
    private javax.swing.JTextField txtPrezime;
    private javax.swing.JTextField txtStarost;
    // End of variables declaration//GEN-END:variables

    private void popuniPolja() {
        txtIme.setText(pacijentZaIzmenu.getIme());
        txtPrezime.setText(pacijentZaIzmenu.getPrezime());
        txtStarost.setText(String.valueOf(pacijentZaIzmenu.getStarost()));
        txtAdresa.setText(pacijentZaIzmenu.getAdresa());
    }
}
