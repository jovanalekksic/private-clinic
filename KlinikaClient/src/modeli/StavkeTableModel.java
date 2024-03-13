/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modeli;

import domain.Stavka;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Jovana
 */
public class StavkeTableModel extends AbstractTableModel{
    
    private ArrayList<Stavka> listaStavki;
    private String[] kolone={"StavkaID","Usluga","Cena"};
    private Long rb=1L;

    public StavkeTableModel() {
        try {
            listaStavki=new ArrayList<>();
        } catch (Exception e) {
            Logger.getLogger(StavkeTableModel.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public StavkeTableModel(ArrayList<Stavka> listaStavki) {
         try {
            this.listaStavki = listaStavki;
            rb=listaStavki.size()+1L;
        } catch (Exception e) {
            Logger.getLogger(StavkeTableModel.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    
    

    @Override
    public int getRowCount() {
        return listaStavki.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Stavka stavka=listaStavki.get(rowIndex);
        switch (columnIndex) {
            case 0: return stavka.getStavkaId();
            case 1: return stavka.getPregled().getUsluga().getNaziv();
            case 2: return stavka.getPregled().getUsluga().getCena();
            default: return "";
        }
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }

    public ArrayList<Stavka> getListaStavki() {
        return listaStavki;
    }

    public void dodajStavku(Stavka stavka) {
        stavka.setStavkaId(rb++);
        listaStavki.add(stavka);
        fireTableDataChanged();
    }
    
    public double vratiUkupanIznos(){
        double ukupno=0;
        for (Stavka stavka : listaStavki) {
            ukupno+=stavka.getCena();
        }
        return ukupno;
    }
    
    
    
}
