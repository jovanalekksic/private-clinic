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
public class Pacijent extends ApstraktniObjekat implements Serializable{
    private Long pacijentId;
    private String ime;
    private String prezime;
    private int starost;
    private String adresa;

    public Pacijent() {
    }

    public Pacijent(Long pacijentId, String ime, String prezime, int starost, String adresa) {
        this.pacijentId = pacijentId;
        this.ime = ime;
        this.prezime = prezime;
        this.starost = starost;
        this.adresa = adresa;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public Long getPacijentId() {
        return pacijentId;
    }

    public void setPacijentId(Long pacijentId) {
        this.pacijentId = pacijentId;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public int getStarost() {
        return starost;
    }

    public void setStarost(int starost) {
        this.starost = starost;
    }

    @Override
    public String vratiNazivTabele() {
        return "pacijent";
    }

    @Override
    public String alijas() {
        return "pa";
    }

    @Override
    public String spajanje() {
        return "";
    }

    @Override
    public ArrayList<ApstraktniObjekat> selectLista(ResultSet rs) throws SQLException {
        ArrayList<ApstraktniObjekat> lista=new ArrayList<>();
        while(rs.next()){
            Pacijent pacijent=new Pacijent(rs.getLong("pacijentId"), rs.getString("ime"), rs.getString("prezime"), rs.getInt("starost"), rs.getString("adresa"));
            lista.add(pacijent);
        }
        rs.close();
        return lista;
    }

    @Override
    public String koloneZaInsert() {
        return "(ime, prezime, starost, adresa)";
    }

    @Override
    public String primarniKljuc() {
        return "pacijentId="+pacijentId;
    }

    @Override
    public String vrednostiZaInsert() {
        return "'"+ime+"','"+prezime+"',"+starost+",'"+adresa+"'";
    }

    @Override
    public String vrednostiZaUpdate() {
        return "ime='"+ime+"',prezime='"+prezime+"', starost="+starost+", adresa='"+adresa+"'";
    }

    @Override
    public String id() {
        return "pacijentId="+pacijentId;
    }

    @Override
    public String toString() {
        return ime+" "+prezime;
    }
    
    
}
