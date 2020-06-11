package proyecto_so_han_morales;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Client extends Thread{
    
    // El cliente seria el consumidor en el problema productor-consumidor
    
    // ATRIBUTOS DE LA CLASE
    
    // Declaracion de los semaforos
    private final Semaphore[] SEME;  // Exclusion mutua de los estantes
    private final Semaphore[] SEE;   // Empleados de los estantes
    private final Semaphore[] SCE;   // Clientes de los estantes
    private final Semaphore SEMCR; // Exclusion mutua de las cajas registradoras
    private final Semaphore SECR;  // Empleados de las cajas registradoras 
    private final Semaphore SCCR;  // Clientes de las cajas registradoras
    private final Semaphore SCC;   // De los carritos de compra
    
    private int id;
    private int productos = 0;
    private int monto = 0;
    private Gama gama;
    private boolean activo = true; // Para saber si esta dentro del sistema

    public Client(Semaphore[] SEME, Semaphore[] SEE, Semaphore[] SCE, Semaphore SEMCR, Semaphore SECR, Semaphore SCCR, Semaphore SCC, int id) {
        this.SEME = SEME;
        this.SEE = SEE;
        this.SCE = SCE;
        this.SEMCR = SEMCR;
        this.SECR = SECR;
        this.SCCR = SCCR;
        this.SCC = SCC;
        this.id = id;
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
                System.out.println("El cliente " + this.id + "ha entrado al Gama");
                
                // El cliente tiene que recorrer todos los estantes disponibles
                for (int i = 0; i < Gama.estante.length; i++) {
                    
                    // Se valida que el estante existe antes de proceder
                    if (Gama.estante[i] != null) {
                        
                        // Los cinco minutos que tarda en llegar al estante
                        this.sleep(5000);
                        System.out.println("El cliente " + this.id + "ha llegado al estante " + 1);
                
                        // Verifica si existen productos en el estante
                        int productosDisponibles = SEE[i].availablePermits();
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
                        this.SEE[i].acquire(productosComprar);
                        this.SEME[i].acquire();
                
                        // El cliente tarda un minuto en adquirir todos sus productos
                        this.sleep(1000);
                        System.out.println("El cliente " + this.id + "ha adquirido " + productosComprar + " productos");                 
                        
                    }
                    
                }
                    
                // Ya con todos los productos, se dirige a la caja registradora
                
                    
                    
                
                
            } catch (InterruptedException e) {
                
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, e);
                
            }
            
        }
        
    }

    
}
