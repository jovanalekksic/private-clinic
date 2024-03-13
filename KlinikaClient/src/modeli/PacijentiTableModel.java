/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modeli;

import domain.Pacijent;
import forme.FrmPretraziIzmeniPacijenta;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import logika.KontrolerKlijent;

/**
 *
 * @author Jovana
 */
public class PacijentiTableModel extends AbstractTableModel{
    
    private ArrayList<Pacijent> listaPacijenata;
    private String[] kolone={"Ime","Prezime","Starost","Adresa"};
    
    private String pretraga="";

    public void setPretraga(String pretraga) {
        this.pretraga = pretraga;
        osveziTabelu();
    }
    

    public PacijentiTableModel() {
        try {
            listaPacijenata=KontrolerKlijent.getInstance().vratiPacijente();
        } catch (Exception ex) {
             Logger.getLogger(PacijentiTableModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    @Override
    public int getRowCount() {
        return listaPacijenata.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Pacijent pacijent=listaPacijenata.get(rowIndex);
        switch (columnIndex) {
            case 0: return pacijent.getIme();
            case 1: return pacijent.getPrezime();
            case 2: return pacijent.getStarost();
            case 3: return pacijent.getAdresa();
            default: return "";
        }
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }
    

    private void osveziTabelu() {
        try {
            if(!pretraga.equals("")){
                ArrayList<Pacijent> nova=new ArrayList<>();
                for (Pacijent pacijent : listaPacijenata) {
                    if(pacijent.getIme().toLowerCase().contains(pretraga.toLowerCase()) || pacijent.getPrezime().toLowerCase().contains(pretraga.toLowerCase())){
                        nova.add(pacijent);
                    }
                }
                if(nova.size()>0){
                    FrmPretraziIzmeniPacijenta.setPoruka("Sistem je pronasao pacijente po zadatoj vrednosti.");
                }else{
                     FrmPretraziIzmeniPacijenta.setPoruka("Sistem nije pronasao pacijente po zadatoj vrednosti.");
                }
                listaPacijenata=nova;
            }
            fireTableDataChanged();
        } catch (Exception ex) {
            Logger.getLogger(PacijentiTableModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Pacijent vratiIzabranogPacijenta(int red) {
        return listaPacijenata.get(red);
    }

    
    
}
