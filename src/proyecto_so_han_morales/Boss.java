/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_so_han_morales;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Boss extends Thread {
    
    private int sleepTime = 10000;
    private int elapsed = 0;
    Semaphore SHL; // Semaforo de las horas laboradas
    
    public Boss(int sleepTime, Semaphore SHL) {
        
        this.sleepTime = sleepTime;
        this.SHL = SHL;
        
    }
    
    
    @Override
    public void run() {
        
        while(true) {
            
            try {
                
                // El manager dormira una hora de trabajo
                this.sleep(Gama.tiempoHora-elapsed);
                
                // Pasada la hora, aumenta el contador
                // Lo que tarda en aumentar el contador
                this.sleep(((Gama.tiempoHora/2) + (Gama.tiempoHora))/60);
                Gama.horasLaboradas++;
                System.out.println("El jefe ha aumentado el contador de horas a " + Gama.horasLaboradas);
                
                // Se muestra en pantalla y se aumenta un permiso al semaforo de las horas
                this.SHL.release();
                Interfaz.txtHours.setText(Integer.toString(Gama.horasLaboradas));
                
                // Tiempo que tardo en aumentar el contador de horas
                this.elapsed = (((Gama.tiempoHora/2) + (Gama.tiempoHora))/60);
                
            } catch (InterruptedException ex) {
                
                Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
                
            }
            
        }
        
    }
    
}
