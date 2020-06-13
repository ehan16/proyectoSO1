package proyecto_so_han_morales;

import java.util.concurrent.Semaphore;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.JOptionPane;
import static java.lang.Integer.parseInt; // Se utiliza para leer datos y realizar la conversion a int de manera mas eficaz
import java.util.ArrayList;

public class Gama {
    
    // ATRIBUTOS DE LA CLASE
    
    public static ArrayList<Employee> empleado = new ArrayList<Employee>();
    public static ArrayList<Client> cliente = new ArrayList<Client>();
    public static Shelf estante[];
    
    public static int tiempoHora;    // Tiempo que dura un dia en el programa
    public static int estantesMax;   // Maximo de los estantes
    public static int capacidadMax;  // Capacidad maxima de productos por estante
    public static int cajasMax;      // Maximo de cajas
    public static int carritosMax;   // Maximo de carritos
    
    public static boolean deseoEliminarCarritoEnUso = false;
    
    // Semaforos (EM = exclusion mutua, C = cliente, E = empleado)
    private Semaphore[] SEME, SCE, SEE;  // Semaforos de los estantes
    private Semaphore SCC;               // Semaforo del carrito de compras
    private Semaphore SEMCR, SCCR, SECR; // Semaforo de las cajas registradoras
    private Semaphore SHL;               // Semaforo de las horas laboradas
    public static Semaphore sControlEliminaciones = new Semaphore(1); // Semaforo control de eliminaciones
    
    public static int[] pCE; // Apunta al estante para el cliente
    public static int[] pEE; // Apunta al estante para el empleado
    
    //Cajeros operando (Herencia de clase Semaphore)
    public static Cashier[] cashiers;
    
    // Datos a mostrar en la interfaz grafica
    public static int clientes;            // Numero de clientes totales
    public static int clientesActivos = 0; // Contador de los clientes en el sistema 
    public static int clientesEspera = 0;  // Contador de los clientes  esperando
    public static int estantes;            // Contador de los estantes
    public static int carritos;            // Contador de los carritos
    public static int cajeros;             // Contador de los cajeros
    public static int horasLaboradas = 0;  // Contador de las horas que se han cursado en el dia
    public static int ganancias = 0;       // Contador de las ganancias
    
    private int idC = 1;   // Se utilizara para el id de los clientes
    private int idE = 1;    // Se utilizara para el id de los empleados
    private Gama gama;
    private Manager gerente;
//    private boolean open = true;
    
    // CONSTRUCTOR DE LA CLASE 
    
    public Gama() throws InterruptedException {

    }
    
    // METODOS DE LA CLASE
    
