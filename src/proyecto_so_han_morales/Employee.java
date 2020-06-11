package proyecto_so_han_morales;

import java.util.concurrent.Semaphore;
import javax.swing.JOptionPane;

public class Employee extends Thread {
    
    // El empleado es el productor en el problema de productor-consumidor
    
    // ATRIBUTOS DE LA CLASE
    
    // Semaforos (EM = exclusion mutua, E = empleado, C = cliente)
    private Semaphore SEME, SEE, SCE; // De los estantes
    
    private Gama gama;
    private boolean activo = true;
    
    public Employee() {
        
    }
    
    /*
     *  Metodo para llenar el estante
    */
    
    
    /*
     *  Metodo que inicia el hilo
    */
    @Override
    public void run() {
        
        while(activo) {
            
            try {
                
                this.sleep(4000); // Tiempo que tarda buscando la caja
                
            } catch (InterruptedException e) {
                
                JOptionPane.showMessageDialog(null, "ERROR", "Un empleado tuvo un error", JOptionPane.ERROR_MESSAGE);
                
            }
            
        }
        
    }
    
}
