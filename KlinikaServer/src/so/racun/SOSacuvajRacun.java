/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.racun;

import baza.DBBroker;
import domain.ApstraktniObjekat;
import domain.Racun;
import domain.Stavka;
import java.sql.SQLException;
import java.sql.*;
import so.ApstraktnaSO;

/**
 *
 * @author Jovana
 */
public class SOSacuvajRacun extends ApstraktnaSO{

    @Override
    protected void validate(ApstraktniObjekat ao) throws Exception {
        Racun r=(Racun) ao;
        if(r.getLista().size()==0){
            throw new Exception("Racun mora da ima bar jednu stavku");
        }
    }

    @Override
    protected void execute(ApstraktniObjekat ao) throws SQLException {
        Racun r=(Racun) ao;
        PreparedStatement ps=DBBroker.getInstance().insert(ao);
        ResultSet rs=ps.getGeneratedKeys();
        rs.next();
        Long racunId=rs.getLong(1);
        r.setRacunId(racunId);
        
        for (Stavka stavkaRacuna : r.getLista()) {
            stavkaRacuna.setRacun(r);
            DBBroker.getInstance().insert(stavkaRacuna);
        }
    }
    
}