    /*
     * Metodo para leer los datos iniciales del archivo de texto
     */
    public void leerDatosIniciales() throws FileNotFoundException {
        
        System.out.println();
        //Scanner doc = new Scanner(new File("/DatosIniciales.txt"));
        Scanner doc = new Scanner(new File("src/proyecto_SO_Han_Morales/DatosIniciales.txt"));
        String line = doc.nextLine();
        
        // Se procede a leer cada dato en el archivo y se guarda en su variable respectiva
        Gama.tiempoHora = parseInt(line.substring(20, 30).trim()) * 1000;
        System.out.println(Gama.tiempoHora);
        line = doc.nextLine();
        
        // Se tiene que verificar la validez de cada dato y corregirla de ser necesario
        if(Gama.tiempoHora < 0){
            JOptionPane.showMessageDialog(null, "Dato invalido");  
            tiempoHora = 100000;
        }
        
        Gama.estantes = parseInt(line.substring(20, 25).trim());
        System.out.println(Gama.estantes);
        line = doc.nextLine();
        
        if(Gama.estantes < 0){
            JOptionPane.showMessageDialog(null, "Dato invalido");
            estantes = 1;
        }
        
        Gama.estantesMax = parseInt(line.substring(20, 25).trim());
        System.out.println(Gama.estantesMax);
        line = doc.nextLine();
        
        if(Gama.estantesMax < 0){
            JOptionPane.showMessageDialog(null, "Dato invalido");  
            estantesMax = 3;
        }
        
        Gama.capacidadMax = parseInt(line.substring(20, 25).trim());
        System.out.println(Gama.capacidadMax);
        line = doc.nextLine();
        
        if(Gama.capacidadMax < 0){
            JOptionPane.showMessageDialog(null, "Dato invalido");  
            capacidadMax = 10;
        }
        
        Gama.cajeros = parseInt(line.substring(20, 25).trim());
        System.out.println(Gama.cajeros);
        line = doc.nextLine();
        
        if(Gama.cajeros < 0){
            JOptionPane.showMessageDialog(null, "Dato invalido");
            cajeros = 4;
        }
        
        Gama.cajasMax = parseInt(line.substring(20, 25).trim());
        System.out.println(Gama.cajasMax);
        line = doc.nextLine();
        
        if(Gama.cajasMax < 0){
            JOptionPane.showMessageDialog(null, "Dato invalido");  
            cajasMax = 10;
        }
        
        Gama.carritos = parseInt(line.substring(20, 25).trim());
        System.out.println(Gama.carritos);
        line = doc.nextLine();
        
        if(Gama.carritos < 0){
            JOptionPane.showMessageDialog(null, "Dato invalido");  
            carritos = 10;
        }
        
        Gama.carritosMax = parseInt(line.substring(20, 25).trim());
        System.out.println(Gama.carritosMax);
            
        if(Gama.carritosMax < 0){
            JOptionPane.showMessageDialog(null, "Dato invalido"); 
            carritosMax = 20;
        }

    }
    
    /*
     * Metodo que crea los semaforos
    */
    public void CrearSemaforos() throws InterruptedException {
        
        // Semaforos de los estantes
        
        // Se crean los arreglos
        SEME = new Semaphore[Gama.estantesMax];
        SEE = new Semaphore[Gama.estantesMax];
        SCE = new Semaphore[Gama.estantesMax];
        pCE = new int[Gama.estantesMax];
        pEE = new int[Gama.estantesMax];
        
        
        // Se crean todos los semaforos
        for (int i = 0; i < SEME.length; i++) {
            this.SEME[i] = new Semaphore(1);
        }
        
        for (int i = 0; i < SEE.length; i++) {
            this.SEE[i] = new Semaphore(Gama.capacidadMax);
        }
        
        for (int i = 0; i < SCE.length; i++) {
            this.SCE[i] = new Semaphore(0);
        }
        
        // Semaforos de las cajas registradoras
        this.SEMCR = new Semaphore(1);
        this.SECR = new Semaphore(Gama.cajeros);
        this.SCCR = new Semaphore(0);
        
        // Semaforo del gerente y jefe para las horas
        this.SHL = new Semaphore(8);
        
        // Semaforo de los carritos totales de compra
        this.SCC = new Semaphore(Gama.carritosMax);
        // Inicialmente se dejan libres solo los carritos minimos
        this.SCC.acquire(Gama.carritosMax - Gama.carritos);
        
        // Se habilita la maxima cantidad de cajeros
        Gama.cashiers = new Cashier[Gama.cajasMax];
        
    }
    
    
    /*
     *  Metodo para inicializar los apuntadores y estantes
    */
    public void inicializarValores() throws InterruptedException {
        
        // Se crean los estantes iniciales
        Gama.estante = new Shelf[Gama.estantesMax];     
        for (int i = 0; i < estantes; i++) {         
            Gama.estante[i] = new Shelf(capacidadMax, i + 1);
        }
        
        // Se inicializan los apuntadores del cliente
        for (int i = 0; i < pCE.length; i++) {
            pCE[i] = 0;
        }
        
        // Se inicializan los apuntadores del empleado
        for (int i = 0; i < pEE.length; i++) {
            pEE[i] = 0;
        }
        
        // Se inactivan los cajeros que inicialmente no estaran operando
        // Y el resto quedan activos
        for (int i = 0; i < Gama.cajasMax; i++){
            
            if ( i < Gama.cajeros){
                
                Gama.cashiers[i] = new Cashier();
                
            }else{
               
                Gama.cashiers[i] = new Cashier();
                Gama.cashiers[i].setEstatus(false);
                Gama.cashiers[i].inactivarCajero();
                
            }
            
        }
        
    }
    
    
    /*
     *  Metodo para crear hilos
    */
    public void crearHilo(int tipo, int numEstante) {
        
        switch(tipo) {
            
            case 0: 
                
                // Se crea un empleado
                Employee e = new Employee(idE, SEME[numEstante], SEE[numEstante], SCE[numEstante]); 
                empleado.add(e);
                System.out.println("Se ha creado el empleado " + idE);
                idE++;
                e.start();
                break;
                
            case 1: 
                
                // Se crea un cliente
                Client c = new Client(SEME, SEE, SCE, SEMCR, SECR, SCCR, SCC, idC);
                cliente.add(c);
                System.out.println("El cliente " + idC + " se encuentra fuera de las instalaciones del Gama.");
                idC++;
                c.start();
                break;

            default:
                break;
            
        }   
        
    }
    
