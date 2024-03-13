/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modeli;

import domain.Racun;
import forme.FrmPretraziIzmeniObrisiRacun;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;
import logika.KontrolerKlijent;

/**
 *
 * @author Jovana
 */
public class RacuniTableModel extends AbstractTableModel{
    
    private ArrayList<Racun> listaRacuna;
    private String[] kolone={"RacunId","Ukupan iznos", "Ime","Prezime","Datum i vreme"};
    private Long pretraga=null;

    public RacuniTableModel() {
        try {
            listaRacuna=KontrolerKlijent.getInstance().vratiRacune();
        } catch (Exception e) {
               Logger.getLogger(RacuniTableModel.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    

    public void setPretraga(Long pretraga) {
        this.pretraga = pretraga;
        osveziTabelu();
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }
    
    @Override
    public int getRowCount() {
        return listaRacuna.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Racun racun=listaRacuna.get(rowIndex);
        switch (columnIndex) {
            case 0: return racun.getRacunId();
            case 1: return racun.getUkupanIznos();
            case 2: return racun.getPacijent().getIme();
            case 3: return racun.getPacijent().getPrezime();
            case 4: return racun.getDatum();
            default: return "";
        }
    }

    private void osveziTabelu() {
        try {
            if(!pretraga.equals("")){
                ArrayList<Racun> noviRacuni=new ArrayList<>();
                for (Racun racun : listaRacuna) {
                    if(racun.getRacunId().equals((pretraga))){
                        noviRacuni.add(racun);
                    }
                }
                if(noviRacuni.size()>0){
                    FrmPretraziIzmeniObrisiRacun.setPoruka("Sistem je pronasao racun po zadatoj vrednosti");
                }else{
                    FrmPretraziIzmeniObrisiRacun.setPoruka("Sistem nije pronasao racun po zadatoj vrednosti");
                }
                listaRacuna=noviRacuni;
            }
            fireTableDataChanged();
        } catch (Exception e) {
            Logger.getLogger(RacuniTableModel.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public Racun vratiRacun(int red) {
        return listaRacuna.get(red);
    }

    public void obrisiRed(int red) {
        listaRacuna.remove(red);
        fireTableDataChanged();
    }
    
    
    
}
