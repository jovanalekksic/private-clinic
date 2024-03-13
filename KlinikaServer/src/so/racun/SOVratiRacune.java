/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.racun;

import baza.DBBroker;
import domain.ApstraktniObjekat;
import domain.Racun;
import java.sql.SQLException;
import java.util.ArrayList;
import so.ApstraktnaSO;

/**
 *
 * @author Jovana
 */
public class SOVratiRacune extends ApstraktnaSO{
    
    ArrayList<Racun> lista;

    public ArrayList<Racun> getLista() {
        return lista;
    }
    

    @Override
    protected void validate(ApstraktniObjekat ao) throws Exception {
    }

    @Override
    protected void execute(ApstraktniObjekat ao) throws SQLException {
        ArrayList<ApstraktniObjekat> racuni=DBBroker.getInstance().selectBezUslova(ao);
        lista=(ArrayList<Racun>)(ArrayList<?>)racuni;
    }
    
}
