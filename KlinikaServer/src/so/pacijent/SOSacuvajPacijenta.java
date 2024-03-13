/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.pacijent;

import baza.DBBroker;
import domain.ApstraktniObjekat;
import domain.Pacijent;
import java.sql.SQLException;
import so.ApstraktnaSO;

/**
 *
 * @author Jovana
 */
public class SOSacuvajPacijenta extends ApstraktnaSO{

    @Override
    protected void validate(ApstraktniObjekat ao) throws Exception {
        Pacijent pacijent=(Pacijent) ao;
        if(pacijent.getIme()==null || pacijent.getPrezime()==null || pacijent.getStarost()==0 || pacijent.getAdresa()==null){
            throw new Exception("Polja moraju biti popunjena");
        }
    }

    @Override
    protected void execute(ApstraktniObjekat ao) throws SQLException {
        DBBroker.getInstance().insert(ao);
    }
    
}
