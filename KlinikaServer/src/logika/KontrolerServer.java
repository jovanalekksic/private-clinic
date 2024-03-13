/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logika;

import domain.Doktor;
import domain.Pacijent;
import domain.Pregled;
import domain.Racun;
import domain.Usluga;
import java.util.ArrayList;
import so.doktor.SOIzmeniDoktora;
import so.pacijent.SOIzmeniPacijenta;
import so.racun.SOIzmeniRacun;
import so.racun.SOObrisiRacun;
import so.doktor.SOSacuvajDoktora;
import so.pacijent.SOSacuvajPacijenta;
import so.pregled.SOSacuvajPregled;
import so.racun.SOSacuvajRacun;
import so.doktor.SOVratiDoktore;
import so.pacijent.SOVratiPacijente;
import so.pregled.SOVratiPreglede;
import so.racun.SOVratiRacun;
import so.racun.SOVratiRacune;
import so.usluga.SOVratiUsluge;

/**
 *
 * @author Jovana
 */
public class KontrolerServer {
    private static KontrolerServer instance;

    public KontrolerServer() {
    }

    public static KontrolerServer getInstance() {
        if(instance==null){
            instance=new KontrolerServer();
        }
        return instance;
    }

    public void sacuvajPacijenta(Pacijent pacijent) throws Exception {
        SOSacuvajPacijenta so=new SOSacuvajPacijenta();
        so.templateExecute(pacijent);
    }

    public void sacuvajDoktora(Doktor doktor) throws Exception {
        SOSacuvajDoktora so=new SOSacuvajDoktora();
        so.templateExecute(doktor);
    }

    public ArrayList<Usluga> vratiUsluge() throws Exception {
        SOVratiUsluge so=new SOVratiUsluge();
        so.templateExecute(new Usluga());
        return so.getLista();
    }

    public ArrayList<Doktor> vratiDoktore() throws Exception {
        SOVratiDoktore so=new SOVratiDoktore();
        so.templateExecute(new Doktor());
        return  so.getLista();
    }

    public ArrayList<Pacijent> vratiPacijente() throws Exception {
        SOVratiPacijente so=new SOVratiPacijente();
        so.templateExecute(new Pacijent());
        return so.getLista();
    }

    public void izmeniPacijenta(Pacijent pacijent) throws Exception {
        SOIzmeniPacijenta so=new SOIzmeniPacijenta();
        so.templateExecute(pacijent);
    }

    public ArrayList<Racun> vratiRacune() throws Exception {
        SOVratiRacune so=new SOVratiRacune();
        so.templateExecute(new Racun());
        return so.getLista();
    }

    public void sacuvajRacun(Racun racun) throws Exception {
        SOSacuvajRacun so=new SOSacuvajRacun();
        so.templateExecute(racun);
    }

    public void izmeniRacun(Racun racun) throws Exception {
        SOIzmeniRacun so=new SOIzmeniRacun();
        so.templateExecute(racun);
    }

    public ArrayList<Racun> vratiRacun(Racun racun) throws Exception {
        SOVratiRacun so=new SOVratiRacun();
        so.templateExecute(racun);
        return so.getLista();
    }

    public void sacuvajPregled(Pregled pregled) throws Exception {
        SOSacuvajPregled so=new SOSacuvajPregled();
        so.templateExecute(pregled);
    }

    public void obrisiRacun(Racun racun) throws Exception {
        SOObrisiRacun so=new SOObrisiRacun();
        so.templateExecute(racun);
    }

    public ArrayList<Pregled> vratiPreglede() throws Exception {
        SOVratiPreglede so=new SOVratiPreglede();
        so.templateExecute(new Pregled());
        return  so.getLista();
    }

    public void izmeniDoktora(Doktor doktor) throws Exception {
        SOIzmeniDoktora so=new SOIzmeniDoktora();
        so.templateExecute(doktor);
    }
    
    
    
}
