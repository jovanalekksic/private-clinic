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
public class Stavka extends ApstraktniObjekat implements Serializable {

    private Long stavkaId;
    private Racun racun;
    //private Usluga usluga;
    private Pregled pregled;
    private double cena;

    public Stavka() {
    }

    public Stavka(Long stavkaId, Racun racun,  Pregled pregled, double cena) {
        this.stavkaId = stavkaId;
        this.racun = racun;
        
        this.pregled = pregled;
        this.cena = cena;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public Long getStavkaId() {
        return stavkaId;
    }

    public void setStavkaId(Long stavkaId) {
        this.stavkaId = stavkaId;
    }

    public Racun getRacun() {
        return racun;
    }

    public void setRacun(Racun racun) {
        this.racun = racun;
    }


    public Pregled getPregled() {
        return pregled;
    }

    public void setPregled(Pregled pregled) {
        this.pregled = pregled;
    }

    @Override
    public String vratiNazivTabele() {
        return "stavka";
    }

    @Override
    public String alijas() {
        return "s";
    }

    @Override
    public String spajanje() {
        return "JOIN racun r using(racunId)"
                + "JOIN pregled p using(pregledId)"
                + "JOIN pacijent pac using(pacijentId)";
    }

    @Override
    public ArrayList<ApstraktniObjekat> selectLista(ResultSet rs) throws SQLException {
        ArrayList<ApstraktniObjekat> lista = new ArrayList<>();
        while (rs.next()) {
            Pacijent pacijent = new Pacijent(rs.getLong("pacijentId"), rs.getString("ime"), rs.getString("prezime"), rs.getInt("starost"), rs.getString("adresa"));
            Racun racun = new Racun(rs.getLong("racunId"), rs.getDouble("ukupanIznos"), pacijent,rs.getTimestamp("datum"));
            Doktor doktor = new Doktor(rs.getLong("doktorId"), rs.getString("imeD"), rs.getString("prezimeD"), rs.getString("specijalizacija"));
            
            Usluga usluga = new Usluga(rs.getLong("uslugaId"), rs.getString("naziv"), rs.getInt("cena"));
            Stavka stavka = new Stavka(rs.getLong("stavkaId"), racun, pregled, rs.getDouble("cena"));

            lista.add(stavka);
        }
        rs.close();
        return lista;
    }

    @Override
    public String koloneZaInsert() {
        return "(racunId, pregledId, cena)";
    }

    @Override
    public String primarniKljuc() {
        return "stavkaId=" + stavkaId;
    }

    @Override
    public String vrednostiZaInsert() {
        return racun.getRacunId()+","+pregled.getPregledId()+","+cena;
    }

    @Override
    public String vrednostiZaUpdate() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String id() {
        return "stavkaId=" + stavkaId;
    }

}
