/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.doktor;

import baza.DBBroker;
import domain.ApstraktniObjekat;
import domain.Doktor;
import java.sql.SQLException;
import java.util.ArrayList;
import so.ApstraktnaSO;

/**
 *
 * @author Jovana
 */
public class SOVratiDoktore extends ApstraktnaSO{

    ArrayList<Doktor> lista;

    public ArrayList<Doktor> getLista() {
        return lista;
    }
    
    @Override
    protected void validate(ApstraktniObjekat ao) throws Exception {
    }

    @Override
    protected void execute(ApstraktniObjekat ao) throws SQLException {
        ArrayList<ApstraktniObjekat> doktori=DBBroker.getInstance().selectBezUslova(ao);
        lista=(ArrayList<Doktor>)(ArrayList<?>) doktori;
    }
    
}
