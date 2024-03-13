/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.pregled;

import baza.DBBroker;
import domain.ApstraktniObjekat;
import domain.Pregled;
import java.sql.SQLException;
import java.util.ArrayList;
import so.ApstraktnaSO;

/**
 *
 * @author Jovana
 */
public class SOVratiPreglede extends ApstraktnaSO{
    
    ArrayList<Pregled> lista;

    public ArrayList<Pregled> getLista() {
        return lista;
    }

    @Override
    protected void validate(ApstraktniObjekat ao) throws Exception {
    }

    @Override
    protected void execute(ApstraktniObjekat ao) throws SQLException {
        ArrayList<ApstraktniObjekat> pregledi=DBBroker.getInstance().selectBezUslova(ao);
        lista=(ArrayList<Pregled>)(ArrayList<?>)pregledi;
    }
    
}
