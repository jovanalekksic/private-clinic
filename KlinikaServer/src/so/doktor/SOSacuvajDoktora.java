/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.doktor;

import baza.DBBroker;
import domain.ApstraktniObjekat;
import domain.Doktor;
import java.sql.SQLException;
import so.ApstraktnaSO;

/**
 *
 * @author Jovana
 */
public class SOSacuvajDoktora extends ApstraktnaSO{

    @Override
    protected void validate(ApstraktniObjekat ao) throws Exception {
        Doktor doktor=(Doktor) ao;
        if(doktor.getIme()==null || doktor.getPrezime()==null || doktor.getSpecijalizacija()==null){
            throw new Exception("Polja moraju biti popunjena");
        }
    }

    @Override
    protected void execute(ApstraktniObjekat ao) throws SQLException {
        DBBroker.getInstance().insert(ao);
    }
    
}
