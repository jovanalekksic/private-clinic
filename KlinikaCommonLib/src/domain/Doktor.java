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
public class Doktor extends ApstraktniObjekat implements Serializable{
    private Long doktorId;
    private String ime;
    private String prezime;
    private String specijalizacija;

    public Doktor() {
    }

    public Doktor(Long doktorId, String ime, String prezime, String specijalizacija) {
        this.doktorId = doktorId;
        this.ime = ime;
        this.prezime = prezime;
        this.specijalizacija = specijalizacija;
    }

    @Override
    public String toString() {
        return ime+" "+prezime+" - "+specijalizacija;
    }

    
    @Override
    public String vratiNazivTabele() {
        return "doktor";
    }

    @Override
    public String alijas() {
        return "d";
    }

    @Override
    public String spajanje() {
        return "";
    }

    @Override
    public ArrayList<ApstraktniObjekat> selectLista(ResultSet rs) throws SQLException {
        ArrayList<ApstraktniObjekat> lista=new ArrayList<>();
        while(rs.next()){
            Doktor doktor=new Doktor(rs.getLong("doktorId"), rs.getString("imeD"), rs.getString("prezimeD"), rs.getString("specijalizacija"));
            lista.add(doktor);
        }
        rs.close();
        return lista;
    }

    @Override
    public String koloneZaInsert() {
        return "(imeD, prezimeD, specijalizacija)";
    }

    @Override
    public String primarniKljuc() {
        return "doktorId="+doktorId;
    }

    @Override
    public String vrednostiZaInsert() {
        return "'"+ime+"','"+prezime+"','"+specijalizacija+"'";
    }

    @Override
    public String vrednostiZaUpdate() {
        return "imeD='"+ime+"', prezimeD='"+prezime+"',specijalizacija='"+specijalizacija+"'";
    }

    @Override
    public String id() {
        return "doktorId="+doktorId;
    }

    public Long getDoktorId() {
        return doktorId;
    }

    public void setDoktorId(Long doktorId) {
        this.doktorId = doktorId;
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

    public String getSpecijalizacija() {
        return specijalizacija;
    }

    public void setSpecijalizacija(String specijalizacija) {
        this.specijalizacija = specijalizacija;
    }
    
    
    
}
