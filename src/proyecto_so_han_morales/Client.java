package proyecto_so_han_morales;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Client extends Thread{
    
    // El cliente seria el consumidor en el problema productor-consumidor
    
    // ATRIBUTOS DE LA CLASE
    
    // Semaforos (EM = exclusion mutua, E = empleado, C = cliente)
    private Semaphore SEME, SEE, SCE; // De los estantes
    private Semaphore SEMCR, SECR, SCCR; // De las cajas registradoras 
    private Semaphore SCC; // De los carritos de compra
    
    private int id;
    private int productos;
    private int monto;
    private Gama gama;
    private boolean activo = true; // Para saber si esta dentro del sistema
    
    public Client (){
    }
    
    /*
     * Metodo para iniciar el hilo
    */
    @Override
    public void run() {
        
        while (true) {
            
            // Ejecuta los consumidores
            try {
                
                // Solicita entrar al supermecado con un carrito
                SCC.acquire();
                
                // El cliente tiene que recorrer todos los estantes disponibles
                // Imaginaqueaquiseiteranlosestantes
                
                    // Los cinco minutos que tarda en llegar al estante
                    Thread.sleep(5000);
                
                    // Verifica si existen productos en el estante
                    int productosDisponibles = SEE.availablePermits();
                    int productosComprar;
                
                    if (productosDisponibles == 1) {
                    
                        // Si existe 1 solo producto, se llevara uno solo
                        productosComprar = productosDisponibles;
                    
                    } else {
                    
                        // Sino elige libremente cuantos quiere
                        productosComprar = (int) (Math.random() * 3); 
                        
                    }
                 
                    // Verifica si existen productos en el estante y solicita retirarlas
                    // Si no hay productos, espera hasta que el empleado introduzca mas
                    this.SEE.acquire(productosComprar);
                    this.SEME.acquire();
                
                    // El cliente tarda un minuto en adquirir todos sus productos
                    Thread.sleep(1000);
                    
                    
                    
                
                
            } catch (InterruptedException e) {
                
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, e);
                
            }
            
        }
        
    }

    
}
