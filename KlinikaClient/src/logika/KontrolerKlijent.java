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
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import konekcija.Konekcija;
import konstante.Operacija;
import konstante.StatusOdgovora;
import transfer.KlijentskiZahtev;
import transfer.ServerskiOdgovor;

/**
 *
 * @author Jovana
 */
public class KontrolerKlijent {
    private static KontrolerKlijent instance;

    public static KontrolerKlijent getInstance() {
        if(instance==null){
            instance=new KontrolerKlijent();
        }
        return instance;
    }
    
   
    
    private Object posaljiZahtev(int operacija, Object objekat) throws Exception{
        KlijentskiZahtev zahtev=new KlijentskiZahtev(operacija, objekat);
        ObjectOutputStream oos=new ObjectOutputStream(Konekcija.getInstance().getSocket().getOutputStream());
        oos.writeObject(zahtev);
        
        ObjectInputStream ois=new ObjectInputStream(Konekcija.getInstance().getSocket().getInputStream());
        ServerskiOdgovor odgovor=(ServerskiOdgovor) ois.readObject();
        if(odgovor.getStatusOdgovora().equals(StatusOdgovora.Greska)){
            throw  odgovor.getGreska();
        }else{
            return odgovor.getObjekat();
        }
        
    }
     public void sacuvajPacijenta(Pacijent p) throws Exception {
        posaljiZahtev(Operacija.SACUVAJ_PACIJENTA, p);
    }

    public void sacuvajDoktora(Doktor doktor) throws Exception {
        posaljiZahtev(Operacija.SACUVAJ_DOKTORA, doktor);
    }

    public ArrayList<Usluga> vratiUsluge() throws Exception {
        return (ArrayList<Usluga>) posaljiZahtev(Operacija.VRATI_USLUGE, null);
    }

    public ArrayList<Doktor> vratiDoktore() throws Exception {
        return (ArrayList<Doktor>) posaljiZahtev(Operacija.VRATI_DOKTORE, null);
    }

    public ArrayList<Pacijent> vratiPacijente() throws Exception {
        return (ArrayList<Pacijent>) posaljiZahtev(Operacija.VRATI_PACIJENTE, null);
    }

    public void izmeniPacijenta(Pacijent p) throws Exception {
        posaljiZahtev(Operacija.IZMENI_PACIJENTA, p);
    }

    public ArrayList<Racun> vratiRacune() throws Exception {
        return (ArrayList<Racun>) posaljiZahtev(Operacija.VRATI_RACUNE, null);
    }

    public void sacuvajRacun(Racun racun) throws Exception {
        posaljiZahtev(Operacija.SACUVAJ_RACUN, racun);
    }

    public void izmeniRacun(Racun racun) throws Exception {
        posaljiZahtev(Operacija.IZMENI_RACUN, racun);
    }

    public ArrayList<Racun> vratiRacun(Racun racun) throws Exception {
        return (ArrayList<Racun>) posaljiZahtev(Operacija.VRATI_RACUN, null);
    }

    public void sacuvajPregled(Pregled pregled) throws Exception {
        posaljiZahtev(Operacija.SACUVAJ_PREGLED, pregled);
    }

    public void obrisiRacun(Racun racun) throws Exception {
        posaljiZahtev(Operacija.OBRISI_RACUN, racun);
    }

    public ArrayList<Pregled> vratiPreglede() throws Exception {
        return (ArrayList<Pregled>) posaljiZahtev(Operacija.VRATI_PREGLEDE, null);
    }

    public void izmeniDoktora(Doktor doktor) throws Exception {
        posaljiZahtev(Operacija.IZMENI_DOKTORA, doktor);
    }

    
    
    
}