    /*
     * Metodo para iniciar el simulador
    */
    public void Start() throws FileNotFoundException, InterruptedException{
        
        this.leerDatosIniciales();
        this.CrearSemaforos();
        this.inicializarValores();
        
        // Se muestran los datos en la interfaz
        Interfaz.txtCashier.setText(Integer.toString(Gama.cajeros));
        Interfaz.txtShelf.setText(Integer.toString(Gama.estantes));
        Interfaz.txtShoppingCarts.setText(Integer.toString(Gama.carritos));
        
        // Se crean todos los hilos iniciales
        
        // los hilos de los empleados que no pueden ser mayor a la cantidad de estantes
        for (int i = 0; i < estantes; i++) {
            
            crearHilo(0, i);
            
        }
        
        // los hilos del jefe y gerente
        Boss b = new Boss(Gama.tiempoHora, this.SHL);
        b.start();
        
        Manager m = new Manager(this.SHL);
        m.start();

        while (true) {
            
            // Se crean los hilos de los clientes de manera indefinida cada 5 min
            crearHilo(1, 0);
            Thread.sleep((5*Gama.tiempoHora)/60);
            
        }
        
    }
    
    
    // GETTERS Y SETTERS
    
    public Semaphore[] getSEME() {
        return SEME;
    }

    public void setSEME(Semaphore[] SEME) {
        this.SEME = SEME;
    }

    public Semaphore[] getSCE() {
        return SCE;
    }

    public void setSCE(Semaphore[] SCE) {
        this.SCE = SCE;
    }

    public Semaphore[] getSEE() {
        return SEE;
    }

    public void setSEE(Semaphore[] SEE) {
        this.SEE = SEE;
    }

    public Semaphore getSCC() {
        return SCC;
    }

    public void setSCC(Semaphore SCC) {
        this.SCC = SCC;
    }

    public Semaphore getSEMCR() {
        return SEMCR;
    }

    public void setSEMCR(Semaphore SEMCR) {
        this.SEMCR = SEMCR;
    }

    public Semaphore getSCCR() {
        return SCCR;
    }

    public void setSCCR(Semaphore SCCR) {
        this.SCCR = SCCR;
    }

    public Semaphore getSECR() {
        return SECR;
    }

    public void setSECR(Semaphore SECR) {
        this.SECR = SECR;
    }

    public Gama getGama() {
        return gama;
    }

    public void setGama(Gama gama) {
        this.gama = gama;
    }

    public Manager getGerente() {
        return gerente;
    }

    public void setGerente(Manager gerente) {
        this.gerente = gerente;
    }

    public int getpCE(int index) {
        return pCE[index];
    }

    public void setpCE(int index, int value) {
        Gama.pCE[index] = value;
    }

    public int getpEE(int index) {
        return pEE[index];
    }

    public void setpEE(int index, int value) {
        Gama.pEE[index] = value;
    }
    
}
