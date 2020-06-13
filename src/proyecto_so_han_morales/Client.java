package proyecto_so_han_morales;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Client extends Thread {

    // El cliente seria el consumidor en el problema productor-consumidor
    // ATRIBUTOS DE LA CLASE
    // Declaracion de los semaforos
    private final Semaphore[] SEME;  // Exclusion mutua de los estantes
    private final Semaphore[] SEE;   // Empleados de los estantes
    private final Semaphore[] SCE;   // Clientes de los estantes
    private final Semaphore SCCR;  // Clientes de las cajas registradoras
    private final Semaphore SCC;   // De los carritos de compra

    private final int id;
    private int productos = 0;
    private int monto = 0;
    private boolean activo = true; // Para saber si esta dentro del sistema
    private boolean eliminarCarrito = false;

    public Client(Semaphore[] SEME, Semaphore[] SEE, Semaphore[] SCE, Semaphore SCCR, Semaphore SCC, int id) {
        this.SEME = SEME;
        this.SEE = SEE;
        this.SCE = SCE;
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
            Interfaz.txtClientsWaiting.setText(Integer.toString(Gama.clientesEspera));

            // Solicita entrar al supermecado con un carrito
            SCC.acquire();
            System.out.println("El cliente " + this.id + " ha entrado al Gama");

            //Una vez se le otorga permiso de acceso al cliente, el mismo ya
            //no se encuentra en espera, se vuelve un cliente activo
            Gama.clientesEspera = Gama.clientesEspera - 1;
            Interfaz.txtClientsWaiting.setText(Integer.toString(Gama.clientesEspera));
            Gama.clientesActivos = Gama.clientesActivos + 1;
            Interfaz.txtClientsActive.setText(Integer.toString(Gama.clientesActivos));

            // El cliente tiene que recorrer todos los estantes disponibles
            for (int i = 0; i < Gama.estante.length; i++) {

                // Se valida que el estante existe antes de proceder
                if (Gama.estante[i] != null) {

                    // Los cinco minutos que tarda en llegar al estante
                    //this.sleep(300*1000);
                    this.sleep((5 * Gama.tiempoHora) / 60);
                    System.out.println("El cliente " + this.id + " ha llegado al estante " + Gama.estante[i].getId() + " , "
                            + "esta observando para entrar");

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
                    System.out.println("El cliente " + id + " se encuentra buscando productos en el estante " + Gama.estante[i].getId());

                    // El cliente tarda un minuto en adquirir todos sus productos
                    //this.sleep(60 * 1000);
                    this.sleep(Gama.tiempoHora / 60);
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
            // Pero debe elegir la caja registradora mas cercana o mas conveniente
            this.SCCR.acquire();

            // Se revisa si el cajero actualmente apuntado esta ocupado y se busca uno disponible
            while (!Gama.cashiers[Gama.pCR].getEstatus()) {

                Gama.pCR = (Gama.pCR + 1) % Gama.cajeros;

            }

            // Una vez que consigue uno disponible, lo solicita
            Gama.cashiers[Gama.pCR].getSC().acquire();
            Gama.cashiers[Gama.pCR].setEstatus(false);

//            int cajeroConMenorCola = 0;
//            int clientesEnLaCola = 999;
//            for(int i = 0; i < Gama.cajeros; i++){
//                    
//                if(Gama.cashiers[i].getEstatus() == true){
//                
//                    cajeroConMenorCola = i;
//                    break;
//                    
//                } else {
//                
//                    if(Gama.cashiers[i].getClientesEsperando() < clientesEnLaCola){
//                    
//                        clientesEnLaCola = Gama.cashiers[i].getClientesEsperando();
//                        cajeroConMenorCola = i;
//                    
//                    }
//                    
//                    if(i == Gama.cajeros - 1){
//
//                        //Quiere decir que todos los cajeros estan ocupados
//                        Gama.cashiers[cajeroConMenorCola].setClientesEsperando(Gama.cashiers[cajeroConMenorCola].getClientesEsperando()+1);
//                        
//                    }
//                    
//                }
//                
//            }
//            this.colocarTotalProductos(Gama.cashiers[cajeroConMenorCola], productos, cajeroConMenorCola + 1);
            this.colocarTotalProductos(Gama.cashiers[Gama.pCR], productos, Gama.pCR + 1);

//            // Se suma lo que consumio el cliente con las ganancias
//            Gama.ganancias += monto;
//            Interfaz.txtEarnings.setText(Integer.toString(Gama.ganancias));
            // Seccion de salida
//            if(!Gama.deseoEliminarCarritoEnUso){
//                
//                SCC.release();
//                System.out.println("El cliente " + this.id + " se ha retirado del supermercado");
//                Gama.clientesActivos--;
//                Interfaz.txtClientsActive.setText(Integer.toString(Gama.clientesActivos));
//                
//            }else{
            SCC.release();
            System.out.println("El cliente " + this.id + " se ha retirado del supermercado y su carrito ha sido guardado.");
            Gama.clientesActivos--;
            Gama.carritos = Gama.carritos--;
            Interfaz.txtClientsActive.setText(Integer.toString(Gama.clientesActivos));
            Interfaz.txtShoppingCarts.setText(Integer.toString(Gama.carritos));
            //Gama.deseoEliminarCarritoEnUso = false;
            //JOptionPane.showMessageDialog(null, "Función eliminar reestablecida");

//            }
        } catch (InterruptedException e) {

            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, e);

        }

    }

    public void colocarTotalProductos(Cashier cashier, int productos, int idCajero) throws InterruptedException {

        System.out.println("El cliente " + id + " ha elegido la caja registradora " + idCajero);

        for (int i = 0; i < productos; i++) {

//            cashier.atenderCliente();
            this.sleep(Gama.tiempoHora / (2 * 60));//Tiempo que tarda cliente en sacar un producto y colocarlo en el mostrador
            System.out.println("El cliente " + id + " ha colocado un producto sobre el cajero " + idCajero);
            cashier.procesarProducto(idCajero);

        }

        cashier.despacharCliente(idCajero, monto);

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

    public boolean isEliminarCarrito() {
        return eliminarCarrito;
    }

    public void setEliminarCarrito(boolean eliminarCarrito) {
        this.eliminarCarrito = eliminarCarrito;
    }

}
