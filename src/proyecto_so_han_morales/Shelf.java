package proyecto_so_han_morales;

public class Shelf {
    
    // El estante seria el buffer en nuestro simulador
    
    // ATRIBUTOS DE LA CLASE
    
    private int capacidad;
    private int[] productos;
    private int id;
    
    // CONSTRUCTOR DE LA CLASE
    
    public Shelf(int capacidad, int id) {
        this.capacidad = capacidad;
        this.productos = new int[capacidad];
        this.id = id;
        
        for (int i = 0; i < this.capacidad; i++) {
            // Se llena cada casilla con los precios del producto
            this.productos[i] = (int) ((Math.random() * 10) + 1);
        }
    }
    
    // GETTERS Y SETTERS

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public int[] getProductos() {
        return productos;
    }

    public void setProductos(int[] productos) {
        this.productos = productos;
    }
    
    public void setProducto(int index, int dato) {
        this.productos[index] = dato;
    }
    
    public int getProducto(int index) {
        return this.productos[index];
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    // Metodo que te retorna la cantidad de productos disponibles en un estante
    public int getCantidadProductos() {
        
        int cantidad = 0;
        
        for (int i = 0; i < this.productos.length; i++) {
            if (this.productos[i] != 0) {
                cantidad ++;
            }
        }
        
        return cantidad;
        
    }
    
}
