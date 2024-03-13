/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.racun;

import baza.DBBroker;
import domain.ApstraktniObjekat;
import domain.Racun;
import domain.Stavka;
import java.sql.SQLException;
import so.ApstraktnaSO;

/**
 *
 * @author Jovana
 */
public class SOObrisiRacun extends ApstraktnaSO{

    @Override
    protected void validate(ApstraktniObjekat ao) throws Exception {
        Racun racun=(Racun) ao;
        if(racun.getPacijent()==null || racun.getUkupanIznos()==0 ){
            throw new Exception("Sistem ne moze da zapamti racun");
        }
    }

    @Override
    protected void execute(ApstraktniObjekat ao) throws SQLException {
        Racun racun=(Racun) ao;
        Stavka stavka=new Stavka();
        stavka.setRacun(racun);
        DBBroker.getInstance().delete(stavka);
        DBBroker.getInstance().delete(ao);
    }
    
}
