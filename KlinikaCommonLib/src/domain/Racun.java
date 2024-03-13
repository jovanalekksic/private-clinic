/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Jovana
 */
public class Racun extends ApstraktniObjekat implements Serializable{
    private Long racunId;
    private double  ukupanIznos;
    private Pacijent pacijent;
    private Date datum;
    
    private ArrayList<Stavka> lista;

    public Racun() {
    }

    public Racun(Long racunId, double ukupanIznos, Pacijent pacijent, Date datum) {
        this.racunId = racunId;
        this.ukupanIznos = ukupanIznos;
        this.pacijent = pacijent;
        this.datum=datum;
    }

    public Pacijent getPacijent() {
        return pacijent;
    }

    public void setPacijent(Pacijent pacijent) {
        this.pacijent = pacijent;
    }

    public Long getRacunId() {
        return racunId;
    }

    public void setRacunId(Long racunId) {
        this.racunId = racunId;
    }

    public double getUkupanIznos() {
        return ukupanIznos;
    }

    public void setUkupanIznos(double ukupanIznos) {
        this.ukupanIznos = ukupanIznos;
    }

    public ArrayList<Stavka> getLista() {
        return lista;
    }

    public void setLista(ArrayList<Stavka> lista) {
        this.lista = lista;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }
    

    @Override
    public String vratiNazivTabele() {
        return "racun";
    }

    @Override
    public String alijas() {
        return "r";
    }

    @Override
    public String spajanje() {
        return "JOIN pacijent p using(pacijentId)";
    }

    @Override
    public ArrayList<ApstraktniObjekat> selectLista(ResultSet rs) throws SQLException {
        ArrayList<ApstraktniObjekat> lista=new ArrayList<>();
        while(rs.next()){
            Pacijent pacijent=new Pacijent(rs.getLong("pacijentId"), rs.getString("ime"), rs.getString("prezime"), rs.getInt("starost"), rs.getString("adresa"));
            Racun racun=new Racun(rs.getLong("racunId"), rs.getDouble("ukupanIznos"), pacijent,rs.getTimestamp("datum"));
            lista.add(racun);
        }
        rs.close();
        return lista;
    }

    @Override
    public String koloneZaInsert() {
        return "(ukupanIznos, pacijentId, datum)";
    }

    @Override
    public String primarniKljuc() {
        return "racunId="+racunId;
    }

    @Override
    public String vrednostiZaInsert() {
        return ukupanIznos+","+pacijent.getPacijentId()+",'"+new Timestamp(datum.getTime())+"'";
    }

    @Override
    public String vrednostiZaUpdate() {
        return " datum='"+new Timestamp(datum.getTime())+"'";
    }

    @Override
    public String id() {
        return "racunId="+racunId;
    }
    
    
}
