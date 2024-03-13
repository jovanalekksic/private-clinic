/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import baza.DBBroker;
import domain.ApstraktniObjekat;
import java.sql.SQLException;

/**
 *
 * @author Jovana
 */
public abstract class ApstraktnaSO {
    
    public void templateExecute(ApstraktniObjekat ao) throws  Exception{
        try{
            validate(ao);
            execute(ao);
            commit();
        }catch(Exception e){
            rollback();
            throw e;
        }
    }

    protected abstract void validate(ApstraktniObjekat ao) throws Exception;

    protected abstract void execute(ApstraktniObjekat ao) throws SQLException;

    private void commit() throws SQLException {
        DBBroker.getInstance().getKonekcija().commit();
    }

    private void rollback() throws SQLException {
        DBBroker.getInstance().getKonekcija().rollback();
    }
}
