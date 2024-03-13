/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.pacijent;

import baza.DBBroker;
import domain.ApstraktniObjekat;
import domain.Pacijent;
import java.sql.SQLException;
import java.util.ArrayList;
import so.ApstraktnaSO;

/**
 *
 * @author Jovana
 */
public class SOVratiPacijente extends ApstraktnaSO{

    ArrayList<Pacijent> lista;

    public ArrayList<Pacijent> getLista() {
        return lista;
    }
    
    @Override
    protected void validate(ApstraktniObjekat ao) throws Exception {
    }

    @Override
    protected void execute(ApstraktniObjekat ao) throws SQLException {
        ArrayList<ApstraktniObjekat> pacijenti=DBBroker.getInstance().selectBezUslova(ao);
        lista=(ArrayList<Pacijent>)(ArrayList<?>) pacijenti;
    }
    
}
