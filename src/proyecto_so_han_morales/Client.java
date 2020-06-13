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
    
    private final int id;
    private int productos = 0;
    private int monto = 0;
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
                    
        // Ejecuta los consumidores
        try {

            //El cliente al llegar se encuentra automaticamente en espera
            Gama.clientesEspera = Gama.clientesEspera + 1;

            // Solicita entrar al supermecado con un carrito
            SCC.acquire();
            System.out.println("El cliente " + this.id + " ha entrado al Gama");

            //Una vez se le otorga permiso de acceso al cliente, el mismo ya
            //no se encuentra en espera, se vuelve un cliente activo
            Gama.clientesEspera = Gama.clientesEspera - 1;
            Gama.clientesActivos = Gama.clientesActivos + 1;

            // El cliente tiene que recorrer todos los estantes disponibles
            for (int i = 0; i < Gama.estante.length; i++) {

                // Se valida que el estante existe antes de proceder
                if (Gama.estante[i] != null) {

                    // Los cinco minutos que tarda en llegar al estante
                    this.sleep(300 * 1000);
                    System.out.println("El cliente " + this.id + " ha llegado al estante " + Gama.estante[i].getId());

                    // Verifica si existen productos en el estante
                    int productosDisponibles = SCE[i].availablePermits();
                    int productosComprar;

                    if (productosDisponibles == 1) {

                        // Si existe 1 solo producto, se llevara uno solo o ninguno
                        productosComprar = (int) (Math.random() * 2);

                    } else {

                        // Sino elige libremente cuantos quiere
                        productosComprar = (int) (Math.random() * 3);

                    }

                    // Verifica si existen productos en el estante y solicita retirarlas
                    // Si no hay productos, espera hasta que el empleado introduzca mas
                    this.SCE[i].acquire(productosComprar);

                    // Seccion critica
                    this.SEME[i].acquire();

                    // El cliente tarda un minuto en adquirir todos sus productos
                    this.sleep(60 * 1000);
                    productos += productosComprar;

                    for (int j = 0; j < productosComprar; j++) {

                        // Se suma el monto de cada producto y se mueve el apuntador del cliente en el buffer
                        monto += Gama.estante[i].getProducto(Gama.pCE[i]);
                        Gama.estante[i].setProducto(Gama.pCE[i], 0);
                        Gama.pCE[i] = (Gama.pCE[i] + 1) % Gama.estante[i].getCapacidad();

                    }

                    System.out.println("El cliente " + this.id + " ha adquirido " + productosComprar + " productos en el estante " + Gama.estante[i].getId());

                    // Seccion de salida en cada estante
                    this.SEME[i].release();
                    // Notifica que hay tantos puestos vacios como productos llevo en el estante
                    this.SEE[i].release(productosComprar);

                }

            }

            // Ya con todos los productos, se dirige a la caja registradora
            // Se suma lo que consumio el cliente con las ganancias
            Gama.ganancias += monto;

            // Seccion de salida
            SCC.release();
            System.out.println("El cliente " + this.id + " se ha retirado del supermercado");
            Gama.clientesActivos--;

        } catch (InterruptedException e) {

            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, e);

        }
        
    }
    
    
    // GETTERS Y SETTERS

    public int getProductos() {
        return productos;
    }

    public void setProductos(int productos) {
        this.productos = productos;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    
}
