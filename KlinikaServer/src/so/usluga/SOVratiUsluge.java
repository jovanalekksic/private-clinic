/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.usluga;

import baza.DBBroker;
import domain.ApstraktniObjekat;
import domain.Usluga;
import java.sql.SQLException;
import java.util.ArrayList;
import so.ApstraktnaSO;

/**
 *
 * @author Jovana
 */
public class SOVratiUsluge extends ApstraktnaSO{
    
    ArrayList<Usluga> lista;

    public ArrayList<Usluga> getLista() {
        return lista;
    }

    @Override
    protected void validate(ApstraktniObjekat ao) throws Exception {
    }

    @Override
    protected void execute(ApstraktniObjekat ao) throws SQLException {
        ArrayList<ApstraktniObjekat> usluge=DBBroker.getInstance().selectBezUslova(ao);
        lista=(ArrayList<Usluga>)(ArrayList<?>) usluge;
    }
    
}
