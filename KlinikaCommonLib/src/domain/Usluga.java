/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Jovana
 */
public class Usluga extends ApstraktniObjekat implements Serializable{
    private Long uslugaId;
    private String naziv;
    private int cena;

    public Usluga() {
    }

    public Usluga(Long uslugaId, String naziv, int cena) {
        this.uslugaId = uslugaId;
        this.naziv = naziv;
        this.cena = cena;
    }

    public int getCena() {
        return cena;
    }

    public void setCena(int cena) {
        this.cena = cena;
    }

    public Long getUslugaId() {
        return uslugaId;
    }

    public void setUslugaId(Long uslugaId) {
        this.uslugaId = uslugaId;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    @Override
    public String toString() {
        return naziv+" "+cena;
    }

    @Override
    public String vratiNazivTabele() {
        return "usluga";
    }

    @Override
    public String alijas() {
        return "u";
    }

    @Override
    public String spajanje() {
        return "";
    }

    @Override
    public ArrayList<ApstraktniObjekat> selectLista(ResultSet rs) throws SQLException {
        ArrayList<ApstraktniObjekat> lista=new ArrayList<>();
        while(rs.next()){
            Usluga usluga=new Usluga(rs.getLong("uslugaId"), rs.getString("naziv"), rs.getInt("cena"));
            lista.add(usluga);
        }
        rs.close();
        return lista;
    }

    @Override
    public String koloneZaInsert() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String primarniKljuc() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vrednostiZaInsert() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vrednostiZaUpdate() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String id() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}
