/**
 * Clase que gestiona la estructura de datos de tipo Árbol Binario de Búsqueda (BST).
 * Permite la inserción, búsqueda y recorrido en orden de los productos en el inventario.
 */
public class ArbolInventario {
    
    // Raíz del árbol binario de búsqueda
    private Producto raiz;  

    /**
     * Constructor que inicializa un árbol de inventario vacío.
     */
    public ArbolInventario() {
        this.raiz = null;
    }

    /**
     * Verifica si el árbol de inventario se encuentra actualmente sin elementos.
     * 
     * @return true si la raíz es null (está vacío), false en caso contrario.
     */
    public boolean estaVacio() {
        return raiz == null;
    }

    /**
     * Método público para insertar un nuevo producto en el árbol.
     * Inicia la llamada al proceso recursivo desde la raíz.
     * 
     * @param id     Identificador único del producto (clave de ordenamiento).
     * @param nombre Nombre del producto.
     */
    public void insertar(int id, String nombre) {
        raiz = insertarRecursivo(raiz, id, nombre);
    }

    /**
     * Método helper recursivo para encontrar la posición correcta e insertar un producto.
     * 
     * @param actual Nodo actual desde el cual se evalúa la posición.
     * @param id     Identificador numérico a evaluar.
     * @param nombre Nombre del producto a registrar.
     * @return El nodo actualizado tras la inserción.
     */
    private Producto insertarRecursivo(Producto actual, int id, String nombre) {
        // Caso base: se llegó a una hoja o posición vacía, se crea el nuevo Producto
        if (actual == null) {
            return new Producto(id, nombre);
        }

        // Si el ID es menor que el nodo actual, se inserta en el subárbol izquierdo
        if (id < actual.getId()) {
            actual.setIzquierdo(insertarRecursivo(actual.getIzquierdo(), id, nombre));
        }
        // Si el ID es mayor que el nodo actual, se inserta en el subárbol derecho
        else if (id > actual.getId()) {
            actual.setDerecho(insertarRecursivo(actual.getDerecho(), id, nombre));
        }

        // Retorna el nodo actual (sin cambios en este nivel)
        return actual;  
    }

    /**
     * Inicia la impresión de todos los productos registrados utilizando
     * un recorrido Inorden (de menor a mayor según el ID).
     */
    public void mostrarInorden() {
        mostrarInordenRecursivo(raiz);  
    }

    /**
     * Método helper recursivo para recorrer el árbol en secuencia Inorden:
     * 1. Subárbol Izquierdo
     * 2. Nodo Raíz / Actual
     * 3. Subárbol Derecho
     * 
     * @param nodo Nodo desde el cual se realiza la visita recursiva.
     */
    private void mostrarInordenRecursivo(Producto nodo) {
        if (nodo != null) {                            
            mostrarInordenRecursivo(nodo.getIzquierdo());  // 1. Visitar subárbol izquierdo (menores)
            imprimir(nodo);                                // 2. Procesar el nodo actual
            mostrarInordenRecursivo(nodo.getDerecho());    // 3. Visitar subárbol derecho (mayores)
        }
    }

    /**
     * Busca un producto en el árbol según su ID.
     * 
     * @param id Identificador único a buscar.
     * @return Mensaje indicando si el ID fue encontrado o no.
     */
    public String buscar(int id) {
        return buscarRecursivo(raiz, id) ? "ID encontrado en el sistema." : "El ID no existe.";
    }

    /**
     * Método helper recursivo para la búsqueda eficiente en un BST.
     * Aprovecha la propiedad del árbol (menores a la izq, mayores a la der) para descargas rápidas.
     * 
     * @param actual Nodo actual en la iteración recursiva.
     * @param id     Identificador buscado.
     * @return true si se halla el ID, false si se llega a un nodo null sin encontrarlo.
     */
    private boolean buscarRecursivo(Producto actual, int id) {
        // Caso base 1: Se llegó al final de la rama sin encontrar el ID
        if (actual == null) return false;           
        
        // Caso base 2: Se encontró el ID en el nodo actual
        if (id == actual.getId()) return true;      

        // Búsqueda binaria: decide si continuar por la izquierda o por la derecha
        return id < actual.getId()
            ? buscarRecursivo(actual.getIzquierdo(), id)
            : buscarRecursivo(actual.getDerecho(), id);
    }

    /**
     * Formatea e imprime en consola la información básica del producto.
     * 
     * @param nodo Nodo del tipo Producto a desplegar.
     */
    private void imprimir(Producto nodo) {
        System.out.println("Producto: " + nodo.getId() + " | Nombre: " + nodo.getNombre());
    }
}