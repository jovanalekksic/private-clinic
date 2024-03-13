/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modeli;

import domain.Pregled;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Jovana
 */
public class PreglediTableModel extends AbstractTableModel{
    
    private ArrayList<Pregled> listaPregleda;
    private String[] kolone={"PregledID","Ime pacijenta","Prezime pacijenta","Ime doktora","Prezime doktora","Usluga","Datum"};

    public PreglediTableModel() {
        listaPregleda=new ArrayList<>();
    }

    public PreglediTableModel(ArrayList<Pregled> listaPregleda) {
        this.listaPregleda = listaPregleda;
    }
    
    
 
    @Override
    public int getRowCount() {
        return listaPregleda.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }
    
    

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Pregled pregled=listaPregleda.get(rowIndex);
        switch (columnIndex) {
            case 0: return pregled.getPregledId();
            case 1: return pregled.getPacijent().getIme();
            case 2: return pregled.getPacijent().getPrezime();
            case 3: return pregled.getDoktor().getIme();
            case 4: return pregled.getDoktor().getPrezime();
            case 5: return pregled.getUsluga().getNaziv();
            case 6: return pregled.getDatumPregleda();
            default: return "N/A";
        }
    }
    
}
