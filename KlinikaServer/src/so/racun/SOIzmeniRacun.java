/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.racun;

import baza.DBBroker;
import domain.ApstraktniObjekat;
import java.sql.SQLException;
import so.ApstraktnaSO;

/**
 *
 * @author Jovana
 */
public class SOIzmeniRacun extends ApstraktnaSO{

    @Override
    protected void validate(ApstraktniObjekat ao) throws Exception {
    }

    @Override
    protected void execute(ApstraktniObjekat ao) throws SQLException {
        DBBroker.getInstance().update(ao);
    }
    
}
