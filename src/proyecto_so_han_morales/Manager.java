/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_so_han_morales;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Manager extends Thread {
    
    // El manager se encarga de reiniciar las horas laboradas y las ganancias
    Semaphore SHL; // Semaforo de las horas laboradas
    
    public Manager(Semaphore SHL) {
        this.SHL = SHL;
    }
    
    
    @Override
    public void run() {
        
        while(true) {
            
            try {
                
                // El manager espera a que se hayan laborado 8 horas para reiniciar
                this.SHL.acquire(8);
                
                // Se reinician ambos valores
                Gama.ganancias = 0;
                Gama.horasLaboradas = 0;
                
                Interfaz.txtEarnings.setText("0");
                Interfaz.txtHours.setText("0");
               
                System.out.println("El gerente ha reiniciado las horas y ganancias");
                
            } catch (InterruptedException ex) {
                
                Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
                
            }
            
        }
        
    }
    
}
