/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_so_han_morales;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Cashier extends Thread{
    
    private boolean estatus = true;          //Variable que permite identificar si el cajero esta ocupado
    private int clientesEsperando = 0;       //Variable que identifica cuantos clientes estan haciendo cola en el cajero 
    private Semaphore SCCR;                  // Semaforo que controla la cantidad de clientes que van a la caja 
    private Semaphore SC = new Semaphore(1); // Semaforo para atender un cliente a la vez
    private Semaphore SEG;                   // Semaforo de exclusion para el momento de escritura / lectura de las ganancias
    
    public Cashier(Semaphore SEG, Semaphore SCCR) {
        this.SEG = SEG;
        this.SCCR = SCCR;
    }
    
    public void inactivarCajero() throws InterruptedException{
        
//        SC.acquire();
        this.setEstatus(false);
        
    }
    
    public void atenderCliente() throws InterruptedException{
        
//        this.clientesEsperando = this.clientesEsperando + 1;
        SC.acquire();
        this.setEstatus(false);
//        this.clientesEsperando = this.clientesEsperando - 1;
        
    }
    
    public void despacharCliente(int id, int monto){
        
        try {
            
//            if(clientesEsperando == 0){
                
                this.setEstatus(true);
                
//            }
            
            SC.release();
            System.out.println("El cajero " + id + " ha despachado a un cliente!");
            
            // Permite que otro cliente pase a los cajeros
            SCCR.release();
            
            // El cajero solicita editar las ganancias
            this.SEG.acquire();
            
            // Se suma lo que consumio el cliente con las ganancias
            Gama.ganancias += monto;
            Interfaz.txtEarnings.setText(Integer.toString(Gama.ganancias));
            System.out.println("El cajero " + id + " ha facturado " + monto);
            
            // Editada las ganancias, suelta el semaforo
            this.SEG.release();
            
        } catch (InterruptedException ex) {
            
            Logger.getLogger(Cashier.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        
    }
    
    // Metodo para que el cajero procese un producto con su respectivo tiempo
    public void procesarProducto(int id) throws InterruptedException{
        
        System.out.println("El cajero " + id + " se encuentra procesando un producto.");
        Thread.sleep(Gama.tiempoHora/60);
        System.out.println("El cajero " + id + " ha procesado un producto!");
        
    }
    
    public void setEstatus(boolean estatus){
        this.estatus = estatus;
    }

    public boolean getEstatus() {
        return estatus;
    }

    public int getClientesEsperando() {
        return clientesEsperando;
    }

    public void setClientesEsperando(int clientesEsperando) {
        this.clientesEsperando = clientesEsperando;
    }

    public Semaphore getSC() {
        return SC;
    }

    public void setSC(Semaphore SC) {
        this.SC = SC;
    }

}
