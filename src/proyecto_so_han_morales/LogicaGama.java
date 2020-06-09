package proyecto_so_han_morales;

import java.util.concurrent.Semaphore;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.JOptionPane;
import static java.lang.Integer.parseInt; // Se utiliza para leer datos y realizar la conversion a int de manera mas eficaz

public class LogicaGama {
    
    // ATRIBUTOS DE LA CLASE
    private Interfaz interfaz;
    
    private int tiempoHora;
    private int estantesIni, estantesMax;
    private int capacidadMax;
    private int cajasIni, cajasMax;
    private int carritosIni, carritosMax;
    
    // Semaforos para cada estante
    private Semaphore SP;
    
    // Constructor de la clase
    public LogicaGama() {
        
    }
    
    // METODOS DE LA CLASE
    
    // Metodo para leer los datos iniciales del archivo de texto
    public void leerDatosIniciales() throws FileNotFoundException {
        
        Scanner doc = new Scanner(new File("Ruta del documento"));
        String line = doc.nextLine();
        
        // Se procede a leer cada dato en el archivo y se guarda en su variable respectiva
        this.tiempoHora = parseInt(line.substring(20,25).trim());
        System.out.println(this.tiempoHora);
        line = doc.nextLine();
        
        // Se tiene que verificar la validez de cada dato
        if(this.tiempoHora < 0){
            JOptionPane.showMessageDialog(null, "Dato invalido");  
        }

        
    }
    
    
    
    
    // Getters y setters
    
    
    
}
