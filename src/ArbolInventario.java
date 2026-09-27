public class ArbolInventario {
    
    private Producto raiz;  

    public ArbolInventario() {
        this.raiz = null;
    }

    public boolean estaVacio() {
        return raiz == null;
    }

    public void insertar(int id, String nombre) {
        raiz = insertarRecursivo(raiz, id, nombre);
    }

    private Producto insertarRecursivo(Producto actual, int id, String nombre) {

        if (actual == null) {
            return new Producto(id, nombre);
        }
        if (id < actual.getId()) {
            actual.setIzquierdo(insertarRecursivo(actual.getIzquierdo(), id, nombre));
        }
        else if (id > actual.getId()) {
            actual.setDerecho(insertarRecursivo(actual.getDerecho(), id, nombre));
        }
        return actual;  
    }

    public void mostrarInorden() {
        mostrarInordenRecursivo(raiz);  
    }

    private void mostrarInordenRecursivo(Producto nodo) {
        if (nodo != null) {                              
            mostrarInordenRecursivo(nodo.getIzquierdo());  // 1. toda la rama izquierda
            imprimir(nodo);                                // 2. el nodo (la raíz de este subárbol)
            mostrarInordenRecursivo(nodo.getDerecho());    // 3. toda la rama derecha
        }
    }

    public String buscar(int id) {
        return buscarRecursivo(raiz, id) ? "ID encontrado en el sistema." : "El ID no existe.";
    }

        private boolean buscarRecursivo(Producto actual, int id) {
        if (actual == null) return false;           // Caso base: se acabó la rama, no está
        if (id == actual.getId()) return true;      // Caso base: ¡lo encontró!

        // Si el id buscado es menor sigue por la izquierda; si no, por la
        // derecha. Nunca revisa las dos ramas: por eso la búsqueda es rápida.
        return id < actual.getId()
            ? buscarRecursivo(actual.getIzquierdo(), id)
            : buscarRecursivo(actual.getDerecho(), id);
    }

        private void imprimir(Producto nodo) {
        System.out.println("Producto: " + nodo.getId() + " | Nombre: " + nodo.getNombre());
    }
}