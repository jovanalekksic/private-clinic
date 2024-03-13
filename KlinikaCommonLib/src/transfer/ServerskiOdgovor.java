/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package transfer;

import java.io.Serializable;
import konstante.StatusOdgovora;

/**
 *
 * @author Jovana
 */
public class ServerskiOdgovor implements Serializable{
    private Object objekat;
    private Exception greska;
    private StatusOdgovora statusOdgovora;

    public ServerskiOdgovor() {
    }

    public ServerskiOdgovor(Object objekat, Exception greska, StatusOdgovora statusOdgovora) {
        this.objekat = objekat;
        this.greska = greska;
        this.statusOdgovora = statusOdgovora;
    }

    public StatusOdgovora getStatusOdgovora() {
        return statusOdgovora;
    }

    public void setStatusOdgovora(StatusOdgovora statusOdgovora) {
        this.statusOdgovora = statusOdgovora;
    }

    public Object getObjekat() {
        return objekat;
    }

    public void setObjekat(Object objekat) {
        this.objekat = objekat;
    }

    public Exception getGreska() {
        return greska;
    }

    public void setGreska(Exception greska) {
        this.greska = greska;
    }
    
}
