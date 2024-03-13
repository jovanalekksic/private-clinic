/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.pregled;

import baza.DBBroker;
import domain.ApstraktniObjekat;
import domain.Pregled;
import java.sql.SQLException;
import so.ApstraktnaSO;

/**
 *
 * @author Jovana
 */
public class SOSacuvajPregled extends ApstraktnaSO{

    @Override
    protected void validate(ApstraktniObjekat ao) throws Exception {
        Pregled pregled=(Pregled) ao;
        if(pregled.getPacijent()==null || pregled.getDoktor()==null || pregled.getUsluga()==null){
            throw new Exception("Sistem ne moze da zapamti pregled");
        }
    }

    @Override
    protected void execute(ApstraktniObjekat ao) throws SQLException {
        DBBroker.getInstance().insert(ao);
    }
    
}
