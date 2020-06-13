package proyecto_so_han_morales;

import java.util.concurrent.Semaphore;
import javax.swing.JOptionPane;

public class Employee extends Thread {
    
    // El empleado es el productor en el problema de productor-consumidor
    
    // ATRIBUTOS DE LA CLASE
    
    // Semaforos (EM = exclusion mutua, E = empleado, C = cliente)
    private Semaphore SEME, SEE, SCE; // De los estantes
    private int id = -1;
    private Gama gama;
    private boolean activo = true;
    
    public Employee(int id, Semaphore SEME, Semaphore SEE, Semaphore SCE) {
        this.id = id;
        this.SEE = SEE;
        this.SCE = SCE;
        this.SEME = SEME;
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
                
                SEE.acquire(3);//Trata de adquirir 3 espacios para recargar el estante
                System.out.println("El empleado " + id +" se dirige al estante!");
                this.sleep(240*1000); // Tiempo que tarda buscando la caja para llevarla al estante
                
                SEME.acquire();//Adquiere el permiso total del estante
                System.out.println("El empleado " + id + " se encuentra en el estante");
                this.sleep(60*1000);//Tiempo que tarda en colocar los productos en el estante
                
                for (int i = 0; i < 3; i++) {
                            
                    // Se mueve el apuntador del empleado en el buffer y se llena con nuevos productos
                    int precio = (int) ((Math.random() * 10) + 1);
                    Gama.estante[id - 1].setProducto(Gama.pEE[id - 1], precio);
                    Gama.pEE[id - 1] = (Gama.pEE[id -1] + 1) % Gama.estante[id - 1].getCapacidad();
                            
                }
                
                SCE.release(3);  //Coloca 3 nuevos productos en el estante
                System.out.println("El empleado " + id + " ha colocado 3 nuevos productos en el estante");
                
                SEME.release();  //Libera el estante para que entren nuevos clientes
                System.out.println("El empleado " + id + " se ha retirado del estante");
                
                
            } catch (InterruptedException e) {
                
                JOptionPane.showMessageDialog(null, "ERROR", "Un empleado tuvo un error", JOptionPane.ERROR_MESSAGE);
                
            }
            
        }
        
    }
    
}
