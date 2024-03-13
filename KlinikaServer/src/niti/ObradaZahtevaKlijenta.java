/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package niti;

import domain.Doktor;
import domain.Pacijent;
import domain.Pregled;
import domain.Racun;
import domain.Usluga;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import konstante.Operacija;
import konstante.StatusOdgovora;
import logika.KontrolerServer;
import transfer.KlijentskiZahtev;
import transfer.ServerskiOdgovor;

/**
 *
 * @author Jovana
 */
public class ObradaZahtevaKlijenta extends Thread{
    private Socket socket;

    public ObradaZahtevaKlijenta(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            while(!isInterrupted()){
                
                ObjectInputStream ois=new ObjectInputStream(socket.getInputStream());
                KlijentskiZahtev zahtev=(KlijentskiZahtev) ois.readObject();
                ServerskiOdgovor odgovor=obradiZahtev(zahtev);
                ObjectOutputStream oos=new ObjectOutputStream(socket.getOutputStream());
                oos.writeObject(odgovor);
            }
        } catch (Exception ex) {
            Logger.getLogger(ObradaZahtevaKlijenta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private ServerskiOdgovor obradiZahtev(KlijentskiZahtev zahtev) {
        ServerskiOdgovor odgovor=new ServerskiOdgovor(null, null, StatusOdgovora.Uspesno);
        try {
            
            switch (zahtev.getOparacija()) {
                case Operacija.SACUVAJ_PACIJENTA:
                    KontrolerServer.getInstance().sacuvajPacijenta((Pacijent)zahtev.getObjekat());
                    break;
                case Operacija.SACUVAJ_DOKTORA:
                    KontrolerServer.getInstance().sacuvajDoktora((Doktor)zahtev.getObjekat());
                    break;
                case Operacija.IZMENI_DOKTORA:
                    KontrolerServer.getInstance().izmeniDoktora((Doktor)zahtev.getObjekat());
                    break;
                case Operacija.VRATI_USLUGE:
                    ArrayList<Usluga> usluge=KontrolerServer.getInstance().vratiUsluge();
                    odgovor.setObjekat(usluge);
                    break;
                case Operacija.VRATI_DOKTORE:
                    ArrayList<Doktor> doktori=KontrolerServer.getInstance().vratiDoktore();
                    odgovor.setObjekat(doktori);
                    break;
                case Operacija.VRATI_PACIJENTE:
                    ArrayList<Pacijent> pacijenti=KontrolerServer.getInstance().vratiPacijente();
                    odgovor.setObjekat(pacijenti);
                    break;
                case Operacija.IZMENI_PACIJENTA:
                    KontrolerServer.getInstance().izmeniPacijenta((Pacijent)zahtev.getObjekat());
                    break;
                case Operacija.VRATI_RACUNE:
                    ArrayList<Racun> racuni=KontrolerServer.getInstance().vratiRacune(); 
                    odgovor.setObjekat(racuni);
                    break;
                case Operacija.SACUVAJ_RACUN:
                    KontrolerServer.getInstance().sacuvajRacun((Racun)zahtev.getObjekat());
                    break;
                case Operacija.IZMENI_RACUN:
                    KontrolerServer.getInstance().izmeniRacun((Racun)zahtev.getObjekat());
                    break;
                case Operacija.VRATI_RACUN:
                    ArrayList<Racun> racun=KontrolerServer.getInstance().vratiRacun((Racun)zahtev.getObjekat());
                    odgovor.setObjekat(racun);
                    break;
                case Operacija.SACUVAJ_PREGLED:
                    KontrolerServer.getInstance().sacuvajPregled((Pregled)zahtev.getObjekat());
                    break;
                case Operacija.OBRISI_RACUN:
                    KontrolerServer.getInstance().obrisiRacun((Racun)zahtev.getObjekat());
                    break;
                case Operacija.VRATI_PREGLEDE:
                    ArrayList<Pregled> pregledi=KontrolerServer.getInstance().vratiPreglede();
                    odgovor.setObjekat(pregledi);
                    break;
                default:
                    return null;
            }
            
            
        } catch (Exception ex) {
            odgovor.setGreska(ex);
            odgovor.setStatusOdgovora(StatusOdgovora.Greska);
        }
        return odgovor;
    }
    
    
}
