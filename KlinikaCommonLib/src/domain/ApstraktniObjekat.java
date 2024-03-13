/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Jovana
 */
public abstract class ApstraktniObjekat implements Serializable{
    public abstract String vratiNazivTabele();
    public abstract String alijas();
    public abstract String spajanje();
    public abstract ArrayList<ApstraktniObjekat> selectLista(ResultSet rs) throws SQLException;
    public abstract String koloneZaInsert();
    public abstract String primarniKljuc();
    public abstract String vrednostiZaInsert();
    public abstract String vrednostiZaUpdate();
    public abstract String id();
}
