/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_so_han_morales;

import java.util.concurrent.Semaphore;


public class Cashier extends Thread{
    
    private boolean estatus = true; //Variable que permite identificar si el cajero esta ocupado
    private int clientesEsperando = 0; //Variable que identifica cuantos clientes estan haciendo cola en el cajero 
    private Semaphore SC = new Semaphore(1);
    
    public Cashier() {
        
    }
    
    public void inactivarCajero() throws InterruptedException{
        SC.acquire();
        this.setEstatus(false);
    }
    
    public void atenderCliente() throws InterruptedException{
        this.clientesEsperando = this.clientesEsperando + 1;
        SC.acquire();
        this.setEstatus(false);
        this.clientesEsperando = this.clientesEsperando - 1;
    }
    
    public void despacharCliente(){
        if(clientesEsperando == 0){
            this.setEstatus(true);
        }
        SC.release();
    }
    
    public void procesarProducto(int id) throws InterruptedException{
        
        System.out.println("El cajero " + id + " se encuentra procesando un producto.");
        Thread.sleep(60*1000);
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
    

}
