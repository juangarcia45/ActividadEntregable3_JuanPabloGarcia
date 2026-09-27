import java.util.Scanner;

/**
 * Clase principal que ejecuta la interfaz por consola del sistema de inventario.
 * Gestiona la entrada del usuario, valida excepciones y comunica las peticiones
 * con la estructura de datos del árbol binario.
 */
public class Main {

    /**
     * Punto de entrada principal del programa.
     * 
     * @param args Argumentos de la línea de comandos (no utilizados).
     */
    public static void main(String[] args) {

        // Instancia de la estructura de datos
        ArbolInventario miArbol = new ArbolInventario();
        Scanner sc = new Scanner(System.in); 
        int opcion = -1;  

        // Bucle interactivo del menú principal
        while (opcion != 0) {
            
            System.out.println("\n--- INVENTARIO DE PRODUCTOS ---");
            System.out.println("1. Registrar Producto");
            System.out.println("2. Ver Inventario Inorden");
            System.out.println("3. Buscar Producto");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
                
            // Control de captura de opciones para prevenir fallos por entradas no numéricas
            try {
                opcion = sc.nextInt();  
            } catch (Exception e) {
                System.out.println("Entrada inválida. Debe ingresar un número.");
                sc.next(); // Limpia la entrada no válida
                continue;   // Vuelve a solicitar la opción en el bucle
            }

            // Evaluación de la opción seleccionada por el usuario
            switch (opcion) {
                case 1:  // Registrar un nuevo producto en el árbol
                    System.out.print("Ingrese ID del producto: ");
                    try {
                        int id = sc.nextInt();
                        sc.nextLine();  // Limpia el salto de línea pendiente tras sc.nextInt()
                        
                        System.out.print("Nombre de Producto: ");
                        String nombre = sc.nextLine();  // Captura el nombre del producto
                        
                        miArbol.insertar(id, nombre);   // Inserta el registro en el árbol BST
                        System.out.println("Registrado con éxito.");
                    } catch (Exception e) {
                        System.out.println("ID debe ser un número válido.");
                        sc.next(); // Limpia la entrada inválida
                    }
                    break;
                        
                case 2:  // Mostrar el recorrido Inorden (orden ascendente por ID)
                    mostrarEncabezadoRecorrido("INORDEN", "Izquierda -> Raíz -> Derecha");
                    mostrarDirectorio(miArbol, 2);
                    break;

                case 3:  // Búsqueda de un producto por su clave ID
                    System.out.print("ID a buscar: ");
                    try {                        
                        int buscaId = sc.nextInt();
                        System.out.println(miArbol.buscar(buscaId));
                    } catch (Exception e) {
                        System.out.println("ID debe ser un número válido.");
                        sc.next(); // Limpia la entrada inválida
                    }
                    break;
                        
                case 0:  // Salir del programa
                    System.out.println("Saliendo del sistema...");
                    break;
                        
                default:  // Manejo de opciones fuera del rango válido
                    System.out.println("Opción no válida.");
            }
        }
        
        // Cierre del recurso Scanner al terminar la aplicación
        sc.close(); 
    }

    /**
     * Método auxiliar para mostrar un encabezado descriptivo del recorrido realizado.
     * 
     * @param nombre Nombre del recorrido (ej: INORDEN).
     * @param orden  Secuencia lógica del recorrido (ej: Izquierda -> Raíz -> Derecha).
     */
    private static void mostrarEncabezadoRecorrido(String nombre, String orden) {
        System.out.println("\n" + nombre + " | " + orden);
    }

    /**
     * Método auxiliar para verificar el estado del inventario y mostrar sus elementos.
     * 
     * @param arbol     Instancia del árbol de inventario a consultar.
     * @param recorrido Tipo de recorrido a ejecutar.
     */
    private static void mostrarDirectorio(ArbolInventario arbol, int recorrido) {
        // Valida si el árbol está vacío antes de intentar imprimir
        if (arbol.estaVacio()) {
            System.out.println("Su directorio: (vacío, aún no ha registrado productos)");
            return;
        }

        System.out.println("Su inventario:");
        arbol.mostrarInorden();    // Imprime los elementos ordenados de menor a mayor
    }
}