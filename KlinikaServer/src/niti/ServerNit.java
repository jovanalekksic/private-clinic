/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package niti;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jovana
 */
public class ServerNit extends Thread{
    
    private ServerSocket serverSocket;

    public ServerNit() {
        try {
            serverSocket=new ServerSocket(9000);
            
        } catch (IOException ex) {
            Logger.getLogger(ServerNit.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void run() {
        try {
            while(!isInterrupted()){
                System.out.println("Server je pokrenut!");
                Socket s=serverSocket.accept();
                System.out.println("Klijent se povezao!");
                ObradaZahtevaKlijenta ozk=new ObradaZahtevaKlijenta(s);
                ozk.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    
}
