/**
 * Clase que representa un producto dentro del sistema de inventario.
 * Funciona además como un NODO dentro de la estructura de datos
 * Árbol Binario de Búsqueda (BST).
 */
public class Producto {

    // --- Atributos del Producto ---
    private int id;             // Identificador único del producto (clave para el árbol)
    private String nombre;      // Nombre o descripción del producto

    // --- Punteros/Referencias para la estructura de Árbol Binario ---
    private Producto izquierdo; // Referencia al subárbol/hijo izquierdo (IDs menores)
    private Producto derecho;   // Referencia al subárbol/hijo derecho (IDs mayores)

    /**
     * Constructor para inicializar un nuevo producto (nodo).
     * 
     * @param id     Identificador numérico único del producto.
     * @param nombre Nombre del producto.
     */
    public Producto(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.izquierdo = null;  // Al crearse, aún no tiene hijo izquierdo (menor)
        this.derecho = null;    // Al crearse, aún no tiene hijo derecho (mayor)
    }

    // ==========================================
    // GETTERS: Métodos para obtener los valores
    // ==========================================

    /**
     * Obtiene el ID del producto.
     * @return Identificador único en formato entero.
     */
    public int getId() { 
        return id; 
    }

    /**
     * Obtiene el nombre del producto.
     * @return Nombre del producto en formato Cadena (String).
     */
    public String getNombre() { 
        return nombre; 
    }

    /**
     * Obtiene la referencia al nodo hijo izquierdo (elementos menores).
     * @return Objeto Producto o null si no existe.
     */
    public Producto getIzquierdo() { 
        return izquierdo; 
    }

    /**
     * Obtiene la referencia al nodo hijo derecho (elementos mayores).
     * @return Objeto Producto o null si no existe.
     */
    public Producto getDerecho() { 
        return derecho; 
    }

    // ==============================================
    // SETTERS: Métodos para actualizar los valores
    // ==============================================

    /**
     * Establece o modifica el ID del producto.
     * @param id Nuevo ID del producto.
     */
    public void setId(int id) { 
        this.id = id; 
    }

    /**
     * Establece o modifica el nombre del producto.
     * @param nombre Nuevo nombre del producto.
     */
    public void setNombre(String nombre) { 
        this.nombre = nombre; 
    }

    /**
     * Conecta este nodo con su hijo izquierdo (subárbol izquierdo).
     * @param izquierdo Nodo con un ID menor.
     */
    public void setIzquierdo(Producto izquierdo) { 
        this.izquierdo = izquierdo; 
    }

    /**
     * Conecta este nodo con su hijo derecho (subárbol derecho).
     * @param derecho Nodo con un ID mayor.
     */
    public void setDerecho(Producto derecho) { 
        this.derecho = derecho; 
    }
}