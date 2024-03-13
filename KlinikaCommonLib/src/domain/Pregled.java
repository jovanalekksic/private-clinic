/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.io.Serializable;
import java.sql.Timestamp;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Jovana
 */
public class Pregled extends ApstraktniObjekat implements Serializable{
    private Long pregledId;
    private Pacijent pacijent;
    private Doktor doktor;
    private Usluga usluga;
    private Date datumPregleda;

    public Pregled() {
    }

    public Pregled(Long pregledId, Pacijent pacijent, Doktor doktor, Usluga usluga, Date datumPregleda) {
        this.pregledId = pregledId;
        this.pacijent = pacijent;
        this.doktor = doktor;
        this.usluga = usluga;
        this.datumPregleda = datumPregleda;
    }

    

    public Date getDatumPregleda() {
        return datumPregleda;
    }

    public void setDatumPregleda(Date datumPregleda) {
        this.datumPregleda = datumPregleda;
    }

    public Long getPregledId() {
        return pregledId;
    }

    public void setPregledId(Long pregledId) {
        this.pregledId = pregledId;
    }

    public Pacijent getPacijent() {
        return pacijent;
    }

    public void setPacijent(Pacijent pacijent) {
        this.pacijent = pacijent;
    }

    public Doktor getDoktor() {
        return doktor;
    }

    public void setDoktor(Doktor doktor) {
        this.doktor = doktor;
    }

    public Usluga getUsluga() {
        return usluga;
    }

    public void setUsluga(Usluga usluga) {
        this.usluga = usluga;
    }
    

    @Override
    public String vratiNazivTabele() {
        return "pregled";
    }

    @Override
    public String alijas() {
        return "pr";
    }

    @Override
    public String spajanje() {
        return " JOIN pacijent p using(pacijentId)"
                + " JOIN doktor d using(doktorId)"
                + " JOIN usluga u using(uslugaId)";
    }

    @Override
    public ArrayList<ApstraktniObjekat> selectLista(ResultSet rs) throws SQLException {
        ArrayList<ApstraktniObjekat> lista=new ArrayList<>();
        while(rs.next()){
            Pacijent pacijent=new Pacijent(rs.getLong("pacijentId"), rs.getString("ime"), rs.getString("prezime"), rs.getInt("starost"), rs.getString("adresa"));
            Doktor doktor=new Doktor(rs.getLong("doktorId"), rs.getString("imeD"), rs.getString("prezimeD"), rs.getString("specijalizacija"));
            Usluga usluga=new Usluga(rs.getLong("uslugaId"), rs.getString("naziv"), rs.getInt("cena"));
            Pregled pregled=new Pregled(rs.getLong("pregledId"), pacijent, doktor,usluga, rs.getTimestamp("datumPregleda"));
            lista.add(pregled);
        }
        rs.close();
        return lista;
    }

    @Override
    public String koloneZaInsert() {
        return "(pacijentId, doktorId, uslugaId, datumPregleda)";
    }

    @Override
    public String primarniKljuc() {
        return "pregledId="+pregledId;
    }

    @Override
    public String vrednostiZaInsert() {
        return pacijent.getPacijentId()+","+doktor.getDoktorId()+","+usluga.getUslugaId()+",'"+new Timestamp(datumPregleda.getTime())+"'";
    }

    @Override
    public String vrednostiZaUpdate() {
        return "pacijentId="+pacijent.getPacijentId()+", doktorId="+doktor.getDoktorId()+", uslugaId="+usluga.getUslugaId()+", datumPregleda='"+new Timestamp(datumPregleda.getTime())+"'";
    }

    @Override
    public String id() {
        return "pregledId="+pregledId;
                
    }

    
    
}
