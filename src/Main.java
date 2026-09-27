import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

    ArbolInventario miArbol = new ArbolInventario();
    Scanner sc = new Scanner(System.in); 
    int opcion = -1;  

    while (opcion != 0) {
        
        System.out.println("\n--- INVENTARIO DE PRODUCTOS ---");
        System.out.println("1. Registrar Producto");
        System.out.println("2. Ver Inventario Inorden");
        System.out.println("3. Buscar Producto");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opción: ");
            
        try {
            opcion = sc.nextInt();  
        } catch (Exception e) {
            System.out.println("Entrada inválida. Debe ingresar un número.");
            sc.next(); 
            continue;   
        }

            // Según la opción elegida, hace una cosa u otra
        switch (opcion) {
            case 1:  // Registrar nueva extensión
                System.out.print("Ingrese ID del producto: ");
                try {
                    int id = sc.nextInt();
                    sc.nextLine();  // Limpia el buffer después de leer número
                    System.out.print("Nombre de Producto: ");
                    String nombre = sc.nextLine();  // Lee el nombre
                    miArbol.insertar(id, nombre);   // Inserta en el árbol
                    System.out.println("Registrado con éxito.");
                } catch (Exception e) {
                    System.out.println("ID debe ser un número válido.");
                    sc.next();
                }
                break;
                    
            case 2:  // Recorrido inorden (menor a mayor)
                mostrarEncabezadoRecorrido("INORDEN", "Izquierda -> Raíz -> Derecha");
                mostrarDirectorio(miArbol, 2);
                break;


            case 3:  // Buscar una extensión por su ID
                System.out.print("ID a buscar: ");
                try {                        
                    int buscaId = sc.nextInt();
                    System.out.println(miArbol.buscar(buscaId));
                } catch (Exception e) {
                    System.out.println("ID debe ser un número válido.");
                    sc.next();
                }
                break;

                    
            case 0:  // Salir del programa
                System.out.println("Saliendo del sistema...");
                break;
                    
            default:  // Opción no válida
                System.out.println("Opción no válida.");
        }
        
    }
        sc.close(); 
    }


    private static void mostrarEncabezadoRecorrido(String nombre, String orden) {
        System.out.println("\n" + nombre + " | " + orden);
    }

    private static void mostrarDirectorio(ArbolInventario arbol, int recorrido) {
        // Si todavía no hay extensiones, avisa en vez de no imprimir nada
        if (arbol.estaVacio()) {
            System.out.println("Su directorio: (vacío, aún no ha registrado productos)");
            return;
        }

        System.out.println("Su inventario:");
        arbol.mostrarInorden();    // menor a mayor

    }
}