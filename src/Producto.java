public class Producto{

    private int id;              
    private String nombre;       
    private Producto izquierdo;  
    private Producto derecho;    

    public Producto(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.izquierdo = null;  // No tiene hijo menor todavía
        this.derecho = null;    // No tiene hijo mayor todavía
    }

    // Getters: permiten leer los datos desde otra clase
    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public Producto getIzquierdo() { return izquierdo; }
    public Producto getDerecho() { return derecho; }

    // Setters: permiten modificar los datos desde otra clase
    public void setId(int id) { this.id = id; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setIzquierdo(Producto izquierdo) { this.izquierdo = izquierdo; }
    public void setDerecho(Producto derecho) { this.derecho = derecho; }

}
