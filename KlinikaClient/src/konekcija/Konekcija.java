/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package konekcija;

import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jovana
 */
public class Konekcija {
    private static Konekcija instance;
    private Socket socket;

    public Konekcija() {
        try {
            socket=new Socket("localhost", 9000);
        } catch (IOException ex) {
            Logger.getLogger(Konekcija.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static Konekcija getInstance() {
        if(instance==null){
            instance=new Konekcija();
        }
        return instance;
    }

    public Socket getSocket() {
        return socket;
    }
    
    
    
    
}
