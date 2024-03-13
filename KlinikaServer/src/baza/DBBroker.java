/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baza;

import domain.ApstraktniObjekat;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Jovana
 */
public class DBBroker {
    private static DBBroker instance;
    private static Connection konekcija;

    public DBBroker() {
        try {
            konekcija=DriverManager.getConnection("jdbc:mysql://localhost:3306/klinika", "root", "root");
            konekcija.setAutoCommit(false);
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static Connection getKonekcija() {
        return konekcija;
    }

    public static DBBroker getInstance() {
        if(instance==null){
            instance=new DBBroker();
        }
        return instance;
    }
    
    public ArrayList<ApstraktniObjekat> select(ApstraktniObjekat ao) throws SQLException{
        String upit="SELECT * FROM "+ao.vratiNazivTabele()+" "+ao.alijas()
                +" "+ao.spajanje()+" WHERE "+ao.id()+" ";
        System.out.println(upit);
        Statement s=konekcija.createStatement();
        ResultSet rs=s.executeQuery(upit);
        return ao.selectLista(rs);
    }
    
    
    public PreparedStatement insert(ApstraktniObjekat ao) throws SQLException{
        String upit="INSERT INTO "+ao.vratiNazivTabele()+" "
                +ao.koloneZaInsert()+" VALUES("+ao.vrednostiZaInsert()
                +")";
        System.out.println(upit);
        PreparedStatement ps=konekcija.prepareStatement(upit,Statement.RETURN_GENERATED_KEYS);
        ps.executeUpdate();
        return ps;
    }
    
    public void update(ApstraktniObjekat ao) throws SQLException{
        String upit="UPDATE "+ao.vratiNazivTabele()+" SET "
                +ao.vrednostiZaUpdate()+" WHERE "+ao.id();
        System.out.println(upit);
        Statement s=konekcija.createStatement();
        s.executeUpdate(upit);
    }
    
    public void delete(ApstraktniObjekat ao) throws SQLException{
        String upit="DELETE FROM "+ao.vratiNazivTabele()
                +" WHERE "+ao.id();
        System.out.println(upit);
        Statement s=konekcija.createStatement();
        s.executeUpdate(upit);
    }
    
    public ArrayList<ApstraktniObjekat> selectBezUslova(ApstraktniObjekat ao) throws SQLException{
        String upit="SELECT * FROM "+ao.vratiNazivTabele()+" "+ao.alijas()
                +" "+ao.spajanje();
        System.out.println(upit);
        Statement s=konekcija.createStatement();
        ResultSet rs=s.executeQuery(upit);
        return ao.selectLista(rs);
    }
    
    
    
    
}
