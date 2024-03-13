/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package transfer;

import java.io.Serializable;

/**
 *
 * @author Jovana
 */
public class KlijentskiZahtev implements Serializable{
    private int oparacija;
    private Object objekat;

    public KlijentskiZahtev() {
    }

    public KlijentskiZahtev(int oparacija, Object objekat) {
        this.oparacija = oparacija;
        this.objekat = objekat;
    }

    public Object getObjekat() {
        return objekat;
    }

    public void setObjekat(Object objekat) {
        this.objekat = objekat;
    }

    public int getOparacija() {
        return oparacija;
    }

    public void setOparacija(int oparacija) {
        this.oparacija = oparacija;
    }
    
}
